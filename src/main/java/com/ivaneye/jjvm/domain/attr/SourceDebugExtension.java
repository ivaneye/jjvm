package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-11 10:16:47
 */
@Data
public class SourceDebugExtension extends Attribute {

    private U1[] debugExtension;
}
