package com.sparta.weekend.service;

import com.sparta.weekend.domain.Post;
import com.sparta.weekend.domain.PostRepository;
import com.sparta.weekend.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }

    public boolean validatePassword(Long id, String password) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("잘못된 게시글 아이디를 입력하였습니다.")
        );
        return post.getPassword().equals(password);
    }
}