package com.demo.myblog10.service.impl;

import com.demo.myblog10.entity.Post;
import com.demo.myblog10.exception.ResourceNotFoundException;
import com.demo.myblog10.paylode.PostDto;
import com.demo.myblog10.repository.PostRepository;
import com.demo.myblog10.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosServiceImpl implements PostService {

    private PostRepository postRepository;

    private ModelMapper modelMapper;

    public PosServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public PostDto crestePost(PostDto postDto) {
        Post post = maptoEntity(postDto);
        Post savedPost = postRepository.save(post);

        PostDto dto = maptoDto(savedPost);

        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post=postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post not found with id: "+ id)
        );
        PostDto dto=new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable =PageRequest.of(pageNo,pageSize, sort);
        Page<Post> pagePost = postRepository.findAll(pageable);
        List<Post> posts = pagePost.getContent();
        List<PostDto> dtos = posts.stream().map(p -> maptoDto(p)).collect(Collectors.toList());
        return dtos;
    }
    PostDto maptoDto(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }
    Post maptoEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }

}
