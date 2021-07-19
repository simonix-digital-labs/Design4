package zvhir.dev.design4.devices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import zvhir.dev.design4.R;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import com.google.android.material.button.MaterialButton;

public class Lights extends AppCompatActivity {


    ImageView bulb1;
    ImageView bulb2;
    ImageView bulb3;
    ImageView bulb4;

    CardView card1;
    CardView card2;

    Switch switch5;

    ConstraintLayout constraint1;
    ConstraintLayout constraint2;
    ConstraintLayout constraint3;

    MaterialButton power;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);

        switch5 = findViewById(R.id.switch5);

        bulb1 = findViewById(R.id.bulb1);
        bulb2 = findViewById(R.id.bulb2);
        bulb3 = findViewById(R.id.bulb3);
        bulb4 = findViewById(R.id.bulb4);

        constraint1 = findViewById(R.id.constraint1);
        constraint2 = findViewById(R.id.constraint2);
        constraint3 = findViewById(R.id.constraint3);

        power = findViewById(R.id.power);

        SharedPreferences.Editor shared1 = getSharedPreferences("SWITCH1_REF", MODE_PRIVATE).edit();
        shared1.putInt("STATE", 1);
        shared1.apply();

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("SWITCH1_REF", MODE_PRIVATE);
                int powerState = prefs.getInt("STATE", 0); //0 is the default value.
                if (powerState == 0) {
                    bulb1.setBackgroundResource(R.drawable.bulb);
                    card1.setCardElevation(50);
                    card1.setCardBackgroundColor(Color.parseColor("#ffffff"));
                    shared1.putInt("STATE", 1);
                    shared1.apply();
                }
                if (powerState == 1) {
                    bulb1.setBackgroundResource(R.drawable.bulb_yellow);
                    card1.setCardElevation(40);
                    card1.setCardBackgroundColor(Color.parseColor("#fff8ed"));
                    shared1.putInt("STATE", 0);
                    shared1.apply();
                }
            }
        });

        SharedPreferences.Editor shared2 = getSharedPreferences("SWITCH2_REF", MODE_PRIVATE).edit();
        shared2.putInt("STATE", 1);
        shared2.apply();

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("SWITCH2_REF", MODE_PRIVATE);
                int powerState = prefs.getInt("STATE", 0); //0 is the default value.
                if (powerState == 0) {
                    bulb2.setBackgroundResource(R.drawable.bulb);
                    card2.setCardElevation(50);
                    card2.setCardBackgroundColor(Color.parseColor("#ffffff"));
                    shared2.putInt("STATE", 1);
                    shared2.apply();
                }
                if (powerState == 1) {
                    bulb2.setBackgroundResource(R.drawable.bulb_yellow);
                    card2.setCardElevation(40);
                    card2.setCardBackgroundColor(Color.parseColor("#fff8ed"));
                    shared2.putInt("STATE", 0);
                    shared2.apply();
                }
            }
        });

        SharedPreferences.Editor shared3 = getSharedPreferences("SWITCH3_REF", MODE_PRIVATE).edit();
        shared3.putInt("STATE", 1);
        shared3.apply();

        constraint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("SWITCH3_REF", MODE_PRIVATE);
                int powerState = prefs.getInt("STATE", 0); //0 is the default value.
                if (powerState == 0) {
                    bulb3.setBackgroundResource(R.drawable.bulb);
                    constraint1.setBackgroundColor(Color.parseColor("#ffffff"));
                    shared3.putInt("STATE", 1);
                    shared3.apply();
                    switch5.setChecked(false);
                }
                if (powerState == 1) {
                    bulb3.setBackgroundResource(R.drawable.bulb_yellow);
                    constraint1.setBackgroundColor(Color.parseColor("#fff8ed"));
                    shared3.putInt("STATE", 0);
                    shared3.apply();
                    switch5.setChecked(true);
                }
            }
        });

        SharedPreferences.Editor shared4 = getSharedPreferences("SWITCH4_REF", MODE_PRIVATE).edit();
        shared4.putInt("STATE", 1);
        shared4.apply();

        constraint2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("SWITCH4_REF", MODE_PRIVATE);
                int powerState = prefs.getInt("STATE", 0); //0 is the default value.
                if (powerState == 0) {
                    bulb4.setBackgroundResource(R.drawable.bulb);
                    constraint2.setBackgroundColor(Color.parseColor("#ffffff"));
                    shared4.putInt("STATE", 1);
                    shared4.apply();
                    switch5.setChecked(false);

                }
                if (powerState == 1) {
                    bulb4.setBackgroundResource(R.drawable.bulb_yellow);
                    constraint2.setBackgroundColor(Color.parseColor("#fff8ed"));
                    shared4.putInt("STATE", 0);
                    shared4.apply();
                    switch5.setChecked(true);

                }
            }
        });



