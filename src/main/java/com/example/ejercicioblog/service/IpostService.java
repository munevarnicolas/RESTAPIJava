package com.example.ejercicioblog.service;

import com.example.ejercicioblog.model.Comment;
import com.example.ejercicioblog.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IpostService
{
    List<Posteo> obtenerTodos();
    Optional<Posteo> obtenerPorId(Long id);
    Posteo guardarPost(Posteo posteo);
    void deletePost(Long id);
    void editarPost(Long id, Posteo posteoActualizado);
    Posteo agregarComment(Long postId, Comment comment);
    Posteo asignarAuthor(Long postId, Long authorId);
}