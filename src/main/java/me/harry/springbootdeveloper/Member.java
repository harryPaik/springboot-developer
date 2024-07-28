package me.harry.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자
@AllArgsConstructor
@Getter
@Entity // Member 객체를 JPA 가 관리하는 엔티티로 지정
public class Member {   // Member 이름의 테이블에 접근하는데 사용할 객체

    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;    // DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "name", nullable = false)    // name 이라는 not null 컬럼과 매핑
    private String name;    // DB 테이블의 'name' 컬럼과 매칭
}
