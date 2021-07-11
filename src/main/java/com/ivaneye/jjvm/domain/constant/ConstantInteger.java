package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;

/**
 * @author ivaneye
 * @since 2021-07-10 22:45:09
 */
public class ConstantInteger implements Constant {

    private U1 tag;
    private U4 bytes;
    private ClassInfo classInfo;

    public ConstantInteger(U1 tag, U4 bytes, ClassInfo classInfo) {
        this.tag = tag;
        this.bytes = bytes;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        return "Integer";
    }

    @Override
    public String value() {
        return bytes.toInt() + "";
    }

    @Override
    public String toString() {
        return type() + "    " + value();
    }
}
