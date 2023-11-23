package dev.abhisek.questionservice.service.impl;

import dev.abhisek.questionservice.entity.Question;
import dev.abhisek.questionservice.repo.QuestionRepository;
import dev.abhisek.questionservice.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    @Override
    public Question add(Question question) {
        return repository.save(question);
    }

    @Override
    public List<Question> get() {
        return repository.findAll();
    }

    @Override
    public Question get(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("Question not found with id: "+id));
    }

    @Override
    public List<Question> getByQuizId(Long quizId) {
        return repository.findByQuizId(quizId);
    }
}
