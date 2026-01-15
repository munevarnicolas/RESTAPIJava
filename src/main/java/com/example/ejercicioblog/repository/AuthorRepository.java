package com.example.ejercicioblog.repository;

import com.example.ejercicioblog.model.Author;

import java.util.List;
import java.util.Optional;

public class AuthorRepository
{
    public List<Author> findAll()
    {
        return List.of();
    }

    public Optional<Author> findById(Long id)
    {
        return Optional.empty();
    }

    public Author save(Author author) {
        return author;
    }
}
