package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.commons.RestAPIResponse;
import com.test.entity.Quiz;
import com.test.service.IQuizService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/quiz")
public class QuizController {

	@Autowired
	private IQuizService quizService;

	@PostMapping("/save")
	public ResponseEntity<RestAPIResponse> saveQuiz(@RequestBody Quiz quiz) {
		log.info("Inside QuizController: createQuiz()");
		return new ResponseEntity<>(new RestAPIResponse("success", "Quiz Saved", quizService.saveQuiz(quiz)),
				HttpStatus.CREATED);
	}

	// ✅ READ BY ID
	@GetMapping("/{id}")
	public ResponseEntity<RestAPIResponse> getQuizById(@PathVariable Integer id) {
		log.info("Inside QuizController: getQuizById()");

		return new ResponseEntity<>(new RestAPIResponse("success", "Data Find", quizService.getQuizById(id)),
				HttpStatus.OK);
	}
}
