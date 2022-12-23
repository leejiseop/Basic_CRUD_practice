package com.sparta.basiccrud.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter // getter를 쓸 수 있고
@MappedSuperclass // 다른곳에 상속받아서 쓸 거고
@EntityListeners(AuditingEntityListener.class) // AuditingEntityListener.class를 통해서 듣는다?
public class Timestamped {
    @CreatedDate // insert 할 때는 나를 찾아서 넣어라
    private LocalDateTime createdAt;

    @LastModifiedDate // update 할 때는 나를 찾아서 넣어라
    private LocalDateTime modifiedAt;
}
