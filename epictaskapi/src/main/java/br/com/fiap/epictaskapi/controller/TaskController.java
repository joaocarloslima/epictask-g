package br.com.fiap.epictaskapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.service.TaskService;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;
    
    @GetMapping("/api/task")
    public List<Task> index(){
        return service.listAll();
    }

    @PostMapping("/api/task")
    public ResponseEntity<Task> create(@RequestBody @Valid Task task){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.save(task)
        );
    }

    @GetMapping("/api/task/{id}")
    public ResponseEntity<Task> show(@PathVariable UUID id){
        Optional<Task> optionalTask = service.get(id);
        // if(optionalTask.isEmpty()){
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        // }

        return ResponseEntity.ok(optionalTask.get());
    }
}
