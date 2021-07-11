package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;

/**
 * @author ivaneye
 * @since 2021-07-11 10:11:01
 */
public class LocalVariableTypeTable implements Attribute {

    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U2 localVariableTypeTableLength;
    private LocalVariableTypeInfo[] localVariableTypeTable;
}
