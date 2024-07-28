package me.harry.springbootdeveloper.repository;

import me.harry.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
    // JpaRepository 클래스 상속 시 엔티티 Article 과 PK 타입 Long 을 인수로 활용
}
