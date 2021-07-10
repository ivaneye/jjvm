package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;

/**
 * @author ivaneye
 * @since 2021-07-10 23:12:29
 */
public class Code implements Attribute {

    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U2 maxStack;
    private U2 maxLocals;
    private U4 codeLength;
    private U1[] code;
    private U2 exceptionTableLength;
    private ExceptionTable[] exceptionTable;
    private U2 attributesCount;
    private Attribute[] attributes;
}
