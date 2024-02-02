package com.demo.myblog10.controller;

import com.demo.myblog10.paylode.PostDto;
import com.demo.myblog10.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
@PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.crestePost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    // http://localhost:8080/api/posts/all?id=1
    @GetMapping("/all")
    public ResponseEntity<PostDto>getPostById(@RequestParam long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //http://localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=title&sortDir=desc
    @GetMapping
    public List<PostDto>getAllPosts(
            @RequestParam(name = "pageNo",required = false,defaultValue = "0")int pageNo,
            @RequestParam(name = "pageSize",required = false,defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy",required = false,defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir",required = false,defaultValue = "id") String sortDir

    ){
       List<PostDto>postDtos= postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
       return postDtos;
    }


}
