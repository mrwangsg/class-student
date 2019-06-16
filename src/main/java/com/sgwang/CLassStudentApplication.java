package com.sgwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @创建人 sgwang
 * @name CLassStudentApplication
 * @user 91119
 * @创建时间 2019/6/14
 * @描述
 */
@EnableTransactionManagement
@SpringBootApplication
public class CLassStudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CLassStudentApplication.class);
    }
}
