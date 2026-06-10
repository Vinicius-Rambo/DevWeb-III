package com.example.ordem_servico_api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ordem_servico_api.entities.Comentario;
import com.example.ordem_servico_api.services.ComentarioService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/comentarios")
public class ComentarioResources {

    @Autowired
    ComentarioService comentarioServices;
    
    @GetMapping
    public ResponseEntity<List<Comentario>> findAll(){   
        
        //ResponseEntity
        return ResponseEntity.status(HttpStatus.OK).body(comentarioServices.findAll());

        
        //return comentarioServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(comentarioServices.getById(id));
    }

    @PostMapping
    public ResponseEntity<Comentario> save(@RequestBody Comentario comentario){
        
        comentario = comentarioServices.save(comentario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(comentario.getId()).toUri();

        return ResponseEntity.created(uri).body(comentario);

    }

    @PostMapping("/{id}")
    public Comentario update(@PathVariable Long id, @RequestBody Comentario comentario){
        return comentarioServices.update(id,comentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        comentarioServices.delete(id);

        return ResponseEntity.noContent().build();
    }

  
    
}
