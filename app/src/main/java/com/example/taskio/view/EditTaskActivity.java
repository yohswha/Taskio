package com.example.taskio.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.taskio.R;
import com.example.taskio.model.Task;
import com.example.taskio.viewmodel.TaskViewModel;

public class EditTaskActivity extends AppCompatActivity {
    private EditText titleInput, descInput;
    private Button updateBtn;
    private TaskViewModel viewModel;
    private int taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        titleInput = findViewById(R.id.editTitleInput);
        descInput = findViewById(R.id.editDescInput);
        updateBtn = findViewById(R.id.btnUpdate);

        viewModel = new TaskViewModel(this);
        taskId = getIntent().getIntExtra("TASK_ID", -1);

        if (taskId != -1) {
            Task task = viewModel.getTaskById(taskId);
            titleInput.setText(task.getTitle());
            descInput.setText(task.getDescription());
        }

        updateBtn.setOnClickListener(v -> {
            String newTitle = titleInput.getText().toString().trim();
            String newDesc = descInput.getText().toString().trim();
            if (!newTitle.isEmpty()) {
                viewModel.updateTask(taskId, newTitle, newDesc);
                Toast.makeText(this, "Task updated", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Title is required", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
