package br.com.fiap.epictaskapi.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskWebController {

    @Autowired
    TaskService service;
    
    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/task/undone");
        mav.addObject("tasks", service.listAll());
        return mav;
    }

    @GetMapping("new")
    public String createForm(){
        return "/task/form";
    }

}
