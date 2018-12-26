package com.keep.kit.nexthotel.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.keep.spring.boot.codis.EnableKeepCodisConfiguration;
import com.keep.spring.boot.dubbo.EnableKeepDubboConfiguration;
import com.keep.spring.boot.mongo.EnableKeepMongoConfiguration;

/**
 * Date: 2018/9/14
 * Time: 下午4:16
 *
 * @author sunnyxd (fanxiaodong@gotokeep.com)
 */
@SpringBootApplication(exclude = {
        EmbeddedMongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class,
        ValidationAutoConfiguration.class})
@EnableKeepCodisConfiguration
@EnableKeepMongoConfiguration
@EnableKeepDubboConfiguration
@ComponentScan("com.keep.kit")
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StartApplication.class);
        application.run(args);
    }
}
