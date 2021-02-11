package com.example.demo.controller;

import com.example.demo.RestController.QuestionController;
import com.example.demo.Service.QuestionService;
import com.example.demo.model.Questions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;




import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
@SpringBootTest

public class QuestionControllerTest {
    private static Questions questions1;
    private static Questions questions2;
    private static Questions questions3;

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private QuestionController questionController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @BeforeAll
    public static void init() {
        questions1 = new Questions("what is methodOveriding",1,1);
        questions2 = new Questions("what is methodOverloading",1,1);
        questions3 = new Questions("what is Dynamic Programming",2,1);
    }
    @Test
    void findAll_whenNoRecord() {
        Mockito.when(questionService.findAll()).thenReturn(Arrays.asList());
        assertThat(questionController.questions().size(), is(0));
        Mockito.verify(questionService, Mockito.times(1)).findAll();
    }
    @Test
    void findAll_whenRecord() {
    	Mockito.when(questionService.findAll()).thenReturn(Arrays.asList(questions1,questions2));
    	assertThat(questionController.questions().size(), is(2));
    	Mockito.verify(questionService,Mockito.times(1)).findAll();
    }
}
