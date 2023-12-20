package com.example.fashionblog.controller;

import com.example.fashionblog.dto.CreatePostRequestDto;
import com.example.fashionblog.entity.BlogPost;
import com.example.fashionblog.entity.Like;
import com.example.fashionblog.service.BlogPostService;
import com.example.fashionblog.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/blog-posts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<Long> createBlogPost(@RequestBody CreatePostRequestDto createPostRequestDto) {
        Long id = blogPostService.createBlogPost(createPostRequestDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return new ResponseEntity<>(blogPosts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        return new ResponseEntity<>(blogPost, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BlogPost>> searchBlogPostsByTitle(@RequestParam String title) {
        List<BlogPost> blogPosts = blogPostService.searchBlogPostsByTitle(title);
        return new ResponseEntity<>(blogPosts, HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        BlogPost updatedBlogPost = blogPostService.updateBlogPost(id, blogPost);
        return new ResponseEntity<>(updatedBlogPost, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/{id}/like")
    public ResponseEntity<Long> likeBlogPost(@PathVariable Long id) {
        Long likeId = likeService.likeBlogPost(id);
        return new ResponseEntity<>(likeId, HttpStatus.OK);
    }

    @GetMapping("/{id}/likes")
    public ResponseEntity<List<Like>> getLikesByBlogPostId(@PathVariable Long id) {
        List<Like> likes = likeService.getLikesByBlogPostId(id);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

}
