package com.quizApp.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizApp.demo.model.TestHistory;
import com.quizApp.demo.model.User;

@Repository
public interface TestHistoryRepository extends JpaRepository<TestHistory,Long>  {

//		@Query(value="select * from test_history order by id desc", nativeQuery=true)
		public Set<TestHistory> findByUserOrderByIdDesc(User user);
}