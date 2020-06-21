package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.UUIDUtil;

public class DefaultStringGenerator implements StringGenerator {
    @Override
    public String generate() {
        return UUIDUtil.uuid();
    }
}
