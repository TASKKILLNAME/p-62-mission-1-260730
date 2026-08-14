package com.back.practicejsb.domain.post.answer.service;

import com.back.practicejsb.domain.post.answer.entity.Answer;
import com.back.practicejsb.domain.post.answer.repository.AnswerRepository;
import com.back.practicejsb.domain.post.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {

        Answer answer = new Answer(content, question);
        answerRepository.save(answer);
    }

}
