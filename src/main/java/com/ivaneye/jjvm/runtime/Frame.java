package com.ivaneye.jjvm.runtime;

import com.ivaneye.jjvm.domain.constant.Constant;

import java.util.LinkedList;
import java.util.Map;

/**
 * 栈帧
 *
 * @author ivaneye
 * @since 2021-07-12 15:09:41
 */
public class Frame {

    // 程序计数器
    private int pc;
    // 局部变量表，类型待定
    private Object[] localVarTable;
    // 操作数栈,类型待定
    private LinkedList<Object> operandStack;
    // 对应方法所属类的常量池,供动态链接解析
    private Map<Integer, Constant> constantPool;
}
