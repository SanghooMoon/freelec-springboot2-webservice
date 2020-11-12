package com.jojodu.book.springboot.web;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)                        // 스프리부트 테스트와 jUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class)    // 여러 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired              // 스프링이 관리하는 빈을 주입 받습니다.
    private MockMvc mvc;    // 웹API 테스트시 사용, 이 클래스를 통해 HTTP method 등에 대한 API 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))            // /hello 주소로 HTTP Get 요청
                .andExpect(status().isOk())             // mvc.perform()의 결과 검증. 즉 상태코드를 점검(여기선 200인지 아닌지 검증)
                .andExpect(content().string(hello));    // mvc.perforn()의 결과 검증. 응답 본문의 내용 검증("hello"를 정확히 리턴하는지 검증)
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        // give
        String name = "sanghoo";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)        // API 테스트할 때 사용될 요청 파라미터 설정, 모든 값은 String만 허용(숫자/날짜 등 모두 변환해야함))
                .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));
                    /*
                    jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메서드
                    $를 기준으로 필드명을 명시
                    여기서는 name과 amount를 검증하니 $.name, $.amount로 검증
                     */
    }

}
