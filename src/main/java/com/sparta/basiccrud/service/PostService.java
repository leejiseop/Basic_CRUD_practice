package com.sparta.basiccrud.service;

import com.sparta.basiccrud.dto.PostRequestDto;
import com.sparta.basiccrud.entity.Post;
import com.sparta.basiccrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }

    @Transactional
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public Post findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 글입니다.")
        );
    }

    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 글입니다.")
        );
        post.update(requestDto);
        return post.getId();
    }

    @Transactional
    public String deletePost(Long id, String password) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 글입니다.")
        );
        if (post.isCorrectPassword(password)) {
            postRepository.deleteById(id);
            return "delete success";
        } else { return "wrong password"; }
    }
}
