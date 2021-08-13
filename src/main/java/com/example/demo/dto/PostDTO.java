package com.example.demo.dto;

public class PostDTO {

	private String postTitle;

	private String postContent;

	private String commentContent;

	private String replyContent;

	public PostDTO(String postTitle, String postContent, String commentContent, String replyContent) {
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.commentContent = commentContent;
		this.replyContent = replyContent;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

}
