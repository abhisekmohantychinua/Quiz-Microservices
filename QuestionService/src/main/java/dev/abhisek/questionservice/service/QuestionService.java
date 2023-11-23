package dev.abhisek.questionservice.service;

import dev.abhisek.questionservice.entity.Question;

import java.util.List;

public interface QuestionService {
    Question add(Question question);
    List<Question> get();
    Question get(Long id);

    List<Question> getByQuizId(Long quizId);
}
