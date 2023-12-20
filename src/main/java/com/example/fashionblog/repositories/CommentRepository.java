package com.example.fashionblog.repositories;

import com.example.fashionblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTextContaining(String text);

    List<Comment> findAll();
}
