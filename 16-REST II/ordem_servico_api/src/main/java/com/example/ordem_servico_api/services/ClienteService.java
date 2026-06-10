package com.example.ordem_servico_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ordem_servico_api.entities.Cliente;
import com.example.ordem_servico_api.repositories.ClienteRepository;
import com.example.ordem_servico_api.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }

    public Cliente findById(long id){
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente", id)); //Para lidar com optional objects
        
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente, Long id){
        return clienteRepository.save(cliente);
    }
     
    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}
