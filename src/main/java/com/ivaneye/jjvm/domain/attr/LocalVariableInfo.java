package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U2;

/**
 * @author ivaneye
 * @since 2021-07-11 10:07:19
 */
public class LocalVariableInfo implements Attribute {

    private U2 startPc;
    private U2 length;
    private U2 nameIndex;
    private U2 descriptorIndex;
    private U2 index;
}
