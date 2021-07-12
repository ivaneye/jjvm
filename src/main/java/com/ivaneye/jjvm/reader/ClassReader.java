package com.ivaneye.jjvm.reader;

import com.ivaneye.jjvm.domain.ClassInfo;
import com.ivaneye.jjvm.domain.FieldInfo;
import com.ivaneye.jjvm.domain.MethodInfo;
import com.ivaneye.jjvm.domain.attr.Attribute;
import com.ivaneye.jjvm.domain.constant.*;
import com.ivaneye.jjvm.domain.type.U1;
import com.ivaneye.jjvm.domain.type.U2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ivaneye
 * @since 2021-07-10 22:40:06
 */
public class ClassReader {

    private CommonReader commonReader;
    private ClassInfo classInfo;

    public ClassReader(byte[] data) {
        this.commonReader = new CommonReader(data);
        classInfo = new ClassInfo();
    }

    public ClassInfo readClass() {
        readMagic();
        readMinorVersion();
        readMajorVersion();
        readConstantPoolCount();
        readConstantPool();
        readAccessFlag();
        readThisClass();
        readSuperClass();
        readInterfacesCount();
        readInterfaces();
        readFieldCount();
        readFields();
        readMethodCount();
        readMethods();
        readAttributesCount();
        readAttributes();
        return classInfo;
    }

    private void readMagic() {
        classInfo.setMagic(commonReader.readU4());
    }

    private void readMinorVersion() {
        classInfo.setMinorVersion(commonReader.readU2());
    }

    private void readMajorVersion() {
        classInfo.setMajorVersion(commonReader.readU2());
    }

    private void readConstantPoolCount() {
        classInfo.setConstantPoolCount(commonReader.readU2());
    }

    private void readConstantPool() {
        //常量池下标从1开始
        Map<Integer, Constant> cpInfoMap = new HashMap<>();
        int i = 0;
        while (i < classInfo.getConstantPoolCount().toInt() - 1) {
            U1 tag = commonReader.readU1();
            i += 1;
            switch (tag.toInt()) {
                case 1: {
                    U2 length = commonReader.readU2();
                    cpInfoMap.put(i, new ConstantUtf8(tag, length, commonReader.readByteArray(length.toInt()), classInfo));
                    break;
                }
                case 3: {
                    cpInfoMap.put(i, new ConstantInteger(tag, commonReader.readU4(), classInfo));
                    break;
                }
                case 4: {
                    cpInfoMap.put(i, new ConstantFloat(tag, commonReader.readU4(), classInfo));
                    break;
                }
                case 5: {
                    cpInfoMap.put(i, new ConstantLong(tag, commonReader.readU4(), commonReader.readU4(), classInfo));
                    i += 1;
                    break;
                }
                case 6: {
                    cpInfoMap.put(i, new ConstantDouble(tag, commonReader.readU4(), commonReader.readU4(), classInfo));
                    i += 1;
                    break;
                }
                case 7: {
                    cpInfoMap.put(i, new ConstantClass(tag, commonReader.readU2(), classInfo));
                    break;
                }
                case 8: {
                    cpInfoMap.put(i, new ConstantString(tag, commonReader.readU2(), classInfo));
                    break;
                }
                case 9: {
                    cpInfoMap.put(i, new ConstantFieldRef(tag, commonReader.readU2(), commonReader.readU2(), classInfo));
                    break;
                }
                case 10: {
                    cpInfoMap.put(i, new ConstantMethodRef(tag, commonReader.readU2(), commonReader.readU2(), classInfo));
                    break;
                }
                case 11: {
                    cpInfoMap.put(i, new ConstantInterfaceMethodRef(tag, commonReader.readU2(), commonReader.readU2(), classInfo));
                    break;
                }
                case 12: {
                    cpInfoMap.put(i, new ConstantNameAndType(tag, commonReader.readU2(), commonReader.readU2(), classInfo));
                    break;
                }
                case 15: {
                    cpInfoMap.put(i, new ConstantMethodHandler(tag, commonReader.readU1(), commonReader.readU2(), classInfo));
                    break;
                }
                case 16: {
                    cpInfoMap.put(i, new ConstantMethodType(tag, commonReader.readU2(), classInfo));
                    break;
                }
                case 18: {
                    cpInfoMap.put(i, new ConstantInvokeDynamic(tag, commonReader.readU2(), commonReader.readU2(), classInfo));
                    break;
                }
            }
        }
        classInfo.setConstantPool(cpInfoMap);
    }

    private void readAccessFlag() {
        classInfo.setAccessFlags(commonReader.readU2());
    }

    private void readThisClass() {
        classInfo.setThisClass(commonReader.readU2());
    }

    private void readSuperClass() {
        classInfo.setSuperClass(commonReader.readU2());
    }

    private void readInterfacesCount() {
        classInfo.setInterfacesCount(commonReader.readU2());
    }

    private void readInterfaces() {
        int count = classInfo.getInterfacesCount().toInt();
        if (count > 0) {
            List<U2> arr = new ArrayList<>();
            for (int i = 0; i < count - 1; i++) {
                arr.add(commonReader.readU2());
            }
            classInfo.setInterfaces(arr);
        }
    }

    private void readFieldCount() {
        classInfo.setFieldsCount(commonReader.readU2());
    }

    private void readFields() {
        int count = classInfo.getFieldsCount().toInt();
        if (count > 0) {
            List<FieldInfo> arr = new ArrayList<>();
            for (int i = 0; i < count - 1; i++) {
                U2 accFlag = commonReader.readU2();
                U2 nameIdx = commonReader.readU2();
                U2 descIdx = commonReader.readU2();
                U2 attrCount = commonReader.readU2();
                List<Attribute> attrs = readAttributes(attrCount.toInt());
                FieldInfo fieldInfo = new FieldInfo(accFlag, nameIdx, descIdx, attrCount, attrs);
                arr.add(fieldInfo);
            }
            classInfo.setFields(arr);
        }
    }

    private void readMethodCount() {
        classInfo.setMethodsCount(commonReader.readU2());
    }

    private void readMethods() {
        int count = classInfo.getMethodsCount().toInt();
        if (count > 0) {
            List<MethodInfo> arr = new ArrayList<>();
            for (int i = 0; i < count - 1; i++) {
                U2 accFlag = commonReader.readU2();
                U2 nameIdx = commonReader.readU2();
                U2 descIdx = commonReader.readU2();
                U2 attrCount = commonReader.readU2();
                List<Attribute> attrs = readAttributes(attrCount.toInt());
                MethodInfo methodInfo = new MethodInfo(accFlag, nameIdx, descIdx, attrCount, attrs);
                arr.add(methodInfo);
            }
            classInfo.setMethods(arr);
        }
    }

    private void readAttributesCount() {
        classInfo.setAttributesCount(commonReader.readU2());
    }

    private void readAttributes() {
        int count = classInfo.getAttributesCount().toInt();
        classInfo.setAttributes(readAttributes(count));
    }

    private List<Attribute> readAttributes(int count) {
        if (count > 0) {
            for (int i = 0; i < count - 1; i++) {
                U2 attributeNameIndex = commonReader.readU2();
                switch (attributeNameIndex.toInt()) {
                    // todo 处理属性
                }
            }
        }
        return new ArrayList<>();
    }
}
