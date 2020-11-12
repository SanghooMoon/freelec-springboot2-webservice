package com.jojodu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter                     // 선언된 모든 필드에 getter 메서드 생성
@RequiredArgsConstructor    // final이 붙은 필드에 대한 생성자 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
