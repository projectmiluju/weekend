package com.sparta.weekend.controller;

import com.sparta.weekend.domain.Post;
import com.sparta.weekend.domain.PostRepository;
import com.sparta.weekend.domain.PostRequestDto;
import com.sparta.weekend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;


    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }
    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts/{id}")
    public List<Post> findPost(@PathVariable Long id) {
       return postRepository.findAllById(id);
    }

    // 비밀번호 확인 API

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }
}