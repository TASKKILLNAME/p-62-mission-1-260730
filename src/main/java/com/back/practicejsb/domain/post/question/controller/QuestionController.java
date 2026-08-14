package com.back.practicejsb.domain.post.question.controller;

import com.back.practicejsb.domain.post.question.entity.Question;
import com.back.practicejsb.domain.post.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = questionService.getQuestionList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
