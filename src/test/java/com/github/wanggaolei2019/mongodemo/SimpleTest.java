package com.github.wanggaolei2019.mongodemo;

import cn.hutool.core.util.ByteUtil;
import cn.hutool.core.util.NumberUtil;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    
}
