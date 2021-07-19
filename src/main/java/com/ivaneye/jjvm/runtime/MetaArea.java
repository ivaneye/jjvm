package com.ivaneye.jjvm.runtime;

import com.ivaneye.jjvm.domain.ClassInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Meta区域
 *
 * @author ivaneye
 * @since 2021-07-11 18:18:01
 */
public class MetaArea {

    private Map<String, ClassInfo> metaMap = new HashMap<>();
}
