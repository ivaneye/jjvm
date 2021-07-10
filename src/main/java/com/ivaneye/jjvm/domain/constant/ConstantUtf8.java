package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;

/**
 * @author ivaneye
 * @since 2021-07-10 22:45:09
 */
public class ConstantUtf8 implements Constant {

    private U1 tag;
    private U2 length;
    private byte[] arr;
    private ClassInfo classInfo;

    public ConstantUtf8(U1 tag, U2 length, byte[] arr, ClassInfo classInfo) {
        this.tag = tag;
        this.length = length;
        this.arr = arr;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        return "Utf8";
    }

    @Override
    public String value() {
        return new String(arr);
    }

    @Override
    public String toString() {
        return type() + " " + value();
    }
}
