package dev.abhisek.quizservice.services.impl;

import dev.abhisek.quizservice.entity.Quiz;
import dev.abhisek.quizservice.repo.QuizRepository;
import dev.abhisek.quizservice.services.QuestionClient;
import dev.abhisek.quizservice.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        return quizRepository.findAll()
                .stream().peek(quiz -> quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId())))
                .toList();
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(id));
        return quiz;
    }
}
