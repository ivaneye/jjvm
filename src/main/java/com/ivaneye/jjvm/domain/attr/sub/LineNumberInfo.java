package com.ivaneye.jjvm.domain.attr.sub;

import com.ivaneye.jjvm.domain.type.U2;
import lombok.Data;

/**
 * @author ivaneye
 * @since 2021-07-10 23:21:52
 */
@Data
public class LineNumberInfo {

    private U2 startPc;
    private U2 lineNumber;

    public LineNumberInfo(U2 startPc, U2 lineNumber) {
        this.startPc = startPc;
        this.lineNumber = lineNumber;
    }
}
