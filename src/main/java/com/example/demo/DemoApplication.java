package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.Reply;
import com.example.demo.service.PostService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private PostService postService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Post post1 = new Post();
		post1.setTitle("Post 1");
		post1.setContent("Content 1");

		Comment comment1 = new Comment();
		comment1.setContent("Comment 1");
		comment1.setPost(post1);

		Comment comment2 = new Comment();
		comment2.setContent("Comment 2");
		comment2.setPost(post1);
		
		Comment comment3 = new Comment();
		comment3.setContent("Comment 3");
		comment3.setPost(post1);
		
		Reply reply1 = new Reply();
		reply1.setContent("Reply 1");
		reply1.setComment(comment3);
		
		Comment comment4 = new Comment();
		comment4.setContent("Comment 3");
		comment4.setPost(post1);
		
		comment3.getReplies().addAll(Arrays.asList(reply1));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2, comment3, comment4));

		postService.save(post1);
		
//		Post post = postService.findPostById(1L);
//		
//		System.out.println("Title: " + post.getTitle());
//		System.out.println("Content: " + post.getContent());
//
//		for (Comment comment : post.getComments()) {
//			System.out.println("Comment of " + post.getTitle() + " : " + comment.getContent());
//			
//			for (Reply reply : comment.getReplies()) {
//				System.out.println("Reply of " + comment.getContent() + " : " + reply.getContent());
//			}
//				
//		}
		
		
	}

}
