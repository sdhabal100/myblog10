package com.demo.myblog10.paylode;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String email;
    private String text;
}
