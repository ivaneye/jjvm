package com.ivaneye.jjvm.domain.attr.sub;

import com.ivaneye.jjvm.domain.type.U2;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-11 10:07:19
 */
@Data
public class LocalVariableInfo {

    private U2 startPc;
    private U2 length;
    private U2 nameIndex;
    private U2 descriptorIndex;
    private U2 index;

    public LocalVariableInfo(U2 startPc, U2 length, U2 nameIndex, U2 descriptorIndex, U2 index) {
        this.startPc = startPc;
        this.length = length;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.index = index;
    }
}
