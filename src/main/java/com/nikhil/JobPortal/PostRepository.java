package com.nikhil.JobPortal;

import com.nikhil.JobPortal.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
