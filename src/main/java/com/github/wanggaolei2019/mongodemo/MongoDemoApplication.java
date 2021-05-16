package com.github.wanggaolei2019.mongodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class MongoDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }
    
}
