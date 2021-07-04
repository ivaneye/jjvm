package com.ivaneye.jjvm.type;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ivaneye
 * @since 2021-07-02 11:16:38
 */
public class U1Test {

    @Test
    public void toInt() {
        Byte b = new Byte((byte) 0xFF);
        U1 u1 = new U1(b);
//        assertEquals(255L, b.intValue());
        System.out.println(Integer.toHexString(-1));
        assertEquals(255, u1.toInt().intValue());
    }
}