package com.future.nexthotel.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author HaoMingYao (haomingyao@gotokeep.com)
 * @date 2018/12/26
 * @time 9:27 PM
 **/
@ComponentScan("com.future.nexthotel")
@SpringBootApplication
public class NextHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextHotelApplication.class, args);
    }
}
