package com.jojodu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌. 이전의 @Controller + @ResponseBody 를 합친것
public class HelloController {

    @GetMapping("/hello")   // Http 메서드 Get을 요청받을 수 있는 API
    public String hello() {
        return "hello";
    }

}
