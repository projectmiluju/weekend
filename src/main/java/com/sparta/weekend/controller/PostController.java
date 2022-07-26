package com.sparta.weekend.controller;

import com.sparta.weekend.domain.Post;
import com.sparta.weekend.domain.PostRepository;
import com.sparta.weekend.domain.PostRequestDto;
import com.sparta.weekend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;


    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/posts/{id}")
    public List<Post> findPost(@PathVariable Long id) {
        return postRepository.findAllById(id);
    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    // 비밀번호 확인 API
    @PostMapping("/api/posts/{id}")
    public ResponseEntity<Map<String, Object>> validatePassword(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        boolean validation = postService.validatePassword(id, requestDto.getPassword());

        if (!validation) {
            throw new IllegalArgumentException("잘못된 비밀번호를 입력하였습니다.");
        }
        Map<String, Object> result = new HashMap<>();

        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }
}