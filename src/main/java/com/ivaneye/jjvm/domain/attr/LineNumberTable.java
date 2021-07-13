package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.attr.sub.LineNumberInfo;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-10 23:22:23
 */
@Data
public class LineNumberTable extends Attribute {

    private U2 lineNumberTableLength;
    private LineNumberInfo[] lineNumberTable;
}
