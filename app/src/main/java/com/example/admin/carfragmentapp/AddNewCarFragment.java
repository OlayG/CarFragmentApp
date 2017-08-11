package com.example.admin.carfragmentapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class AddNewCarFragment extends Fragment {


    Car car;
    @BindView(R.id.etModel)
    EditText etModel;
    @BindView(R.id.etType)
    EditText etType;
    @BindView(R.id.etYear)
    EditText etYear;
    @BindView(R.id.btnSaveCar)
    Button btnSaveCar;
    Unbinder unbinder;

    public AddNewCarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_car, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSaveCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car = new Car(etModel.getText().toString().trim(), etType.getText().toString().trim(),
                        etYear.getText().toString().trim());
                DatabaseHelper db = new DatabaseHelper(v.getContext());
                db.saveNewContact(car);
                etModel.setText("");
                etType.setText("");
                etYear.setText("");

                CarRecyclerViewFragment carListView = new CarRecyclerViewFragment();
                getFragmentManager().beginTransaction().replace(R.id.flFrame2, carListView, "AddNewCarFragment").commit();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
