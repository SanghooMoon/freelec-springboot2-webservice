package com.jojodu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// myBatis 등에서 DAO로 불리는 접근자, JPA에선 Repository라고 부르며 인터페이스로 생성
// JpaRepository<Entity 클래스, PK 타입> 으로 상속하면 기본 CRUD 메서드 자동 생성
// 주의점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야함. 둘은 밀접한관계

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
