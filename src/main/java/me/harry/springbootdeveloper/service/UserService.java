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

}
