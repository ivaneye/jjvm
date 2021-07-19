package com.ivaneye.jjvm.runtime;

import com.ivaneye.jjvm.domain.ClassInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 堆
 *
 * @author ivaneye
 * @since 2021-07-11 18:16:24
 */
public class Heap {

    private Map<String, ClassInstance> instanceMap = new HashMap<>();
}
