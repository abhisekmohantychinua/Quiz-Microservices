package dev.abhisek.quizservice.controller;

import dev.abhisek.quizservice.entity.Quiz;
import dev.abhisek.quizservice.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    @PostMapping
    private Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    @GetMapping
    private List<Quiz> get(){
        return quizService.get();
    }
    @GetMapping("{id}")
    private Quiz get(@PathVariable Long id){
        return quizService.get(id);
    }
}
