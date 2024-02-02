package com.demo.myblog10.service.impl;

import com.demo.myblog10.entity.Comment;
import com.demo.myblog10.entity.Post;
import com.demo.myblog10.exception.ResourceNotFoundException;
import com.demo.myblog10.paylode.CommentDto;
import com.demo.myblog10.repository.CommentRepository;
import com.demo.myblog10.repository.PostRepository;
import com.demo.myblog10.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository,CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository=commentRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id: " + postId)
        );
        Comment comment=new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dto=new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());
        return null;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }


}
