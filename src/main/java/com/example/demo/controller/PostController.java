package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
		return postService.findPosts();
	}
	
	@GetMapping(value = "/posts/{title}")
	public Post findByTitle(@PathVariable(value = "title") String title) {
//		return postService.findPostByTitle(title);
		return null;
	}
	
	@GetMapping(value = "/post/{title}")
	public Post findPostByTitle(@PathVariable(value = "title") String title) {
		return postService.findPostByTitle(title);
	}

}
