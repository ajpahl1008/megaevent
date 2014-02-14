package com.pahlsoft.megaevent.ui.utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PojoFactoryImpl implements PojoFactory<Object> {

    @Override
    public Object initNull(Object type) {

        String shellName = type.getClass().getName();
        Object shell = type.getClass();

        Field[] fields = type.getClass().getFields();

        // Build The Class
        Method[] methods = fields.getClass().getMethods();

        try {
            Class aClass = Class.forName("com.pahlsoft.com.blah");
        }


        return null;
    }
}
