package com.example.fashionblog.service;

import com.example.fashionblog.dto.CreatePostRequestDto;
import com.example.fashionblog.entity.BlogPost;
import com.example.fashionblog.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPost> getAllBlogPosts() {

        return blogPostRepository.findAll();
    }

    public BlogPost getBlogPostById(Long id) {

        return blogPostRepository.findById(id).orElse(null);
    }

    public List<BlogPost> searchBlogPostsByTitle(String title) {
        return blogPostRepository.findByTitleContaining(title);
    }

    public  Long  createBlogPost(CreatePostRequestDto createPostRequestDto) {
        BlogPost emptyCreateBlogPost= new BlogPost();
        BlogPost newCreatedBlogPost = this.mapRequestToEntity(emptyCreateBlogPost, createPostRequestDto);
        BlogPost myBlogPost = blogPostRepository.save(newCreatedBlogPost);
        return myBlogPost.getId();
    }

    private BlogPost mapRequestToEntity(BlogPost blogPost, CreatePostRequestDto createPostRequestDto) {
        blogPost.setTitle(createPostRequestDto.getTitle());
        blogPost.setContent(createPostRequestDto.getContent());
        return blogPost;
    }

    public BlogPost updateBlogPost(Long id, BlogPost blogPost) {

        return blogPost;
    }

    public void deleteBlogPost(Long id) {
    }
}
