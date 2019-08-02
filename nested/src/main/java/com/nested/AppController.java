package com.nested;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	PostRepository postRepo;

	@Autowired
	CommentRepository commentRepo;

	@PostMapping("/post/save")
	public Post savePost(@RequestBody Post post) {
		return postRepo.save(post);
	}
	
	@PostMapping("/comment/save")
	public Comment saveComment(@RequestBody Comment comment) {
		comment.setPost(new Post());
		comment.getPost().setId(comment.getFk());
		return commentRepo.save(comment);
	}

}
