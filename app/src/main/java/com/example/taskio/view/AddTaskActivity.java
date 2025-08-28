package com.example.taskio.view;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.taskio.R;
import com.example.taskio.viewmodel.TaskViewModel;

public class AddTaskActivity extends AppCompatActivity {
    private EditText titleInput, descInput;
    private Button saveBtn;
    private TaskViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        titleInput = findViewById(R.id.titleInput);
        descInput = findViewById(R.id.descInput);
        saveBtn = findViewById(R.id.btnSave);
        viewModel = new TaskViewModel(this);

        saveBtn.setOnClickListener(v -> {
            String title = titleInput.getText().toString().trim();
            String desc = descInput.getText().toString().trim();
            if (!title.isEmpty()) {
                viewModel.addTask(title, desc);
                Toast.makeText(this, "Task saved", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Title required", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
