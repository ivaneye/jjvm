package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U4;

/**
 * @author ivaneye
 * @since 2021-07-10 22:45:09
 */
public class ConstantFloat implements Constant {

    private U1 tag;
    private U4 bytes;
    private ClassInfo classInfo;

    public ConstantFloat(U1 tag, U4 bytes, ClassInfo classInfo) {
        this.tag = tag;
        this.bytes = bytes;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        return "Float";
    }

    @Override
    public String value() {
        Integer bits = bytes.toInt();
        int s = -1;
        if (bits >> 31 == 0) {
            s = 1;
        }
        int e = bits >> 23 & 0xff;
        int m;
        if (e == 0) {
            m = (bits & 0x7fffff) << 1;
        } else {
            m = (bits & 0x7fffff) | 0x800000;
        }
        double result = s * m * Math.pow(2, (e - 150));
        return result + "f";
    }

    @Override
    public String toString() {
        return type() + "    " + value();
    }
}
