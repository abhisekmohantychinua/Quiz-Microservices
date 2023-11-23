package dev.abhisek.quizservice.services;

import dev.abhisek.quizservice.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz get(Long id);
}
