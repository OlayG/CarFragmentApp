package com.example.admin.carfragmentapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarRecyclerViewFragment extends Fragment {


    @BindView(R.id.rvCarList)
    RecyclerView rvCarList;
    Unbinder unbinder;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    List<Car> carList = new ArrayList<>();
    CarListAdapter carListAdapter;
    @BindView(R.id.btnGridView)
    Button btnGridView;
    @BindView(R.id.btnListView)
    Button btnListView;
    @BindView(R.id.btnListHorizontal)
    Button btnListHorizontal;

    public CarRecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_car_recycler_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutManager = new LinearLayoutManager(view.getContext());
        itemAnimator = new DefaultItemAnimator();
        rvCarList.setLayoutManager(layoutManager);
        rvCarList.setItemAnimator(itemAnimator);
        DatabaseHelper db = new DatabaseHelper(view.getContext());
        carList = db.getCars();
        carListAdapter = new CarListAdapter(carList);
        rvCarList.setAdapter(carListAdapter);
        carListAdapter.notifyDataSetChanged();


    }

    public void changeLayout(View view){

        switch (view.getId()){
            case R.id.btnListHorizontal:
                rvCarList.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, true));
                break;
            case R.id.btnListView:
                rvCarList.setLayoutManager(layoutManager);
                break;
            case R.id.btnGridView:
                int colNum = 4;
                rvCarList.setLayoutManager(new GridLayoutManager(view.getContext(), colNum));
                break;
        }

        carListAdapter = new CarListAdapter(carList);
        rvCarList.setAdapter(carListAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
