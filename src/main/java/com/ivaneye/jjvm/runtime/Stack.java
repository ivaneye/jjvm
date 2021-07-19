package com.ivaneye.jjvm.runtime;

import java.util.LinkedList;

/**
 * Java栈
 *
 * @author ivaneye
 * @since 2021-07-11 18:15:50
 */
public class Stack {

    // 栈帧
    private LinkedList<Frame> frames = new LinkedList<>();

    public void push(Frame frame) {
        // 压入栈帧
        frames.push(frame);
    }

    public Frame pop() {
        // 弹出栈帧
        return frames.pop();
    }
}
