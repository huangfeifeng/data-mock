package com.person.hff.mockdata.generator;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.sql.SQLException;
import java.util.List;


@Slf4j
public class ModelGenerator {
	
	private final static String javaFileName = ".java";

	private final static String packageName = "com.person.hff.mockdata.entities";

	private final static String JSONField = "@JSONField(format = \"yyyy-MM-dd HH:mm:ss\")";

	private static String templateEntity;

	private static String templateField;

	static {
		InputStream inputStream = null;
		// 读取模板
		try {

			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("templates//template_entity.txt");
			byte[] bytes = new byte[inputStream.available()];
			inputStream.read(bytes);
			inputStream.close();

			templateEntity = new String(bytes);

			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("templates//template_field.txt");
			bytes = new byte[inputStream.available()];
			inputStream.read(bytes);
			inputStream.close();

			templateField = new String(bytes);

		} catch (Exception e) {
			log.info("读取模板出错:{}", e.getMessage());
		} finally {
			if(null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	

	public static void main(String[] args) throws SQLException, Exception {
		//String tableName = "person";
        List<String> tableNames = ConnectionUtil.getTableNames();
        for (String tableName : tableNames) {
        	create(tableName);
        	/*if(!tableName.contains("_"))  {
				create(tableName);
			}*/
        }

	}
	
	public static void create(String tableName) throws IOException {
		String className = getClassName(tableName);

		String fileName = className + javaFileName;

		String pathStr = System.getProperty("user.dir") + "/src/main/java/" + packageName.replaceAll("\\.", "/");
		File file = new File(pathStr + "/" + fileName);
		// 创建目录
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		// 创建文件
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String template = templateEntity;

        template = template.replace("${package}", packageName);
        template = template.replace("${className}", className);
        template = template.replace("${tableName}", tableName);


		// 类实体
        template = template.replace("${body}", getBody(tableName));

		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(template);
		bw.flush();
		bw.close();
		
		
	}

	private static String getBody(String tableName) {
		List<String> columnNames = ConnectionUtil.getColumnNames(tableName);
		List<String> columnTypes = ConnectionUtil.getColumnTypes(tableName);
        List<String> columnComments = ConnectionUtil.getColumnComments(tableName);

        StringBuffer buff = new StringBuffer();
		
		for(int i = 0; i < columnNames.size(); i++) {
			String columnName = columnNames.get(i);
			String columnType = columnTypes.get(i);
            String comment = columnComments.get(i);
            String field = "";
			switch(columnType) {
			    // 数值类型
                // 整数
                case "TINYINT" :
                case "SMALLINT":
                case "MEDIUMINT":
                case "INT":
                case "TINYINT UNSIGNED":
                case "INT UNSIGNED":
                case "INTEGER": field = "Integer"; break;
                case "BIGINT":
                case "BIGINT UNSIGNED":field = "Long"; break;
                // 浮点、小数
                case "FLOAT" :
                case "DOUBLE":
                case "DECIMAL UNSIGNED":
                case "DECIMAL": field = "BigDecimal"; break;

                // 日期类型
                case "DATE":
                case "DATETIME":
                case "TIMESTAMP":  field = "Date"; break;

                // 字符串类型
                case "CHAR":
                case "VARCHAR":
                case "TINYBLOB" :
                case "TINYTEXT":
                case "BLOB":
                case "TEXT":field = "String"; break;

			}
			
			String propertyName = getPropertyName(columnName);
			String template = templateField;
			if("Date".equals(field)) {
				template = template.replace("${JSONField}", JSONField);
			} else {
				template = template.replace("${JSONField}", "");
			}
			template = template.replace("${comment}", comment);
			template = template.replace("${columnName}", columnName);
			template = template.replace("${fieldType}", field);
			template = template.replace("${fieldName}", propertyName);

			buff.append(template);
			//buff.append("    /**\n");
			//buff.append("    * " + comment + "\n");
			//buff.append("    */\n");
			//buff.append("    " + "private " + field + " " + propertyName + ";\n\n");
			
		}
		
		return buff.toString();
		
	}

	private static String getPropertyName(String columnName) {
		String[] split = columnName.split("_");
		String propertyName = "";
		for(int i=0; i<split.length; i++) {
			String str = split[i];
			if(i == 0) {
				propertyName = propertyName + str;
			} else {
				propertyName = propertyName + str.substring(0, 1).toUpperCase() + str.substring(1);
			}
		}
		return propertyName;
	}

	private static String getClassName(String tableName) {
		String[] split = tableName.split("_");
		String className = "";
		for(String str : split) {
			className = className + str.substring(0, 1).toUpperCase() + str.substring(1);
		}
		return className;
	}

}
