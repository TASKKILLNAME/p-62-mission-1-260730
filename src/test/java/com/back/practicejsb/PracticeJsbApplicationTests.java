package com.back.practicejsb;

import com.back.practicejsb.domain.post.answer.repository.AnswerRepository;
import com.back.practicejsb.domain.post.question.repository.QuestionRepository;
import com.back.practicejsb.domain.post.question.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PracticeJsbApplicationTests {

    // SpringBootTest는 @Autowired가 있어야 생성자 주입 가능
    // SpingBootTest에선 @RequiredArgsConstructor + private final 조합으로는 Spring Container가 인지 못함
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {
        for(int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content  = "내용무";
            questionService.create(subject, content);
        }
    }
}
