package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.UUIDUtil;

public class DefaultStringGenerator extends AbstractGenerator implements StringGenerator {
    @Override
    public String generate(String type) {
        return UUIDUtil.uuid();
    }
}
