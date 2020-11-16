package com.jojodu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JPA Entity 클래스들이 이 클래스를 상속할 경우 이 필드들도 칼럼으로 인식하게 만듬
@EntityListeners(AuditingEntityListener.class)  // 이 클래스이 Auditing 기능을 포함
public abstract class BaseTimeEntity {

    @CreatedDate    // 엔티티가 생성될때 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate   // 수정될 때 시간이 자동 저장
    private LocalDateTime modifiedDate;

}
