package com.example.fashionblog.repositories;

import com.example.fashionblog.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByBlogPostId(Long blogPostId);
}
