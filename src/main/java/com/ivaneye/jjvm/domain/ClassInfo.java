package com.ivaneye.jjvm.domain;

import com.ivaneye.jjvm.domain.attr.Attribute;
import com.ivaneye.jjvm.domain.constant.Constant;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 类文件信息
 *
 * @author ivaneye
 * @since 2021-07-05 18:17:02
 */
@Data
public class ClassInfo {
    private U4 magic;
    // 魔术
    private U2 minorVersion;
    // 版本
    private U2 majorVersion;
    // 常量池
    private U2 constantPoolCount;
    private Map<Integer, Constant> constantPool;
    // 掩码标志
    private U2 accessFlags;
    // 当前类/接口
    private U2 thisClass;
    // 父类
    private U2 superClass;
    // 实现的接口
    private U2 interfacesCount;
    private List<U2> interfaces;
    // 字段
    private U2 fieldsCount;
    private List<FieldInfo> fields;
    // 方法
    private U2 methodsCount;
    private List<MethodInfo> methods;
    // 属性
    private U2 attributesCount;
    private List<Attribute> attributes;

    public String magic() {
        return "0x" + magic.toHexString();
    }

    public String minorVersion() {
        return "minor version: " + minorVersion.toInt();
    }

    public String majorVersion() {
        return "major version: " + majorVersion.toInt();
    }

    public int constantPoolCount() {
        return constantPoolCount.toInt();
    }

    public Map<Integer, Constant> constantPool() {
        return constantPool;
    }

    public String accessFlags() {
        return "flags: " + accessFlags.toHexString();
    }

    public String thisClass() {
        Integer idx = thisClass.toInt();
        return "class " + constantPool.get(idx).value().replaceAll("/", ".");
    }

    public String superClass() {
        Integer idx = superClass.toInt();
        return "#" + idx + " // " + constantPool.get(idx);
    }

    public int interfacesCount() {
        return interfacesCount.toInt();
    }

    public List<String> interfaces() {
        ArrayList<String> interfaceList = new ArrayList<>();
        if (interfacesCount() > 0) {
            return interfaces.stream().map(it -> {
                return "#" + it.toInt() + " // " + constantPool.get(it.toInt());
            }).collect(Collectors.toList());
        }
        return interfaceList;
    }

    public int fieldsCount() {
        return fieldsCount.toInt();
    }

    public List<String> fields() {
        if (fieldsCount() > 0) {
            return fields.stream().map(it -> it.info(this)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public int methodsCount() {
        return methodsCount.toInt();
    }

    public List<String> methods() {
        if (methodsCount() > 0) {
            return methods.stream().map(it -> it.info(this) + "\r\n").collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public int attributesCount() {
        return attributesCount.toInt();
    }

    public List<String> attributes() {
        if (attributesCount() > 0) {
            return attributes.stream().map(it -> it.info(this) + "\r\n").collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public void show() {
        System.out.println(thisClass());
//        System.out.println(superClass());
//        System.out.println(interfaces());
        System.out.println(minorVersion());
        System.out.println(majorVersion());
        System.out.println(accessFlags());
        System.out.println("Constant pool:");
        Map<Integer, Constant> constantPool = constantPool();
        for (Integer key : constantPool.keySet()) {
            System.out.println("#" + key + " = " + constantPool.get(key));
        }
        System.out.println("{");
        System.out.println(fields());
        System.out.println(methods());
        System.out.println("}");
        System.out.println(attributes());
    }
}
