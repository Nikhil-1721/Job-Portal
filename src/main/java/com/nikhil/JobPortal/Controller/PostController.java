package com.nikhil.JobPortal.Controller;

import com.nikhil.JobPortal.Model.Post;
import com.nikhil.JobPortal.DAO.PostRepository;
import com.nikhil.JobPortal.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://localhost:3000")
public class PostController {

    @Autowired
    PostRepository repository;
    @Autowired
    SearchRepository srepo;

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts(){

        return repository.findAll();
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post){

        return repository.save(post);
    }

    @GetMapping("/posts{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }
}
