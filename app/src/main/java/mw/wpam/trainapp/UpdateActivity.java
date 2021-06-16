package mw.wpam.trainapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText train_name;
    Button update_button, delete_button;

    String id, trainName, exc1, exc2, exc3, exc4, exc5, exc6, series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        train_name = findViewById(R.id.title_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(trainName);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                trainName = train_name.getText().toString().trim();


                myDB.updateData(id, trainName);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("trainName") &&
                getIntent().hasExtra("exc1") && getIntent().hasExtra("exc2") &&
                getIntent().hasExtra("exc3") && getIntent().hasExtra("exc4") &&
                getIntent().hasExtra("exc5") && getIntent().hasExtra("exc6") &&
                getIntent().hasExtra("series")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            trainName = getIntent().getStringExtra("trainName");
            exc1 = getIntent().getStringExtra("exc1");
            exc2 = getIntent().getStringExtra("exc2");
            exc3 = getIntent().getStringExtra("exc3");
            exc4 = getIntent().getStringExtra("exc4");
            exc5 = getIntent().getStringExtra("exc5");
            exc6 = getIntent().getStringExtra("exc6");
            series = getIntent().getStringExtra("series");

            //Setting Intent Data
            //train_name.setText(trainName);
            //exc
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + trainName + "?");
        builder.setMessage("Are you sure you want to delete " + trainName + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
