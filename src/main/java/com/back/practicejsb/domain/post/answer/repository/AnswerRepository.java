package com.back.practicejsb.domain.post.answer.repository;

import com.back.practicejsb.domain.post.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
