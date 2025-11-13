package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Quiz;
import com.test.repository.IQuizRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuizServiceImpl implements IQuizService {

//	private static final Logger logger = LoggerFactory.getLogger(QuizServiceImpl.class);

	@Autowired
	private IQuizRepo quizRepo;

	@Override
	public Quiz saveQuiz(Quiz quiz) {
		log.info("Saving quiz...");
		Quiz save = quizRepo.save(quiz);
		return save;
	}

	@Override
	public List<Quiz> getAll() {
		log.info("Fetching all quizzes");
		return quizRepo.findAll();

	}

	@Override
	public Quiz getQuizById(Integer id) {
		log.info("Fetching quiz by id: {}", id);
		return quizRepo.findById(id).orElseThrow(() -> new RuntimeException("quiz not found: " + id));

	}

	@Override
	public Quiz updateQuiz(Integer id, Quiz quiz) {
		log.info("Updating quiz with id: {}", id);
		Quiz existQuiz = quizRepo.findById(id).orElseThrow(() -> new RuntimeException("quiz not found with id: " + id));

		existQuiz.setTitle(quiz.getTitle());
		existQuiz.setDescription(quiz.getDescription());
		return quizRepo.save(existQuiz);
	}

	@Override
	public void deleteQuiz(Integer id) {
		log.info("Deleting quiz with id: {}", id);
		if (!quizRepo.existsById(id)) {
			throw new RuntimeException("quiz id not found : " + id);
		}
		quizRepo.deleteById(id);

	}

}
