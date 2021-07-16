package zvhir.dev.design4.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import zvhir.dev.design4.devices.Lights;
import zvhir.dev.design4.devices.WaterHeater;
import zvhir.dev.design4.rooms.Kitchen;
import zvhir.dev.design4.rooms.LivingRoom;
import zvhir.dev.design4.rooms.Office;
import zvhir.dev.design4.R;
import zvhir.dev.design4.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private CardView card_meeting_room;
    private CardView card_living_room;
    private CardView card_office;
    private CardView card_kitchen;

    private CardView device_water_heater;
    private CardView device_lights;





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final TextView textView = binding.name;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Fade fade = new Fade();
        View decor = getActivity().getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);

        getActivity().getWindow().setEnterTransition(fade);
        getActivity().getWindow().setExitTransition(fade);


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        device_water_heater = view.findViewById(R.id.device_water_heater);
        device_water_heater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WaterHeater.class);
                startActivity(intent);
            }
        });

        device_lights = view.findViewById(R.id.device_lights);
        device_lights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Lights.class);
                startActivity(intent);
            }
        });

        ImageView shared_image_living_room = view.findViewById(R.id.img_living_room);
        card_living_room = view.findViewById(R.id.card_living_room);
        card_living_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LivingRoom.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        getActivity(), shared_image_living_room, ViewCompat.getTransitionName(shared_image_living_room));
                startActivity(intent, options.toBundle());
            }
        });

        ImageView shared_image_office = view.findViewById(R.id.img_office);
        card_office = view.findViewById(R.id.card_office);
        card_office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Office.class);
                ActivityOptionsCompat option2 = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        getActivity(), shared_image_office, ViewCompat.getTransitionName(shared_image_office));
                startActivity(intent, option2.toBundle());
            }
        });

        ImageView shared_image_kitchen = view.findViewById(R.id.img_kitchen);
        card_kitchen = view.findViewById(R.id.card_kitchen);
        card_kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Kitchen.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        getActivity(), shared_image_kitchen, ViewCompat.getTransitionName(shared_image_kitchen));
                startActivity(intent, options.toBundle());
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_living_room:

                Intent intent = new Intent(getActivity(), LivingRoom.class);
                startActivity(intent);
                break;
        }
    }
}