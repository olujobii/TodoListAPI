package com.olujobii.tasktrackerapi.service;

import com.olujobii.tasktrackerapi.entity.Task;
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
        if(task.getTitle().isEmpty() || task.getDescription().isEmpty())
            return null;

        taskRepository.save(task);
        return task;
    }

    public Task getSpecificTask(int id){
        List<Task> taskList = taskRepository.getTaskList();
        if(id < 1 || id > taskList.size())
            return null;

        int index = id - 1;
        return taskList.get(index);
    }

    public Task updateSpecificTask(int id, Task task){
        List<Task> taskList = taskRepository.getTaskList();

        if(task.getTitle().isEmpty() || task.getDescription().isEmpty())
            return null;

        if(id < 1 || id > taskList.size())
            return null;

        int index = id - 1;
        Task specificTask = taskList.get(index);

        specificTask.setTitle(task.getTitle());
        specificTask.setDescription(task.getDescription());

        return specificTask;
    }

    public boolean deleteSpecificTask(int id){
        if(id < 1 || id > taskRepository.getTaskList().size())
            return false;

        taskRepository.delete(id);
        return true;
    }
}
