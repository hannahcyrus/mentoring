package android.example.mentoring_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;

public class welcome_cordd extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button assign,edit,view;
    private EditText addMent,deleteMent;
    private Button add,delete;
    private Button logout;
    ValueEventListener listener;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    DatabaseReference dref,dref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_cordd);
        assign=findViewById(R.id.assignbtn);

        addMent = (EditText)findViewById(R.id.addment);
        deleteMent=(EditText)findViewById(R.id.deletement);
        add=(Button)findViewById(R.id.submitadd);
        delete=(Button)findViewById(R.id.submitdel);
        logout=(Button)findViewById(R.id.logout_bt);
        Spinner spinner = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        dref= FirebaseDatabase.getInstance().getReference("mentor list");
        dref2= FirebaseDatabase.getInstance().getReference("students");
        list= new ArrayList<String>();
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.semester, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(this);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(welcome_cordd.this,MainActivity.class));
            }
        });

fetchData();

        dref= FirebaseDatabase.getInstance().getReference("mentor list");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });



    }

    private void insertData() {
        String data = addMent.getText().toString().trim();
        dref.push().setValue(data)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        addMent.setText("");
                        list.clear();
                        fetchData();
                        adapter.notifyDataSetChanged();
                        Toast.makeText(welcome_cordd.this,"sucessfully added",Toast.LENGTH_SHORT).show();


                    }
                });
    }

    public void fetchData(){
        listener=dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot mydata: snapshot.getChildren())
                    list.add(mydata.getValue().toString());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){


                    }
                }









    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}