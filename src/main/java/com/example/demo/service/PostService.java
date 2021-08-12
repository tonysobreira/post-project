package com.example.demo.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Comment;
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
	public List<Post> findAll() {
		List<Post> list = postRepository.findAll();

		for (Post post : list) {
			Hibernate.initialize(post.getComments());

			for (Comment comment : post.getComments()) {
				Hibernate.initialize(comment.getReplies());
			}
		}

		return list;
	}

	@Transactional(readOnly = true)
	public Post findPostById(Long id) {
		return postRepository.findPostById(id);
	}

	@Transactional(readOnly = true)
	public List<Post> findPosts() {
		return postRepository.findPosts();
	}

	@Transactional(readOnly = true)
	public Post findPostByTitle(String title) {
		return postRepository.findPostByTitle(title);
	}

}
