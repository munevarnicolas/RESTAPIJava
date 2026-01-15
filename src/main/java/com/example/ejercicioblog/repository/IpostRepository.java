package com.example.ejercicioblog.repository;

import com.example.ejercicioblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpostRepository extends JpaRepository<Post, Long>
{

}