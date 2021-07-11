package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U4;
import com.ivaneye.jjvm.domain.type.U8;

/**
 * @author ivaneye
 * @since 2021-07-10 22:45:09
 */
public class ConstantDouble implements Constant {

    private U1 tag;
    private U4 highBytes;
    private U4 lowBytes;
    private ClassInfo classInfo;

    public ConstantDouble(U1 tag, U4 highBytes, U4 lowBytes, ClassInfo classInfo) {
        this.tag = tag;
        this.highBytes = highBytes;
        this.lowBytes = lowBytes;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        return "Double";
    }

    @Override
    public String value() {
        Long bits = new U8(highBytes.toByteArray(), lowBytes.toByteArray()).toLong();
        int s = -1;
        if (bits >> 63 == 0) {
            s = 1;
        }
        long e = (bits >> 52) & 0x7ffL;
        long m;
        if (e == 0) {
            m = (bits & 0xfffffffffffffL) << 1;
        } else {
            m = (bits & 0xfffffffffffffL) | 0x10000000000000L;
        }
        double result = s * m * Math.pow(2, (e - 1075));
        return result + "d";
    }

    @Override
    public String toString() {
        return type() + "    " + value();
    }
}
