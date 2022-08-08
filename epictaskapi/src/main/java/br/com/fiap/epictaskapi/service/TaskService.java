package br.com.fiap.epictaskapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository repository;

    public List<Task> listAll(){
        return repository.findAll();
    }

    public Task save(Task task){
        return repository.save(task);
    }

    public Optional<Task> get(UUID id) {
        return repository.findById(id);
    }

}
