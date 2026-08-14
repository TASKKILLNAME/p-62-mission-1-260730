package com.back.practicejsb.domain.post.answer.entity;

import com.back.practicejsb.domain.post.question.entity.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@RequiredArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    @ManyToOne // Question <-> Answer 외래키 (외래키는 부모-자식 관계에서 자식에 생성)
    private Question question;

    public Answer(String content, Question question) {
        this.content = content;
        this.question = question;
    }
}
