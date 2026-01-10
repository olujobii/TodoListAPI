package com.olujobii.tasktrackerapi.controller;

import com.olujobii.tasktrackerapi.entity.Task;
import com.olujobii.tasktrackerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("")
    public List<Task> getTasksList(){
        return taskService.getTaskList();
    }

    @GetMapping("/{id}")
    public Task getTaskId(@PathVariable int id){
        return taskService.getSpecificTask(id);
        /* With return null for this GET method, even if I input an id that is not valid,
        it still returns HTTP status of 200?
        */
    }

    @PostMapping("")
    public Task saveTasksList(@RequestBody Task task){
        return taskService.saveTaskList(task);
        /* With return null for this POST method, if I do not input complete request body,
            it gives HTTP status of 500, should that be or should it not be 404?
        */
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task){
        return taskService.updateSpecificTask(id,task);
        /* With return null for this POST method, if I do not input complete request body,
            it gives HTTP status of 500, should that be or should it not be 404?

           ANSWER
           Spring has built-in exception handling that catches unhandled exception in
           controller.
           Spring will most likely return error 500 when it catches an unhandled exception in
           controller
        */
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable int id){
        return taskService.deleteSpecificTask(id);
    }
}
