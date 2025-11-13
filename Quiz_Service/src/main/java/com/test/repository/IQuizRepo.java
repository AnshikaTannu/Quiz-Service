package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Quiz;

public interface IQuizRepo extends JpaRepository<Quiz, Integer>{

}
