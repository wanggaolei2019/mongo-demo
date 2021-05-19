package com.github.wanggaolei2019.mongodemo;

import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.BooleanMemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author wanggl
 * @since 2021-05-16
 */
public class SimpleTest {
    
    private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);
    
    @Test
    void objectIdTest() {
        ObjectId id = new ObjectId();
        System.out.println("十六进制：" + id.toHexString());
        System.out.println("十六进制：" + id);
        System.out.println("获取日期：" + id.getDate());
        System.out.println("获取时间戳：" + id.getTimestamp());
    }
    
    @Test
    void documentTest() {
        String str = "{\n" +
                "    \"aaa\":\"1\",\n" +
                "    \"bbb\":{\n" +
                "        \"ccc\":1,\n" +
                "        \"ddd\":2.0\n" +
                "    }\n" +
                "}";
        Document document = Document.parse(str);
        System.out.println("字符串转document：" + document);
        document.get("bbb", Document.class);
    }
    
    @Test
    void test1() throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 全局单例classPool
        ClassPool pool = ClassPool.getDefault();
        // 通过全限定名创ctClass
        CtClass ForTest = pool.makeClass("com.github.wanggaolei2019.ctclass.ForTest");
        
        // 我也不知道这个常量池是干嘛的，以下方法要用
        ClassFile forTestClassFile = ForTest.getClassFile();
        ConstPool constPool = forTestClassFile.getConstPool();
        
        // 通过字符串创建属性
        CtField name = CtField.make(String.format("private %s %s;", "String", "name"), ForTest);
        
        // 创建注解属性
        AnnotationsAttribute annotationsAttribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
        // 创建ApiModelProperty注解并赋值
        Annotation annotation = new Annotation("io.swagger.annotations.ApiModelProperty", constPool);
        annotation.addMemberValue("value", new StringMemberValue("姓名", constPool));
        annotation.addMemberValue("required", new BooleanMemberValue(true, constPool));
        // 为注解属性加上注解
        annotationsAttribute.addAnnotation(annotation);
        // 为字段加上注解属性
        name.getFieldInfo().addAttribute(annotationsAttribute);
        
        // 为类加上字段
        ForTest.addField(name);
        
        // 转为二进制，持久化存储
        byte[] forTestBytes = ForTest.toBytecode();
        
        // 读取二进制通过ctClass加载为class
        CtClass ctClass = pool.makeClass(new ByteArrayInputStream(forTestBytes), false);
        Class<?> aClass = ctClass.toClass();

//        ClassLoader classLoader = this.getClass().getClassLoader();
//
//        String path = classLoader.getResource("").getPath();
//        String filePath = path + "com/github/wanggaolei2019/ctclass/ForTest.class";
//        System.out.println(filePath);
//        FileUtil.writeBytes(forTestBytes, filePath);
//        Class<?> clazz = classLoader.loadClass(filePath);
//        Class<?> clazz = Class.forName("com.github.wanggaolei2019.ctclass.ForTest");
//        Object instance = clazz.newInstance();
        Object instance = aClass.newInstance();
        System.out.println(instance);
    }
    
    @Test
    void test2() {
        String[] abcs = StringUtils.split("abc.ccc", ".");
        System.out.println(Arrays.toString(abcs));
    }
    
}
