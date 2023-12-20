package com.example.fashionblog.repositories;

import com.example.fashionblog.dto.CreateCommentRequestDto;
import com.example.fashionblog.entity.Comment;

import java.util.List;

public interface CommentService {
    Long createComment(CreateCommentRequestDto createCommentRequestDto, Long postId);

    List<Comment> getAllComments();

    List<Comment> searchCommentsByText(String text);
}
