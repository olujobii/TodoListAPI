package com.olujobii.tasktrackerapi.service;

import com.olujobii.tasktrackerapi.entity.Task;
import com.olujobii.tasktrackerapi.exception.InvalidTaskDataException;
import com.olujobii.tasktrackerapi.exception.ResourceNotFoundException;
import com.olujobii.tasktrackerapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTaskList(){
        return taskRepository.getTaskList();
    }

    public Task saveTaskList(Task task){
        handleTaskDataValidation(task);

        taskRepository.save(task);
        return task;
    }

    public Task getSpecificTask(int id){
        List<Task> taskList = taskRepository.getTaskList();
        if(id < 1 || id > taskList.size())
            throw new ResourceNotFoundException("Task not found");

        int index = id - 1;
        return taskList.get(index);
    }

    public Task updateSpecificTask(int id, Task task){
        List<Task> taskList = taskRepository.getTaskList();

        handleTaskDataValidation(task);
        if(id < 1 || id > taskList.size())
            throw new ResourceNotFoundException("Task not found");

        int index = id - 1;
        Task specificTask = taskList.get(index);

        //SETTING TASK WITH UPDATED TASK TITLE AND DESCRIPTION
        specificTask.setTitle(task.getTitle());
        specificTask.setDescription(task.getDescription());
        return specificTask;
    }

    public void deleteSpecificTask(int id){
        if(id < 1 || id > taskRepository.getTaskList().size())
            throw new ResourceNotFoundException("Task not found");

        taskRepository.delete(id);
    }

    public void handleTaskDataValidation(Task task){
        if(( task.getTitle() == null || task.getTitle().isBlank()))
            throw new InvalidTaskDataException("title field cannot be empty");

        if(task.getDescription() == null || task.getDescription().isBlank())
            throw new InvalidTaskDataException("description field cannot be empty");

        //TRIM TO REMOVE UNNECESSARY WHITESPACE
        task.setTitle(task.getTitle().trim());
        task.setDescription(task.getDescription().trim());
    }
}