//
//        SharedPreferences.Editor editor = getSharedPreferences("REF_NAME", MODE_PRIVATE).edit();
//        editor.putInt("STATE", 1);
//        editor.apply();
//        constraint3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences prefs = getSharedPreferences("REF_NAME", MODE_PRIVATE);
//                int powerState = prefs.getInt("STATE", 0); //0 is the default value.
//                if (powerState == 0) {
//                    bulb3.setBackgroundResource(R.drawable.bulb);
//                    switch3.setChecked(false);
//                    bulb4.setBackgroundResource(R.drawable.bulb);
//                    switch4.setChecked(false);
//                    switch5.setChecked(false);
//                    editor.putInt("STATE", 1);
//                    editor.apply();
//                }
//                if (powerState == 1) {
//                    bulb3.setBackgroundResource(R.drawable.bulb_yellow);
//                    switch3.setChecked(true);
//                    bulb4.setBackgroundResource(R.drawable.bulb_yellow);
//                    switch4.setChecked(true);
//                    switch5.setChecked(true);
//                    editor.putInt("STATE", 0);
//                    editor.apply();
//                }
//            }
//        });

        SharedPreferences.Editor shared5 = getSharedPreferences("SWITCH5_REF", MODE_PRIVATE).edit();
        shared5.putInt("STATE", 1);
        shared5.apply();

        switch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("SWITCH5_REF", MODE_PRIVATE);
                int powerState = prefs.getInt("STATE", 0); //0 is the default value.
                if (powerState == 0) {
                    bulb3.setBackgroundResource(R.drawable.bulb);
                    constraint1.setBackgroundColor(Color.parseColor("#ffffff"));
                    bulb4.setBackgroundResource(R.drawable.bulb);
                    constraint2.setBackgroundColor(Color.parseColor("#ffffff"));
                    shared5.putInt("STATE", 1);
                    shared5.apply();
                }
                if (powerState == 1) {
                    bulb3.setBackgroundResource(R.drawable.bulb_yellow);
                    constraint1.setBackgroundColor(Color.parseColor("#fff8ed"));
                    bulb4.setBackgroundResource(R.drawable.bulb_yellow);
                    constraint2.setBackgroundColor(Color.parseColor("#fff8ed"));
                    shared5.putInt("STATE", 0);
                    shared5.apply();
                }
            }
        });

        SharedPreferences.Editor shared_power = getSharedPreferences("POWER_REF", MODE_PRIVATE).edit();
        shared_power.putInt("STATE", 1);
        shared_power.apply();

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("POWER_REF", MODE_PRIVATE);
                int powerState = prefs.getInt("STATE", 0); //0 is the default value.
                if (powerState == 0) {
                    bulb1.setBackgroundResource(R.drawable.bulb);
                    card1.setCardBackgroundColor(Color.parseColor("#ffffff"));
                    bulb2.setBackgroundResource(R.drawable.bulb);
                    card2.setCardBackgroundColor(Color.parseColor("#ffffff"));
                    bulb3.setBackgroundResource(R.drawable.bulb);
                    constraint1.setBackgroundColor(Color.parseColor("#ffffff"));
                    bulb4.setBackgroundResource(R.drawable.bulb);
                    constraint2.setBackgroundColor(Color.parseColor("#ffffff"));
                    switch5.setChecked(false);
                    shared_power.putInt("STATE", 1);
                    shared_power.apply();
                }
                if (powerState == 1) {
                    bulb1.setBackgroundResource(R.drawable.bulb_yellow);
                    card1.setCardBackgroundColor(Color.parseColor("#fff8ed"));
                    bulb2.setBackgroundResource(R.drawable.bulb_yellow);
                    card2.setCardBackgroundColor(Color.parseColor("#fff8ed"));
                    bulb3.setBackgroundResource(R.drawable.bulb_yellow);
                    constraint1.setBackgroundColor(Color.parseColor("#fff8ed"));
                    bulb4.setBackgroundResource(R.drawable.bulb_yellow);
                    constraint2.setBackgroundColor(Color.parseColor("#fff8ed"));
                    switch5.setChecked(true);
                    shared_power.putInt("STATE", 0);
                    shared_power.apply();
                }
            }
        });

    }

}