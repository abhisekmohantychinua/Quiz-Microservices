package dev.abhisek.questionservice.controllers;

import dev.abhisek.questionservice.entity.Question;
import dev.abhisek.questionservice.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService service;


    @PostMapping
    public Question add(@RequestBody Question question){
        return service.add(question);
    }

    @GetMapping
    public List<Question> get(){
        return service.get();
    }

    @GetMapping("{id}")
    public Question get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping("quiz/{id}")
    public List<Question> getByQuestion(@PathVariable Long id){
        return service.getByQuizId(id);
    }
}
