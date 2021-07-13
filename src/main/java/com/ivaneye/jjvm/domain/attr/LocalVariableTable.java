package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.attr.sub.LocalVariableInfo;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-11 10:08:23
 */
@Data
public class LocalVariableTable extends Attribute {

    private U2 localVariableTableLength;
    private LocalVariableInfo[] localVariableTable;
}
