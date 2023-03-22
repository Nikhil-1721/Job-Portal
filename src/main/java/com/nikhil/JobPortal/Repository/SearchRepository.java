package com.nikhil.JobPortal.Repository;

import com.nikhil.JobPortal.Model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
