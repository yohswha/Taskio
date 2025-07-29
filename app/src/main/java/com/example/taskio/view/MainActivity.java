package com.example.taskio.view;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.taskio.R;
import com.example.taskio.model.Task;
import com.example.taskio.view.adapter.TaskAdapter;
import com.example.taskio.viewmodel.TaskViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TaskViewModel viewModel;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new TaskViewModel(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> startActivity(new Intent(this, AddTaskActivity.class)));

        loadTasks();
    }

    private void loadTasks() {
        List<Task> tasks = viewModel.getTasks();
        adapter = new TaskAdapter(tasks, viewModel);
        adapter.setOnTaskClickListener(task -> {
            Intent intent = new Intent(this, EditTaskActivity.class);
            intent.putExtra("TASK_ID", task.getId());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTasks();
    }
}
