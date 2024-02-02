package com.demo.myblog10.controller;

import com.demo.myblog10.entity.Comment;
import com.demo.myblog10.paylode.CommentDto;
import com.demo.myblog10.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
// http://localhost:8080/api/comments?postId=1
    @PostMapping
    public ResponseEntity<CommentDto>createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long postId
    ){
        CommentDto dto = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    // http://localhost:8080/api/comments/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("comment is deleted",HttpStatus.OK);
    }

}
