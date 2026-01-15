package com.example.ejercicioblog.controller;

import com.example.ejercicioblog.model.Author;
import com.example.ejercicioblog.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author crearAuthor(@RequestBody Author author) {
        return authorService.guardarAuthor(author);
    }

    @GetMapping
    public List<Author> listarAuthors() {
        return authorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Author obtenerAuthor(@PathVariable Long id) {
        return authorService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Author no encontrado"));
    }
}