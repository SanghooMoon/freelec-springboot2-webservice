package com.jojodu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication      // 스프링부트 프로젝트의 메인 클래스
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
