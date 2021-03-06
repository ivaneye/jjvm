package com.ivaneye.jjvm.runtime.instructions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ivaneye
 * @since 2021-07-14 17:20:20
 */
public abstract class Instruction {

    protected String code;
    protected String name;
    protected int data;
    protected int data2;

    public static final Map<String, String> CODE_NAME = new HashMap<>();

    static {
        CODE_NAME.put("0","nop01");
        CODE_NAME.put("1","aconst_null");
        CODE_NAME.put("2","iconst_m1");
        CODE_NAME.put("3","iconst_0");
        CODE_NAME.put("4","iconst_1");
        CODE_NAME.put("5","iconst_2");
        CODE_NAME.put("6","iconst_3");
        CODE_NAME.put("7","iconst_4");
        CODE_NAME.put("8","iconst_5");
        CODE_NAME.put("9","lconst_0");
        CODE_NAME.put("A","lconst_1");
        CODE_NAME.put("B","fconst_0");
        CODE_NAME.put("C","fconst_1");
        CODE_NAME.put("D","fconst_2");
        CODE_NAME.put("E","dconst_0");
        CODE_NAME.put("F","dconst_1");
        CODE_NAME.put("10","bipush");
        CODE_NAME.put("11","sipush");
        CODE_NAME.put("12","ldc");
        CODE_NAME.put("13","ldc_w");
        CODE_NAME.put("14","ldc2_w");
        CODE_NAME.put("15","iload");
        CODE_NAME.put("16","lload");
        CODE_NAME.put("17","fload");
        CODE_NAME.put("18","dload");
        CODE_NAME.put("19","aload");
        CODE_NAME.put("1A","iload_0");
        CODE_NAME.put("1B","iload_1");
        CODE_NAME.put("1C","iload_2");
        CODE_NAME.put("1D","iload_3");
        CODE_NAME.put("1E","lload_0");
        CODE_NAME.put("1F","lload_1");
        CODE_NAME.put("20","lload_2");
        CODE_NAME.put("21","lload_3");
        CODE_NAME.put("22","fload_0");
        CODE_NAME.put("23","fload_1");
        CODE_NAME.put("24","fload_2");
        CODE_NAME.put("25","fload_3");
        CODE_NAME.put("26","dload_0");
        CODE_NAME.put("27","dload_1");
        CODE_NAME.put("28","dload_2");
        CODE_NAME.put("29","dload_3");
        CODE_NAME.put("2A","aload_0");
        CODE_NAME.put("2B","aload_1");
        CODE_NAME.put("2C","aload_2");
        CODE_NAME.put("2D","aload_3");
        CODE_NAME.put("2E","iaload");
        CODE_NAME.put("2F","laload");
        CODE_NAME.put("30","faload");
        CODE_NAME.put("31","daload");
        CODE_NAME.put("32","aaload");
        CODE_NAME.put("33","baload");
        CODE_NAME.put("34","caload");
        CODE_NAME.put("35","saload");
        CODE_NAME.put("36","istore");
        CODE_NAME.put("37","lstore");
        CODE_NAME.put("38","fstore");
        CODE_NAME.put("39","dstore");
        CODE_NAME.put("3A","astore");
        CODE_NAME.put("3B","istore_0");
        CODE_NAME.put("3C","istore_1");
        CODE_NAME.put("3D","istore_2");
        CODE_NAME.put("3E","istore_3");
        CODE_NAME.put("3F","lstore_0");
        CODE_NAME.put("40","lstore_1");
        CODE_NAME.put("41","lstore_2");
        CODE_NAME.put("42","lstore_3");
        CODE_NAME.put("43","fstore_0");
        CODE_NAME.put("44","fstore_1");
        CODE_NAME.put("45","fstore_2");
        CODE_NAME.put("46","fstore_3");
        CODE_NAME.put("47","dstore_0");
        CODE_NAME.put("48","dstore_1");
        CODE_NAME.put("49","dstore_2");
        CODE_NAME.put("4A","dstore_3");
        CODE_NAME.put("4B","astore_0");
        CODE_NAME.put("4C","astore_1");
        CODE_NAME.put("4D","astore_2");
        CODE_NAME.put("4E","astore_3");
        CODE_NAME.put("4F","iastore");
        CODE_NAME.put("50","lastore");
        CODE_NAME.put("51","fastore");
        CODE_NAME.put("52","dastore");
        CODE_NAME.put("53","aastore");
        CODE_NAME.put("54","bastore");
        CODE_NAME.put("55","castore");
        CODE_NAME.put("56","sasto");
        CODE_NAME.put("57","pop");
        CODE_NAME.put("58","pop2");
        CODE_NAME.put("59","dup");
        CODE_NAME.put("5A","dup_x1");
        CODE_NAME.put("5B","dup_x2");
        CODE_NAME.put("5C","dup2");
        CODE_NAME.put("5D","dup2_x1");
        CODE_NAME.put("5E","dup2_x2");
        CODE_NAME.put("5F","swap");
        CODE_NAME.put("60","iadd");
        CODE_NAME.put("61","ladd");
        CODE_NAME.put("62","fadd");
        CODE_NAME.put("63","dadd");
        CODE_NAME.put("64","isub");
        CODE_NAME.put("65","lsub");
        CODE_NAME.put("66","fsub");
        CODE_NAME.put("67","dsub");
        CODE_NAME.put("68","imul");
        CODE_NAME.put("69","lmul");
        CODE_NAME.put("6A","fmul");
        CODE_NAME.put("6B","dmul");
        CODE_NAME.put("6C","idiv");
        CODE_NAME.put("6D","ldiv");
        CODE_NAME.put("6E","fdiv");
        CODE_NAME.put("6F","ddiv");
        CODE_NAME.put("70","irem");
        CODE_NAME.put("71","lrem");
        CODE_NAME.put("72","frem");
        CODE_NAME.put("73","drem");
        CODE_NAME.put("74","ineg");
        CODE_NAME.put("75","lneg");
        CODE_NAME.put("76","fneg");
        CODE_NAME.put("77","dneg");
        CODE_NAME.put("78","ishl");
        CODE_NAME.put("79","lshl");
        CODE_NAME.put("7A","ishr");
        CODE_NAME.put("7B","lshr");
        CODE_NAME.put("7C","iushr");
        CODE_NAME.put("7D","lushr");
        CODE_NAME.put("7E","iand");
        CODE_NAME.put("7F","land");
        CODE_NAME.put("80","ior");
        CODE_NAME.put("81","lor");
        CODE_NAME.put("82","ixor");
        CODE_NAME.put("83","lxor");
        CODE_NAME.put("84","iinc");
        CODE_NAME.put("85","i2l");
        CODE_NAME.put("86","i2f");
        CODE_NAME.put("87","i2d");
        CODE_NAME.put("88","l2i");
        CODE_NAME.put("89","l2f");
        CODE_NAME.put("8A","l2d");
        CODE_NAME.put("8B","f2i");
        CODE_NAME.put("8C","f2l");
        CODE_NAME.put("8D","f2d");
        CODE_NAME.put("8E","d2i");
        CODE_NAME.put("8F","d2l");
        CODE_NAME.put("90","d2f");
        CODE_NAME.put("91","i2b");
        CODE_NAME.put("92","i2c");
        CODE_NAME.put("93","i2s");
        CODE_NAME.put("94","lcmp");
        CODE_NAME.put("95","fcmpl");
        CODE_NAME.put("96","fcmpg");
        CODE_NAME.put("97","dcmpl");
        CODE_NAME.put("98","dcmpg");
        CODE_NAME.put("99","ifeq");
        CODE_NAME.put("9A","ifne");
        CODE_NAME.put("9B","iflt");
        CODE_NAME.put("9C","ifge");
        CODE_NAME.put("9D","ifgt");
        CODE_NAME.put("9E","ifle");
        CODE_NAME.put("9F","if_icmpeq");
        CODE_NAME.put("A0","if_icmpne");
        CODE_NAME.put("A1","if_icmplt");
        CODE_NAME.put("A2","if_icmpge");
        CODE_NAME.put("A3","if_icmpgt");
        CODE_NAME.put("A4","if_icmple");
        CODE_NAME.put("A5","if_acmpeq");
        CODE_NAME.put("A6","if_acmpne");
        CODE_NAME.put("A7","goto");
        CODE_NAME.put("A8","jsr");
        CODE_NAME.put("A9","ret");
        CODE_NAME.put("AA","tableswitch");
        CODE_NAME.put("AB","lookupswitch");
        CODE_NAME.put("AC","ireturn");
        CODE_NAME.put("AD","lreturn");
        CODE_NAME.put("AE","freturn");
        CODE_NAME.put("AF","dreturn");
        CODE_NAME.put("B0","areturn");
        CODE_NAME.put("B1","return");
        CODE_NAME.put("B2","getstatic");
        CODE_NAME.put("B3","putstatic");
        CODE_NAME.put("B4","getfield");
        CODE_NAME.put("B5","putfield");
        CODE_NAME.put("B6","invokevirtual");
        CODE_NAME.put("B7","invokespecial");
        CODE_NAME.put("B8","invokestatic");
        CODE_NAME.put("B9","invokeinterface");
        CODE_NAME.put("BA","invokedynamic");
        CODE_NAME.put("BB","new");
        CODE_NAME.put("BC","newarray");
        CODE_NAME.put("BD","anewarray");
        CODE_NAME.put("BE","arraylength");
        CODE_NAME.put("BF","athrow");
        CODE_NAME.put("C0","checkcast");
        CODE_NAME.put("C1","instanceof");
        CODE_NAME.put("C2","monitorenter");
        CODE_NAME.put("C3","monitorexit");
        CODE_NAME.put("C4","wide");
        CODE_NAME.put("C5","multianewarray");
        CODE_NAME.put("C6","ifnull");
        CODE_NAME.put("C7","ifnonnull");
        CODE_NAME.put("C8","goto_w");
        CODE_NAME.put("C9","jsr_w");
        CODE_NAME.put("CA","breakpoint");
        CODE_NAME.put("FE","impdep1");
        CODE_NAME.put("FF","impdep2");
    }

}
