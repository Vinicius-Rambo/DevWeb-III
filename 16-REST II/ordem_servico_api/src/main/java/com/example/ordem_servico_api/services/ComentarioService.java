package com.example.ordem_servico_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordem_servico_api.entities.Comentario;
import com.example.ordem_servico_api.exceptions.ResourceNotFoundException;
import com.example.ordem_servico_api.repositories.ComentarioRepository;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    public List<Comentario> findAll() {
       return comentarioRepository.findAll();
    }

    public Comentario getById(Long id){
        return comentarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comentario", id));
        
    }

    public Comentario save(Comentario comentario) {
        if(comentario.getDescricao() == null || comentario.getDescricao().trim().isEmpty()){
            throw new IllegalArgumentException("O texto do comentario não pode ser vazio.");
        }

        if(comentario.getDescricao().trim().length() < 5){
            throw new IllegalArgumentException("O texto do comentario deve ter no minimo 5 caracteres");
        }

        return comentarioRepository.save(comentario);
    }

    public Comentario update(Long id, Comentario comentario) {
        Comentario comentarioExistente = comentarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comentario", id));

        //Regras de negocio para comentário
        comentarioExistente.setDescricao(comentario.getDescricao());
        return comentarioRepository.save(comentarioExistente);
    }

    public void delete(Long id) {
        comentarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comentario", id));

        comentarioRepository.deleteById(id);
    }

}
