package com.example.fashionblog.service;

import com.example.fashionblog.entity.BlogPost;
import com.example.fashionblog.entity.Like;
import com.example.fashionblog.repositories.BlogPostRepository;
import com.example.fashionblog.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<Like> getLikesByBlogPostId(Long blogPostId) {

        return likeRepository.findByBlogPostId(blogPostId);
    }
    public Long likeBlogPost(Long blogPostId) {
        try {
            BlogPost blogPost = blogPostRepository.findById(blogPostId).orElseThrow();
            Like like = new Like();
            like.setBlogPost(blogPost);
            like = likeRepository.save(like);
            return like.getId();
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException();
        }
    }
}