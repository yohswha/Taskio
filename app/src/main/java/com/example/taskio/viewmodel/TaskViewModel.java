package com.example.taskio.viewmodel;
import android.content.Context;
import com.example.taskio.model.Task;
import com.example.taskio.model.TaskRepository;
import java.util.List;

public class TaskViewModel {
    private TaskRepository repository;
    public TaskViewModel(Context context) { repository = new TaskRepository(context); }
    public List<Task> getTasks() { return repository.getAllTasks(); }
    public void addTask(String title, String description) { repository.insertTask(title, description); }
    public void deleteTask(int id) { repository.deleteTask(id); }
    public Task getTaskById(int id) {
        return repository.getTaskById(id);
    }
    public void updateTask(int id, String newTitle, String newDesc) {
        repository.updateTask(id, newTitle, newDesc);
    }
}
