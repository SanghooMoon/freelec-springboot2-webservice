package com.jojodu.book.springboot.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given (주어진 상황)
        String name = "sanghoo";
        int amount = 100;

        // when (언제)
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then (결과)
        /* assertThat() : assertj라는 테스트 검증 라이브러리 검증 메서드
                          검증하고 싶은 대상을 메소드 인자로 받음.
                          메서드 체이닝이 지원되어 isEqualTo와 같이 메서드를 이어서 사용할 수 있음
           isEqualTo() : assertj의 동등 비교 메서드. assertThat()에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
