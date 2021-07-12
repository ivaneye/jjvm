package com.ivaneye.jjvm.domain;

import com.ivaneye.jjvm.domain.attr.Attribute;
import com.ivaneye.jjvm.domain.constant.Constant;
import com.ivaneye.jjvm.domain.type.U2;
import com.ivaneye.jjvm.domain.type.U4;
import lombok.Data;

import java.util.List;
import java.util.Map;

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

    public int minorVersion() {
        return minorVersion.toInt();
    }

    public int majorVersion() {
        return majorVersion.toInt();
    }

    public int constantPoolCount() {
        return constantPoolCount.toInt();
    }

    public Map<Integer, Constant> constantPool() {
        return constantPool;
    }

    public String accessFlags() {
        return accessFlags.toHexString();
    }

    public int thisClass() {
        return thisClass.toInt();
    }

    public int superClass() {
        return superClass.toInt();
    }

    public int interfacesCount() {
        return interfacesCount.toInt();
    }

    public int fieldsCount() {
        return fieldsCount.toInt();
    }

    public int methodsCount() {
        return methodsCount.toInt();
    }
}
