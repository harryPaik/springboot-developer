package me.harry.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.harry.springbootdeveloper.config.jwt.TokenProvider;
import me.harry.springbootdeveloper.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    // 전달받은 리프레시 토큰으로 토큰 유효성 검사를 진행하고,
    // 유효한 토큰인 때 리프레시 토큰으로 사용자 ID 를 검색
    public String createNewAccessToken(String refreshToken) {
        // 토큰 유효성 검사에 실패하면 예외 발생
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        // 사용자를 찾은 후 토큰 제공자의 메서드를 통해 새로운 액세스 토큰 생성
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }

}
