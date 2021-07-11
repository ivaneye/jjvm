package com.ivaneye.jjvm.domain.constant;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import com.ivaneye.jjvm.domain.type.U8;

/**
 * @author ivaneye
 * @since 2021-07-10 22:45:09
 */
public class ConstantLong implements Constant {

    private U1 tag;
    private U4 highBytes;
    private U4 lowBytes;
    private ClassInfo classInfo;

    public ConstantLong(U1 tag, U4 highBytes, U4 lowBytes, ClassInfo classInfo) {
        this.tag = tag;
        this.highBytes = highBytes;
        this.lowBytes = lowBytes;
        this.classInfo = classInfo;
    }

    @Override
    public String type() {
        return "Long";
    }

    @Override
    public String value() {
        return new U8(highBytes.toByteArray(), lowBytes.toByteArray()).toLong() + "L";
    }

    @Override
    public String toString() {
        return type() + "    " + value();
    }
}
