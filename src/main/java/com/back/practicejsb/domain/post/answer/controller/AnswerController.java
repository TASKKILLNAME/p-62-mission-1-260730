package com.back.practicejsb.domain.post.answer.controller;

import com.back.practicejsb.domain.post.answer.service.AnswerService;
import com.back.practicejsb.domain.post.question.entity.Question;
import com.back.practicejsb.domain.post.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable Integer id,
                               @RequestParam(value = "content") String content) {
        Question question = questionService.getQuestion(id);
        answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
