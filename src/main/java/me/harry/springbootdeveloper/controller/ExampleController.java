package me.harry.springbootdeveloper.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller // 컨트롤러라는 것을 명시적으로 표시
public class ExampleController {

    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model) {   // 뷰로 데이터를 넘겨주는 모델 객체
        // Model: 모델 객체는 뷰, Html 으로 값을 넘겨주는 객체
        // 따로 생성할 필요없이 코드처럼 인자로 선언하기만 하면 스프링에서 알아서 생성해준다.
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("홍길동");
        examplePerson.setAge(11);
        examplePerson.setHobbies(List.of("운동", "독서"));

        model.addAttribute("person", examplePerson);    // Person 객체 저장
        model.addAttribute("today", LocalDate.now());

        return "example";   // example.html 이라는 뷰 조회
    }

    @Setter
    @Getter
    class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }

}
