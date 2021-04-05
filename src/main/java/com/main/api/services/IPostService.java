package com.main.api.services;

import java.util.List;

import com.main.api.entities.Post;

public interface IPostService {
    public Post getPostbyId(Long id) throws Exception;

    public Post[] getPostsbyUserId(Long userId) throws Exception;

    public List<Post> searchbyTitleOrBody(String title, String body) throws Exception;
}
