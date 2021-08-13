package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostDTO2;
import com.example.demo.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query(value = 
			" SELECT p FROM Post p "
			+ " LEFT JOIN FETCH p.comments c "
			+ " LEFT JOIN FETCH c.replies r "
			+ " WHERE p.id = :id "
			)
	Post findPostById(@Param(value = "id") Long id);
	
	@Query(value = 
			" SELECT p FROM Post p "
			+ " LEFT JOIN FETCH p.comments c "
			+ " LEFT JOIN FETCH c.replies r "
			)
	List<Post> findAll2();
	
	@Query(value = " SELECT p FROM Post p JOIN FETCH p.comments c JOIN FETCH c.replies r "
			, countQuery = " SELECT p FROM Post p JOIN  p.comments c JOIN c.replies r "
			)
	Page<Post> findAll3(Pageable pageRequest);
	
	@Query(value = " SELECT NEW com.example.demo.dto.PostDTO(p.title, p.content, c.content, r.content) "
				+ " FROM Post p JOIN  p.comments c JOIN  c.replies r ")
	Page<PostDTO> findAll4(Pageable pageRequest);

	@Query(value = " SELECT new com.example.demo.dto.PostDTO2(p.id, p.title, p.content) FROM Post p ")
	List<PostDTO2> findPostsList();
	
//	@QueryHints(value = {@QueryHint(name = org.hibernate.annotations.QueryHints.PASS_DISTINCT_THROUGH, value = "false")})

}
