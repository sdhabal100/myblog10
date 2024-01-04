package com.demo.myblog10.repository;

import com.demo.myblog10.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
