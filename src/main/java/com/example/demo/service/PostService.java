package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostDTO2;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}
	
	@Transactional(readOnly = true)
	public Post findPostById(Long id) {
		return postRepository.findPostById(id);
	}

	@Transactional(readOnly = true)
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Post> findAll2() {
		return postRepository.findAll2();
	}

	public Page<Post> findAll3(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return postRepository.findAll3(pageRequest);
	}

	public Page<PostDTO> findAll4(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return postRepository.findAll4(pageRequest);
	}
	
	
	@Transactional(readOnly = true)
	public Page<Post> findAll5(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return postRepository.findAll(pageRequest);
	}

	public List<PostDTO2> findPostsList() {
		return postRepository.findPostsList();
	}

}
