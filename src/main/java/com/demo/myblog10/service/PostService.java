package com.demo.myblog10.service;

import com.demo.myblog10.paylode.PostDto;

public interface PostService {
    PostDto crestePost(PostDto postDto);

    PostDto getPostById(long id);
}
