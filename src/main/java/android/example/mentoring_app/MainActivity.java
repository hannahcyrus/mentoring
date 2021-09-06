package android.example.mentoring_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

private Button coordinator,mentor,student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinator=(Button)findViewById(R.id.coordinator_bt);
        coordinator.setOnClickListener(this);
        mentor=(Button)findViewById(R.id.mentor_bt);
        mentor.setOnClickListener(this);
        student=(Button)findViewById(R.id.student_bt);
        student.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coordinator_bt:
                startActivity(new Intent(this, login.class));
                break;
            case R.id.student_bt:
                startActivity(new Intent(this, login.class));
                break;

            case R.id.mentor_bt:
                startActivity(new Intent(this, login.class));
            break;


        }
    }
}