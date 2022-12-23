package com.sparta.basiccrud.controller;

import com.sparta.basiccrud.dto.PostRequestDto;
import com.sparta.basiccrud.entity.Post;
import com.sparta.basiccrud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController // 의미 알아볼 것
@RequiredArgsConstructor // 의미 알아볼 것
public class PostController {
    private final PostService postService;

    @GetMapping("/") // 바로 전체 게시글 목록 조회 API
    public ModelAndView home() {
        // templates에 반환할 html 이름을 적는다
        return new ModelAndView("index");
    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto); // Memo 객체 return? 어디로 가나
    }

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/api/details/{id}")
    public ModelAndView details(@PathVariable Long id) {
        Post selectedPost = postService.findPostById(id);
        ModelAndView modelAndView = new ModelAndView("details");
        modelAndView.addObject("post", selectedPost);
        return modelAndView;
    }

    @PutMapping("/api/details/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        // 비밀번호 따로 받아와서 확인하는 과정 추가... 비밀번호 다르면 익셉션 리턴해야 하나?
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/details/{id}")
    public String deletePost(@PathVariable Long id, @RequestBody String password) {
        return postService.deletePost(id, password);
    }
}





