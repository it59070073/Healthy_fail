package com.example.pinpipo.healthy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BmiFragment extends Fragment{

    @Nullable
    @Override

    public View onCreateView(@Nullable LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_bmi, container, false);
    }

    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Button bmiBtn = getView().findViewById(R.id.bmi_btn);

        bmiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText height = (EditText) getView().findViewById(R.id.height);
                String heightInt = height.getText().toString();

                EditText weight = (EditText) getView().findViewById(R.id.weight);
                String weightInt = weight.getText().toString();

                if (heightInt.isEmpty() || weightInt.isEmpty()){
                    Toast.makeText(
                            getActivity(),"กรุณาระบุข้อมูลให้ครบถ้วน",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("BMI","FIELD NAME IS EMPTY");
                }

            }
        });
    }
}
