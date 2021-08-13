package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostDTO2;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@RestController
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping(value = "/posts")
	public List<Post> findAll() {
		return postService.findAll();
	}
	
	@GetMapping(value = "/posts2")
	public List<Post> findAll2() {
		return postService.findAll2();
	}
	
	@GetMapping(value = "/posts3")
	public Page<Post> findAll3(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return postService.findAll3(page, linesPerPage, orderBy, direction);
	}
	
	@GetMapping(value = "/posts4")
	public Page<PostDTO> findAll4(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return postService.findAll4(page, linesPerPage, orderBy, direction);
	}
	
	@GetMapping(value = "/posts5")
	public Page<Post> findAll5(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return postService.findAll5(page, linesPerPage, orderBy, direction);
	}
	
	@GetMapping(value = "/posts/{id}")
	public Post findAll(@PathVariable(value = "id") Long id) {
		return postService.findPostById(id);
	}
	
	@GetMapping(value = "/posts-list")
	public ResponseEntity<List<PostDTO2>> findPostsList() {
		return ResponseEntity.ok(postService.findPostsList());
	}

}
