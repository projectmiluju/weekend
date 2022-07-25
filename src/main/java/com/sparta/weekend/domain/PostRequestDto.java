package com.sparta.weekend.domain;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String username;
    private String contents;
    private String password;
}