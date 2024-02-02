package com.demo.myblog10.service;

import com.demo.myblog10.paylode.CommentDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommentService {
   CommentDto createComment(CommentDto commentDto, long postId);

    void deleteComment(long id);
}
