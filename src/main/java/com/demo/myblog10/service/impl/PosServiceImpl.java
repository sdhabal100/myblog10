package com.demo.myblog10.service.impl;

import com.demo.myblog10.entity.Post;
import com.demo.myblog10.paylode.PostDto;
import com.demo.myblog10.repository.PostRepository;
import com.demo.myblog10.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PosServiceImpl implements PostService {

    private PostRepository postRepository;

    public PosServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto crestePost(PostDto postDto) {
        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost = postRepository.save(post);
        PostDto dto=new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());

        return null;
    }
}
