package com.example.ejercicioblog.service;

import com.example.ejercicioblog.model.Author;
import com.example.ejercicioblog.model.Comment;
import com.example.ejercicioblog.model.Post;
import com.example.ejercicioblog.repository.AuthorRepository;
import com.example.ejercicioblog.repository.IpostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IpostService{

    private final IpostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostService(IpostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Post> obtenerTodos() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> obtenerPorId(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post guardarPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void editarPost(Long id, Post postActualizado) {
        Post postExistente = postRepository.findById(id).orElse(null);

        if (postExistente != null){
            postExistente.setTitulo(postActualizado.getTitulo());
            postExistente.setContenido(postActualizado.getContenido());
            postExistente.setFechaCreacion(postActualizado.getFechaCreacion());

            postRepository.save(postExistente);
        } else {
            throw new RuntimeException("Post no encontrado con el id: " + id);
        }
    }

    @Override
    public Post agregarComment(Long postId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        comment.setPost(post);
        post.getComments().add(comment);

        return postRepository.save(post);
    }

    @Override
    public Post asignarAuthor(Long postId, Long authorId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author no encontrado"));

        post.setAuthor(author);

        return postRepository.save(post);
    }
}