package com.back.practicejsb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PracticeJsbApplicationTests {

    // SpringBootTest는 @Autowired가 있어야 생성자 주입 가능
    // SpingBootTest에선 @RequiredArgsConstructor + private final 조합으로는 Spring Container가 인지 못함
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Test
    void testJpa1() {
        Question q1 = new Question("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        questionRepository.save(q1);

        Question q2 = new Question("스프링부트 모델 질문입니다.", "id는 자동으로 생성 되나요?");
        questionRepository.save(q2);
    }

    @Test
    void testJpa2() {
        List<Question> all = questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    void testJpa3() {
        Optional<Question> oq = questionRepository.findById(1);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }

    @Test
    void testJpa4() {
        Question q = questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, q.getId());
    }

    @Test
    void testJpa5() {
        Question q = questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, q.getId());
    }

    @Test
    void testJpa6() {
        List<Question> qList = questionRepository.findBySubjectLike("sbb%");
        Question q = qList.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    void testJpa7() {
        Optional<Question> oq = questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        // 엔티티에서 직접 Setter를 사용하지 않기때문에 update 메소드 생성 후 사용
    }

    @Test
    void testJpa8() {
        assertEquals(2, questionRepository.count());
        Optional<Question> oq = questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        questionRepository.delete(q);
        assertEquals(1, questionRepository.count());
    }

    @Test
    void testJpa9() {
        Optional<Question> oq = questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer("네 자동으로 생성됩니다.", q);
        answerRepository.save(a);
    }

    @Test
    void testJpa10() {
        Optional<Answer> oa = answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
    }

    @Transactional
    @Test
    void testJpa11() {
        Optional<Question> oq = questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }
}
