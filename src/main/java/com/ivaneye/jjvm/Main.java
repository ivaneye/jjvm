package com.ivaneye.jjvm;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.constant.Constant;
import com.ivaneye.jjvm.finder.ClassPath;
import com.ivaneye.jjvm.reader.ClassReader;

import java.util.Map;

/**
 * @author ivaneye
 * @since 2021-07-11 12:33:42
 */
public class Main {

    private static final String version = "0.0.1";

    public static void main(String[] args) {
        switch (args[0]) {
            case "-version": {
                showVersion();
                break;
            }
            case "-help": {
                showHelp();
                break;
            }
            default: {
                startJVM(args);
                break;
            }
        }
    }

    private static void showHelp() {
        System.out.println("Usage: java [-options] class [args...]");
    }

    private static void showVersion() {
        System.out.println("Version:" + version);
    }

    private static void startJVM(String[] args) {
        System.out.println("classpath:${args[1]} class:${args[2]} args:${args.slice(3..args.size - 1)}");
        ClassPath cp = new ClassPath(args[1]);
        String className = args[2].replace("\\.", "/");
        byte[] classData = cp.readClass(className);
        System.out.println("className:$className,classData:$classData");
        ClassReader classReader = new ClassReader(classData);
        ClassInfo classInfo = classReader.readClass();
        System.out.println(classInfo.getMagic());
        System.out.println(classInfo.getMinorVersion());
        System.out.println(classInfo.getMajorVersion());
        System.out.println(classInfo.getConstantPoolCount());
        System.out.println("Constant pool:");
        Map<Integer, Constant> constantPool = classInfo.getConstantPool();
        for (Integer key : constantPool.keySet()) {
            System.out.println("#" + key + " = " + constantPool.get(key));
        }
        System.out.println("{");
        System.out.println(classInfo.getAccessFlags());
        System.out.println(classInfo.getThisClass());
        System.out.println(classInfo.getSuperClass());
        System.out.println(classInfo.getInterfacesCount());
//        System.out.println(classInfo.interfaces());
        System.out.println(classInfo.getFieldsCount());
//        System.out.println(classInfo.fields());
        System.out.println(classInfo.getMethodsCount());
    }
}
