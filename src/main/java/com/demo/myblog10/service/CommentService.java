package com.demo.myblog10.service;

import com.demo.myblog10.paylode.CommentDto;

public interface CommentService {
   CommentDto createComment(CommentDto commentDto, long postId);

    void deleteComment(long id);

    CommentDto updateComment(long id, CommentDto commentDto, long postId);
}
