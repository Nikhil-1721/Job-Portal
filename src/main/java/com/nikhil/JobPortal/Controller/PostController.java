package com.nikhil.JobPortal.Controller;

import com.nikhil.JobPortal.Model.Post;
import com.nikhil.JobPortal.DAO.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repository;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return repository.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repository.save(post);
    }
}
