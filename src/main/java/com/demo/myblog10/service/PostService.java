package com.demo.myblog10.service;

import com.demo.myblog10.paylode.PostDto;

import java.util.List;

public interface PostService {
    PostDto crestePost(PostDto postDto);

    PostDto getPostById(long id);


    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
