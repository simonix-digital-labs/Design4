package zvhir.dev.design4.devices;

import zvhir.dev.design4.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class WaterHeater extends AppCompatActivity {

    CardView card_bedroom1;
    Switch switch_bedroom1;
    ImageView icon_bedroom1;
    TextView txt_title_bedroom1;
    TextView txt_desc_bedroom1;
    TextView txt_status_bedroom1;

    CardView card_bedroom2;
    Switch switch_bedroom2;
    ImageView icon_bedroom2;
    TextView txt_title_bedroom2;
    TextView txt_desc_bedroom2;
    TextView txt_status_bedroom2;
    View line2;

    MaterialButton power;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_heater);
        card_bedroom1 = findViewById(R.id.card_bedroom1);
        switch_bedroom1 = findViewById(R.id.switch_bedroom1);
        icon_bedroom1 = findViewById(R.id.icon_bedroom1);
        txt_title_bedroom1 = findViewById(R.id.txt_title_bedroom1);
        txt_desc_bedroom1 = findViewById(R.id.txt_desc_bedroom1);
        txt_status_bedroom1 = findViewById(R.id.txt_status_bedroom1);
        card_bedroom2 = findViewById(R.id.card_bedroom2);
        switch_bedroom2 = findViewById(R.id.switch_bedroom2);
        icon_bedroom2 = findViewById(R.id.icon_bedroom2);
        txt_title_bedroom2 = findViewById(R.id.txt_title_bedroom2);
        txt_desc_bedroom2 = findViewById(R.id.txt_desc_bedroom2);
        txt_status_bedroom2 = findViewById(R.id.txt_status_bedroom2);
        line2 = findViewById(R.id.view2);
        switch_bedroom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_bedroom1.isChecked()) {
                    txt_status_bedroom1.setTextColor(getResources().getColor(R.color.green));
                    txt_status_bedroom1.setText("ON");

                } else {
                    txt_status_bedroom1.setTextColor(getResources().getColor(R.color.red));
                    txt_status_bedroom1.setText("OFF");


                }
            }
        });
        card_bedroom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_bedroom1.isChecked()) {
                    switch_bedroom1.setChecked(false);
                    txt_status_bedroom1.setText("OFF");
                    txt_status_bedroom1.setTextColor(getResources().getColor(R.color.red));


                } else {
                    switch_bedroom1.setChecked(true);
                    txt_status_bedroom1.setText("ON");
                    txt_status_bedroom1.setTextColor(getResources().getColor(R.color.green));


                }
            }
        });
        switch_bedroom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_bedroom2.isChecked()) {
                    txt_status_bedroom2.setText("ON");
                    txt_status_bedroom2.setTextColor(getResources().getColor(R.color.green));

                } else {
                    txt_status_bedroom2.setText("OFF");
                    txt_status_bedroom2.setTextColor(getResources().getColor(R.color.red));
                }
            }
        });
        card_bedroom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch_bedroom2.isChecked()) {
                    txt_status_bedroom2.setText("OFF");
                    txt_status_bedroom2.setTextColor(getResources().getColor(R.color.red));
                    switch_bedroom2.setChecked(false);
                } else {
                    txt_status_bedroom2.setText("ON");
                    txt_status_bedroom2.setTextColor(getResources().getColor(R.color.green));
                    switch_bedroom2.setChecked(true);
                }
            }
        });
        SharedPreferences.Editor editor = getSharedPreferences("REF_NAME", MODE_PRIVATE).edit();
        editor.putInt("STATE", 0);
        editor.apply();
        power = findViewById(R.id.power);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("REF_NAME", MODE_PRIVATE);
                int powerState = prefs.getInt("STATE", 0); //0 is the default value.
                if (powerState == 0) {
                    // BEDROOM 1
                    txt_status_bedroom1.setTextColor(getResources().getColor(R.color.red));
                    txt_status_bedroom1.setText("OFF");
                    switch_bedroom1.setChecked(false);
                    // BEDROOM 2
                    txt_status_bedroom2.setText("OFF");
                    switch_bedroom2.setChecked(false);
                    txt_status_bedroom2.setTextColor(getResources().getColor(R.color.red));
                    editor.putInt("STATE", 1);
                    editor.apply();
                    power.setText("Power all on");
                }
                if (powerState == 1) {
                    // BEDROOM 1
                    txt_status_bedroom1.setTextColor(getResources().getColor(R.color.green));
                    txt_status_bedroom1.setText("ON");
                    switch_bedroom1.setChecked(true);
                    // BEDROOM 2
                    txt_status_bedroom2.setText("ON");
                    switch_bedroom2.setChecked(true);
                    txt_status_bedroom2.setTextColor(getResources().getColor(R.color.green));
                    editor.putInt("STATE", 0);
                    editor.apply();
                    power.setText("Power all off");
                }


            }
        });

    }

}