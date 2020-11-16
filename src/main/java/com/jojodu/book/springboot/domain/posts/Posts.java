package com.jojodu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타냄. SalesManager -> sales_manager
public class Posts {

    @Id // 해달 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄. 부트 2.0 에서는 GenerationType.IDENTITY 추가해야만 auto_increment가 됌
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타냄. 기본값 외에 추가로 변경이 필요할 시 사용. 사이즈를 늘리거나 타입을 변경할때 등
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
