package com.example.taskio.model;
import android.content.Context;
import android.database.Cursor;
import com.example.taskio.data.DBHelper;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private DBHelper dbHelper;
    public TaskRepository(Context context) { dbHelper = new DBHelper(context); }

    public List<Task> getAllTasks() {
        List<Task> list = new ArrayList<>();
        Cursor cursor = dbHelper.getAllTasks();
        if (cursor.moveToFirst()) {
            do {
                list.add(new Task(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
    public void insertTask(String title, String desc) { dbHelper.insertTask(title, desc); }
    public void deleteTask(int id) { dbHelper.deleteTask(id); }

    public Task getTaskById(int id) {
        Cursor cursor = dbHelper.getTaskById(id);
        Task task = null;
        if (cursor != null && cursor.moveToFirst()) {
            task = new Task(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            cursor.close();
        }
        return task;
    }
    public void updateTask(int id, String newTitle, String newDesc) {
        dbHelper.updateTask(id, newTitle, newDesc);
    }
}
