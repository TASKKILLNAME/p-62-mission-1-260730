package com.back.practicejsb.domain.post.question.entity;

import com.back.practicejsb.domain.post.answer.entity.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
// @Setter 사용은 지양, 대신 생성자 사용
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate // 어노테이션 사용
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    public Question(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public void update(Question question, String subject, String content) {
        question.subject = subject;
        question.content = content;
    }
}
