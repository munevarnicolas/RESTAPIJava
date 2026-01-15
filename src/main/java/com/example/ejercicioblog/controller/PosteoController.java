package com.example.ejercicioblog.controller;

import com.example.ejercicioblog.model.Post;
import com.example.ejercicioblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
class PostController
{
    private final PostService postService;

    @Autowired
    public PostController(PostService postService)
    {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> listaPosts()
    {
        return postService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Post> obtenerPorId(@PathVariable Long id)
    {
        return postService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarPost(@RequestBody Post post)
    {
        postService.guardarPost(post);
        return ResponseEntity.ok("Post agregado con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id)
    {
        postService.deletePost(id);
        return ResponseEntity.ok("Post eliminado con éxito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarPost(@PathVariable Long id, @RequestBody Post postActualizado)
    {
        postService.editarPost(id, postActualizado);
        return ResponseEntity.ok("Post actualizado con éxito");
    }
}