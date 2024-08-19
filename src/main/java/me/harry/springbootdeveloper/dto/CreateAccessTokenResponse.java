package me.harry.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateAccessTokenResponse {

    // 토큰 생성 응답을 담당
    private String accessToken;

}
