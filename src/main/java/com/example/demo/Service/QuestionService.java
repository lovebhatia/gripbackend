package com.example.demo.Service;

import com.example.demo.model.Questions;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Questions> findAll() {
        return questionRepository.findAll();
    }
}
