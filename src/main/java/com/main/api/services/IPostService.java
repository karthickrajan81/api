package com.main.api.services;

import java.util.List;

import com.main.api.entities.Post;

public interface IPostService {
    public Post getPostbyId(Long id);

    public Post[] getPostsbyUserId(Long userId);

    public List<Post> searchbyTitleOrBody(String title, String body);
}
