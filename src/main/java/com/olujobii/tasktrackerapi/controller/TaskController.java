package com.olujobii.tasktrackerapi.controller;

import com.olujobii.tasktrackerapi.entity.Task;
import com.olujobii.tasktrackerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public List<Task> getTasksList(){
        return taskService.getTaskList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskId(@PathVariable int id){
        Task task = taskService.getSpecificTask(id);
         if(task == null)
             return ResponseEntity.notFound().build();

         return ResponseEntity.ok(task);
    }

    @PostMapping("/")
    public ResponseEntity<Task> saveTasksList(@RequestBody Task task){
        Task newTask = taskService.saveTaskList(task);
        if(newTask == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.status(201).body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task task){
        Task updatedTask = taskService.updateSpecificTask(id,task);
        if(updatedTask == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.status(201).body(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable int id){
        if(!taskService.deleteSpecificTask(id))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
