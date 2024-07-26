package me.harry.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Member 이름의 테이블에 접근해 Member 클래스에 매핑하는 구현체
}
