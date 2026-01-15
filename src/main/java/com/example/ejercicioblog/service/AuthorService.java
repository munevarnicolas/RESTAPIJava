package com.example.ejercicioblog.service;

import com.example.ejercicioblog.model.Author;
import com.example.ejercicioblog.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IauthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> obtenerTodos() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> obtenerPorId(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author guardarAuthor(Author author) {
        return authorRepository.save(author);
    }
}