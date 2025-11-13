package com.test.service;

import java.util.List;

import com.test.entity.Quiz;

public interface IQuizService {

	Quiz saveQuiz(Quiz quiz);

	List<Quiz> getAll();

	Quiz getQuizById(Integer id);

	Quiz updateQuiz(Integer id,Quiz quiz);

	void deleteQuiz(Integer id);
}
