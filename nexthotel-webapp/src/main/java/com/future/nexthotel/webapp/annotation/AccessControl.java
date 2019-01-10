package com.future.nexthotel.webapp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.data.mongodb.core.mapping.Document;

import com.future.nexthotel.model.enums.UserType;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2019/1/7
 * @time 6:49 PM
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Document
public @interface AccessControl {
    String[] allowResources() default {};

    boolean ignoreResources() default false;
}
