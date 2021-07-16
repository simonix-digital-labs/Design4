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

public class WaterHeater extends AppCompatActivity {

    CardView card_bedroom1;
    Switch switch_bedroom1;
    ImageView icon_bedroom1;
    TextView txt_title_bedroom1;
    TextView txt_desc_bedroom1;
    TextView txt_status_bedroom1;

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


        //INITIALIZED SHARED PREFERENCES
        SharedPreferences pref = getApplicationContext().getSharedPreferences("PLUG_STATUS", MODE_PRIVATE);

        //GET CURRENT STATUS FROM PREF
        boolean bedroom1_status= pref.getBoolean("BEDROOM1_STATUS", true);

        if (bedroom1_status){
            txt_title_bedroom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            txt_desc_bedroom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            txt_status_bedroom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            txt_status_bedroom1.setText("OFF");
            card_bedroom1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            switch_bedroom1.setChecked(false);

        }
        else {
            txt_title_bedroom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
            txt_desc_bedroom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
            txt_status_bedroom1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
            txt_status_bedroom1.setText("ON");
            switch_bedroom1.setChecked(true);

        }



    }
}