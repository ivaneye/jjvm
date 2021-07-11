package com.ivaneye.jjvm.reader;

import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;

import java.util.Arrays;

/**
 * @author ivaneye
 * @since 2021-07-11 11:22:23
 */
public class CommonReader {

    private byte[] data;

    public CommonReader(byte[] data) {
        this.data = data;
    }

    public U1 readU1() {
        U1 result = new U1(readByteArray(1)[0]);
        return result;
    }

    public U2 readU2() {
        return new U2(readByteArray(2));
    }

    public U4 readU4() {
        return new U4(readByteArray(4));
    }

    public byte[] readByteArray(int size) {
        byte[] tmp = Arrays.copyOfRange(data, 0, size);
        data = Arrays.copyOfRange(data, size, data.length);
        return tmp;
    }
}
