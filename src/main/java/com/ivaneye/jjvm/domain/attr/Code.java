package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.attr.sub.ExceptionTable;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ivaneye
 * @since 2021-07-10 23:12:29
 */
@Data
public class Code extends Attribute {

    private U2 maxStack;
    private U2 maxLocals;
    private U4 codeLength;
    private U1[] code;
    private U2 exceptionTableLength;
    private ExceptionTable[] exceptionTable;
    private U2 attributesCount;
    private Attribute[] attributes;

    @Override
    public String info(ClassInfo classInfo) {
        return "Code:\r\n"
                + "  stack=" + maxStack.toInt() + ", locals=" + maxLocals.toInt() + ", args_size=" + "\r\n"
                + Arrays.stream(code).map(it -> it.toInt()).collect(Collectors.toList());
    }
}
