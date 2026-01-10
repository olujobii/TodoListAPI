package com.olujobii.tasktrackerapi.repository;

import com.olujobii.tasktrackerapi.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    private final List<Task> taskList;

    @Autowired
    public TaskRepository(List<Task> taskList){
        this.taskList = taskList;
        taskList.add(new Task("Read","Read Atomic Habits"));
        taskList.add(new Task("Study","Continue practicing Java"));
    }


    public List<Task> getTaskList(){
        return taskList;
    }

    public void save(Task task){
        taskList.add(task);
    }

    public void delete(int id) {
        int index = id - 1;
        taskList.remove(index);
    }
}
