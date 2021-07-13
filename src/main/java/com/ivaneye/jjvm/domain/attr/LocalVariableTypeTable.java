package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.attr.sub.LocalVariableTypeInfo;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-11 10:11:01
 */
@Data
public class LocalVariableTypeTable extends Attribute {

    private U2 localVariableTypeTableLength;
    private LocalVariableTypeInfo[] localVariableTypeTable;
}
