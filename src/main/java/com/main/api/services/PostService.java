package com.main.api.services;

import java.net.URI;

import com.main.api.dao.PostRepository;
import com.main.api.entities.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class PostService implements IPostService {

    @Value("${jsonplaceholder.url}")
    private String jsonplaceholderUrl;

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private EntityManager em;

    public Post getPostbyId(Long id) throws Exception {
        String idPath = jsonplaceholderUrl + "/" + id.toString();
        URI fullUrl = new URI(idPath);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post> response = restTemplate.getForEntity(fullUrl, Post.class);
        return response.getBody();
    }

    public Post[] getPostsbyUserId(Long userId) throws Exception {
        String idPath = jsonplaceholderUrl + "/?userId=" + userId.toString();
        URI fullUrl = new URI(idPath);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post[]> response = restTemplate.getForEntity(fullUrl, Post[].class);
        return response.getBody();
    }

    public List<Post> searchbyTitleOrBody(String title, String body) throws Exception {

        // Load all posts from url
        URI fullUrl = new URI(jsonplaceholderUrl);
        RestTemplate restTemplate = new RestTemplate();
        Post[] posts = restTemplate.getForObject(fullUrl, Post[].class);
        List<Post> postsIterator = Arrays.asList(posts);
        postRepo.saveAll(postsIterator);

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Post> qurey = builder.createQuery(Post.class);
        Root<Post> root = qurey.from(Post.class);

        Predicate titleCondition = null;
        Predicate bodyCondition = null;
        if (title != null) {
            titleCondition = builder.like(root.get("title"), "%" + title + "%");
        }
        if (body != null) {
            bodyCondition = builder.like(root.get("body"), "%" + body + "%");
        }

        if (titleCondition != null && bodyCondition != null) {
            Predicate orCondition = builder.or(titleCondition, bodyCondition);
            qurey.where(orCondition);
        } else if (titleCondition != null) {
            qurey.where(titleCondition);
        } else if (bodyCondition != null) {
            qurey.where(bodyCondition);
        }

        return em.createQuery(qurey).getResultList();
    }
}
