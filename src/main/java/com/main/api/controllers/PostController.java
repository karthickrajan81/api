package com.main.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Iterables;
import com.main.api.entities.Post;
import com.main.api.services.PostService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/post")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostbyId(@PathVariable Long id) throws Exception {
        try {
            Post result = postService.getPostbyId(id);
            var response = new ResponseEntity<Post>(result, HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }

    @GetMapping()
    public ResponseEntity<Post[]> getPostsbyUserId(@RequestParam(value = "userId") Long userId) throws Exception {
        try {
            Post[] result = postService.getPostsbyUserId(userId);
            var response = new ResponseEntity<Post[]>(result, HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Post[]> search(@RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "body", required = false) String body) throws Exception {
        try {
            Post[] result = Iterables.toArray(postService.searchbyTitleOrBody(title, body), Post.class);
            var response = new ResponseEntity<Post[]>(result, HttpStatus.OK);
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }
}
