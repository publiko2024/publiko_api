package com.publiko.api.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    private String id;
    private String pw;
    private String name;
    private String age;
    private String phone;
    private String nickname;
    private boolean disability;
    private boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
