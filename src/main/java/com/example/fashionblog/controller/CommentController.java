package com.example.fashionblog.controller;

import com.example.fashionblog.dto.CreateCommentRequestDto;
import com.example.fashionblog.entity.Comment;
import com.example.fashionblog.repositories.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{postId}")
    public Long makeComment(@RequestBody CreateCommentRequestDto createCommentRequestDto, @PathVariable Long postId) {
        return commentService.createComment(createCommentRequestDto, postId);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/search")
    public List<Comment> searchCommentsByText(@RequestParam String text) {
        return commentService.searchCommentsByText(text);
    }

}