package com.example.ejercicioblog.service;

import com.example.ejercicioblog.model.Author;
import com.example.ejercicioblog.model.Comment;
import com.example.ejercicioblog.model.Posteo;
import com.example.ejercicioblog.repository.AuthorRepository;
import com.example.ejercicioblog.repository.IpostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IpostService{

    private final IpostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PosteoService(IpostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Posteo> obtenerTodos() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Posteo> obtenerPorId(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Posteo guardarPost(Posteo post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void editarPost(Long id, Posteo postActualizado) {
        Posteo postExistente = postRepository.findById(id).orElse(null);

        if (postExistente != null){
            postExistente.setTitulo(postActualizado.getTitulo());
            postExistente.setContenido(postActualizado.getContenido());

            postRepository.save(postExistente);
        }
    }

    @Override
    public Posteo agregarComment(Long postId, Comment comment) {
        Posteo post = postRepository.findById(postId).orElse(null);

        if (post != null) {
            comment.setPost(post);
            post.getComments().add(comment);
            return postRepository.save(post);
        }
        return null;
    }

    @Override
    public Posteo asignarAuthor(Long postId, Long authorId) {
        Posteo post = postRepository.findById(postId).orElse(null);
        Author author = authorRepository.findById(authorId).orElse(null);

        if (post != null && author != null) {
            post.setAuthor(author);
            return postRepository.save(post);
        }
        return null;
    }
}