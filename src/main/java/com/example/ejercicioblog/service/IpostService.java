package com.example.ejercicioblog.service;

import com.example.ejercicioblog.model.Comment;
import com.example.ejercicioblog.model.Post;

import java.util.List;
import java.util.Optional;

public interface IpostService
{
    List<Post> obtenerTodos();
    Optional<Post> obtenerPorId(Long id);
    Post guardarPost(Post post);
    void deletePost(Long id);
    void editarPost(Long id, Post postActualizado);
    Post agregarComment(Long postId, Comment comment);
    Post asignarAuthor(Long postId, Long authorId);
}