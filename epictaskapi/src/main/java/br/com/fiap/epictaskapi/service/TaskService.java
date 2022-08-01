package br.com.fiap.epictaskapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.epictaskapi.model.Task;

@Service
public class TaskService {
    
    public List<Task> listAll(){
        List<Task> lista = new ArrayList<>();

        lista.add(new Task("Modalagem do BD", "Modelagem das tabelas do banco de dados"));
        lista.add(new Task("Prototipação", "Prototipar a interface gráfica"));

        return lista;
    }

}
