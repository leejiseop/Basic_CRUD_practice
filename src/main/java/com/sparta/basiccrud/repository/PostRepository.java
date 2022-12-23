package com.sparta.basiccrud.repository;

import com.sparta.basiccrud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository <Post, Long>{
    List<Post> findAllByOrderByCreatedAtDesc(); // public 쓰면 안되나?
}
