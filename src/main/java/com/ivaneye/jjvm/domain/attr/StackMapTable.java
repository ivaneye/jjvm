package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.attr.sub.StackMapFrame;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-11 10:18:19
 */
@Data
public class StackMapTable extends Attribute {

    private U2 numberOfEntries;
    private StackMapFrame[] entries;
}
