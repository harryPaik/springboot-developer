package me.harry.springbootdeveloper.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccessTokenRequest {

    // 토큰 생성 요청 담당
    private String refreshToken;

}
