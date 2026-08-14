package com.back.practicejsb.domain.post.question.service;

import com.back.practicejsb.domain.post.question.entity.Question;
import com.back.practicejsb.domain.post.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getQuestionList() {
        return questionRepository.findAll();
    }
}
