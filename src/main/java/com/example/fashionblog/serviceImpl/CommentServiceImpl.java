package com.example.fashionblog.serviceImpl;

import com.example.fashionblog.dto.CreateCommentRequestDto;
import com.example.fashionblog.entity.BlogPost;
import com.example.fashionblog.entity.Comment;
import com.example.fashionblog.repositories.BlogPostRepository;
import com.example.fashionblog.repositories.CommentRepository;
import com.example.fashionblog.repositories.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl  implements CommentService {
    @Autowired
    private final CommentRepository commentRepository;

    private final BlogPostRepository blogPostRepository;

    @Override
    public Long createComment(CreateCommentRequestDto createCommentRequestDto, Long postId) {
        Optional<BlogPost> optionalBlogPost =  this.blogPostRepository.findById(postId);

        if (optionalBlogPost.isEmpty()){
            throw new ResourceNotFoundException("Blog post with " + postId + " not found");
        }

        BlogPost blogPost = optionalBlogPost.get();
        Comment newComment = new Comment();
        newComment.setText(createCommentRequestDto.getCommentContent());
        newComment.setBlogPost(blogPost);

        Comment comment = this.commentRepository.save(newComment);

        return comment.getId();
    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public List<Comment> searchCommentsByText(String text) {
        return null;
    }

}