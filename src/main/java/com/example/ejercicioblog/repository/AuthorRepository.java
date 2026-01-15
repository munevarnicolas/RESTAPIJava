package com.example.ejercicioblog.repository;

import com.example.ejercicioblog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}