package mw.wpam.trainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    EditText train_name;
    String exc1, exc2, exc3, exc4, exc5, exc6, series;
    private Button add_button;
    private Spinner levels_spinner;
    private ArrayAdapter<String> levels_adapter;
    private Spinner times_spinner;
    private ArrayAdapter<String> times_adapter;
    private Spinner types_spinner;
    private ArrayAdapter<String> types_adapter;
    private CheckBox cbEquipment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        train_name = findViewById(R.id.training_name_input);

        levels_spinner = (Spinner) findViewById(R.id.spinner1); //dropdown list with workout levels


        levels_adapter = new ArrayAdapter<String>(AddActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.levels));
        levels_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levels_spinner.setAdapter(levels_adapter);

        times_spinner = (Spinner) findViewById(R.id.spinner2); //dropdown list with workout times

        times_adapter = new ArrayAdapter<String>(AddActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.times));
        times_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        times_spinner.setAdapter(times_adapter);

        types_spinner = (Spinner) findViewById(R.id.spinner3); //dropdown list with workout times

        types_adapter = new ArrayAdapter<String>(AddActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.types));
        types_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        types_spinner.setAdapter(types_adapter);




        //data from checkedbox
        cbEquipment = findViewById(R.id.eq_checkbox);




        //title_input = findViewById(R.id.title_input);
        //author_input = findViewById(R.id.author_input);
        //pages_input = findViewById(R.id.pages_input);


        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //data from spinners
                String level_choosed = levels_spinner.getSelectedItem().toString();
                String type_choosed = types_spinner.getSelectedItem().toString();
                String time_choosed = times_spinner.getSelectedItem().toString();

                if(level_choosed.equals("Beginner")){
                    if(type_choosed.equals("Push")){
                        if (cbEquipment.isChecked()) {
                            exc1="Mountain Climbers [30s]";
                            exc2="Knee Push-ups [10x]";
                            exc3="Push-ups  [3x]";
                            exc4="Elevated Push-ups [8x]";
                            exc5="Plank [30s]";
                            exc6="Push-up Hold  [15s]";

                        }else{
                            exc1="Mountain Climbers [30s]";
                            exc2="Knee Push-ups [10x]";
                            exc3="Push-ups  [3x]";
                            exc4="Elevated Push-ups [8x]";
                            exc5="Plank [30s]";
                            exc6="Push-up Hold  [15s]";
                        }

                    }else if(type_choosed.equals("Pull")){
                        if (cbEquipment.isChecked()) {
                            exc1="Jumping Jacks [30s]";
                            exc2="Negative Pull-ups[6x]";
                            exc3="Inclined Chin-ups [8x]";
                            exc4="Negative Chin-ups [6]";
                            exc5="Inclined Wide Pull-up [3]";
                            exc6="Pull-up Hold  [30s]";

                        }else{
                            exc1="Jumping Jacks [30s]";
                            exc2="Bridge    [30s]";
                            exc3="Superman Rises    [8x]";
                            exc4="High Plank    [30s]";
                            exc5="Quadruped Limb Raises [30s]";
                            exc6="Superman Hold [10s]";
                        }

                    }else if(type_choosed.equals("Cardio")){
                        if (cbEquipment.isChecked()) {
                            exc1="Jumping Rope [45s]";
                            exc2="Mountain Climbers [45s]";
                            exc3="Skippings [30s]";
                            exc4="Jumping Squats    [10x]";
                            exc5="Shadow Boxing [45s]";
                            exc6="Burpees   [16x]";

                        }else{
                            exc1="Jumping Jacks [45s]";
                            exc2="Mountain Climbers [45s]";
                            exc3="Skippings [30s]";
                            exc4="Jumping Squats    [10x]";
                            exc5="Shadow Boxing [45s]";
                            exc6="Burpees   [16x]";
                        }

                    }

                }else if(level_choosed.equals("Advanced")){
                    if(type_choosed.equals("Push")){
                        if (cbEquipment.isChecked()) {
                            exc1="Mountain Climbers [45s]";
                            exc2="Push-ups  [20]";
                            exc3="Dips  [10x]";
                            exc4="Straight Bar Dips [8x]";
                            exc5="Wide Push-ups [8x]";
                            exc6="Diamond Push-ups  [7x]";

                        }else{
                            exc1="Mountain Climbers [45s]";
                            exc2="Push-ups  [20]";
                            exc3="Wide Push-ups [8x]";
                            exc4="Pike Push Ups [5x]";
                            exc5="Push-up Hold  [30s]";
                            exc6="Diamond Push-ups  [7x]";
                        }

                    }else if(type_choosed.equals("Pull")){
                        if (cbEquipment.isChecked()) {
                            exc1="Jumping Jacks [45s]";
                            exc2="Pull-ups  [10x]";
                            exc3="Chin-ups  [8x]";
                            exc4="Wide Pull-ups [6x]";
                            exc5="Negative Pull-ups [10x]";
                            exc6="Inclined Chin-ups [8x]";

                        }else{
                            exc1="Jumping Jacks [45s]";
                            exc2="Bridge    [60s]";
                            exc3="Superman Rises    [14x]";
                            exc4="High Plank    [60s]";
                            exc5="Quadruped Limb Hold [2x15s]";
                            exc6="Superman Hold [30s]";
                        }

                    }else if(type_choosed.equals("Cardio")){
                        if (cbEquipment.isChecked()) {
                            exc1="Jumping Rope [90s]";
                            exc2="Mountain Climbers [60s]";
                            exc3="Skippings [60s]";
                            exc4="Jumping Squats    [12x]";
                            exc5="Shadow Boxing [60s]";
                            exc6="Burpees   [20x]";

                        }else{
                            exc1="Jumping Rope [90s]";
                            exc2="Mountain Climbers [60s]";
                            exc3="Skippings [60s]";
                            exc4="Jumping Squats    [12x]";
                            exc5="Shadow Boxing [60s]";
                            exc6="Burpees   [20x]";
                        }

                    }

                }

                if(time_choosed.equals("Short (25min)")) {
                    series = "Number of series: 1";
                }else if(time_choosed.equals("Long (60min)")){
                    series = "Number of series: 3\nRest between series: 90s";
                }

                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addPlan(train_name.getText().toString().trim(),
                        exc1,exc2,exc3,exc4,exc5, exc6, series);
                //finish();
            }
        });
    }
}
