package com.ivaneye.jjvm.runtime;

/**
 * 栈帧
 *
 * @author ivaneye
 * @since 2021-07-12 15:09:41
 */
public class Frame {

    // 程序计数器
    private int pc;
    // 局部变量表
    private String localVarTable;
    // 操作数栈
    private String operandStack;
    // 动态链接
    private String dynamicLink;
}
