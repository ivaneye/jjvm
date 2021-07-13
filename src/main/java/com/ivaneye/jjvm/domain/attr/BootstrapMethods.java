package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.attr.sub.BootStrapMethodInfo;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-10 23:10:43
 */
@Data
public class BootstrapMethods extends Attribute {

    private U2 numBootStrapMethods;
    private BootStrapMethodInfo[] bootstrapMethods;
}
