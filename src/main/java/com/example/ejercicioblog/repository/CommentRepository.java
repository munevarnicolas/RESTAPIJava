package com.example.ejercicioblog.repository;

import com.example.ejercicioblog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}