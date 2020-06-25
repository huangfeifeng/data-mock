package com.person.hff.mockdata.annotation.data.custom;

import com.person.hff.mockdata.annotation.data.DefaultStringGenerator;

public class CustomStringGenerator extends DefaultStringGenerator {
    @Override
    public String generate(String type) {
        return "hello world";
    }
}
