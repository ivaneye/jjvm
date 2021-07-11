package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;

/**
 * @author ivaneye
 * @since 2021-07-11 10:08:23
 */
public class LocalVariableTable {

    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U2 localVariableTableLength;
    private LocalVariableInfo[] localVariableTable;
}
