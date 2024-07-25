package me.harry.springbootdeveloper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                 // 라우터(HTTP 요청과 메서드를 연) 역할
public class TestController {
    @GetMapping("/test")        // /test GET 요청이 오면 test() 메서드 실행
    public String test() {
        return "Hello, world!";
    }
}
