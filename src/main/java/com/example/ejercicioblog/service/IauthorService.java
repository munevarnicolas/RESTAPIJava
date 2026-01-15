package com.example.ejercicioblog.service;

import com.example.ejercicioblog.model.Author;

import java.util.List;
import java.util.Optional;

public interface IauthorService {
    List<Author> obtenerTodos();
    Optional<Author> obtenerPorId(Long id);
    Author guardarAuthor(Author author);
}