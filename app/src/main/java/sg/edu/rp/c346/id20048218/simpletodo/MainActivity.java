package sg.edu.rp.c346.id20048218.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText task;
    Button add, delete;
    ListView taskList;
    ArrayList<String> alTask;
    ArrayAdapter<String> aaTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = findViewById(R.id.etTask);
        add = findViewById(R.id.addBtn);
        delete = findViewById(R.id.clearBtn);
        taskList = findViewById(R.id.toDoTasks);
        alTask = new ArrayList<>();
        aaTask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTask);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = task.getText().toString();
                alTask.add(newTask);
                aaTask.notifyDataSetChanged();
                task.setText("");
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTask.clear();
                aaTask.notifyDataSetChanged();
            }
        });
    }
}