package ru.job4j.io;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        String name = "Petr Arsentev";
        int age = 33;
        byte byteValue = 2;
        short shortValue = 3;
        long longValue = 9L;
        float floatValue = 2.3F;
        boolean booleanValue = false;
        char charValue = 102;
        LOG.debug("User info name : {}, age : {}, byteValue : {}, shortValue : {}, longValue : {}, floatValue : {}, booleanValue : {}, charValue : {}",
                name, age, byteValue, shortValue, longValue, floatValue, booleanValue, charValue);
    }
}