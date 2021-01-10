package ru.job4j.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4;
        float e = 5.0f;
        double f = 6.0d;
        char g = '7';
        boolean h = true;

        LOG.debug("PrintConsole -> a : {}, b : {}, c : {}, d : {}, e : {}, f : {}, g : {}, h : {}", a, b, c, d, e, f, g, h);
    }
}
