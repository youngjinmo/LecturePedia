package com.devandy.studypedia.utils;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass  // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)  // 클래스에 Auditing 기능을 포함
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime firstCreateddDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
