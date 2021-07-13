package com.ivaneye.jjvm.domain.attr;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-11 10:17:29
 */
@Data
public class SourceFile extends Attribute {

    private U2 sourceFileIndex;

    @Override
    public String info(ClassInfo classInfo) {
        return "sourceFile:" + classInfo.constantPool().get(sourceFileIndex.toInt()).value();
    }
}
