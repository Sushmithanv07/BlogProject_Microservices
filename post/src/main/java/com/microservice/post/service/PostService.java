package com.microservice.post.service;

import com.microservice.post.config.RestTemplateConfig;
import com.microservice.post.entity.Post;
import com.microservice.post.payload.PostDto;
import com.microservice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private RestTemplateConfig restTemplate;

    public Post savePost(Post post){
        String postId = UUID.randomUUID().toString();
        post.setId(postId);// randomly generates a id
        Post savedPost = postRepo.save(post);
        return savedPost;
    }

    public Post findPostById(String postId) {
        Post post = postRepo.findById(postId).get();
        return post;
    }

    public PostDto getPostWithComments(String postId) {
       Post post = postRepo.findById(postId).get();
        ArrayList comments = restTemplate.getRestTemplate().getForObject("http://localhost:8082/api/comments/" + postId, ArrayList.class);

        PostDto postDto = new PostDto();
        postDto.setPostId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        postDto.setTitle(post.getTitle());
        postDto.setComments(comments);
        return postDto;
    }
}
