package me.harry.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.harry.springbootdeveloper.domain.User;
import me.harry.springbootdeveloper.dto.AddUserRequest;
import me.harry.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                // 패스워드 암호화
                // 패스워드를 저장할 때 인코딩용으로 등록한 빈을 사용해서 암호화한 후 저장
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    // RefreshToken 을 전달받아 토큰 제공자를 사용해 새로운 Access Token 을 만드는 서비스
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

}
