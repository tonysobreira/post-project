package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query(value = 
			" SELECT p FROM Post p " +
			" LEFT JOIN FETCH p.comments c " +
			" LEFT JOIN FETCH c.replies r " +
			" WHERE p.title = 'Post 1'"
			)
	List<Post> findPosts();
	
	@Query(value = 
			" SELECT p FROM Post p " +
			" LEFT JOIN FETCH p.comments c " +
			" LEFT JOIN FETCH c.replies r " +
			" WHERE p.title = :title "
			)
	Post findPostByTitle(@Param(value = "title") String title);
	
	@Query(value = 
			" SELECT p FROM Post p " +
			" LEFT JOIN FETCH p.comments c " +
			" LEFT JOIN FETCH c.replies r " +
			" WHERE p.id = :id "
			)
	Post findPostById(@Param(value = "id") Long id);

}
