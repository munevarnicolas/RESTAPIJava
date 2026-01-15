package com.example.ejercicioblog.controller;

import com.example.ejercicioblog.model.Comment;
import com.example.ejercicioblog.model.Posteo;
import com.example.ejercicioblog.service.PosteoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PosteoController {
    private final PosteoService postService;

    public PosteoController(PosteoService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Posteo> listaPosts(){
        return postService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Posteo> obtenerPorId(@PathVariable Long id){
        return postService.obtenerPorId(id);
    }

    @PostMapping
    public Posteo guardarPost(@RequestBody Posteo post){
        return postService.guardarPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void editarPost(@PathVariable Long id, @RequestBody Posteo postActualizado){
        postService.editarPost(id, postActualizado);
    }

    @PostMapping("/{id}/comments")
    public Posteo agregarComment(@PathVariable Long id, @RequestBody Comment comment) {
        return postService.agregarComment(id, comment);
    }

    @PostMapping("/{postId}/authors/{authorId}")
    public Posteo asignarAuthor(@PathVariable Long postId, @PathVariable Long authorId) {
        return postService.asignarAuthor(postId, authorId);
    }
}