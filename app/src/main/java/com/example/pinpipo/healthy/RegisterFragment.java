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

public class RegisterFragment extends Fragment {
    @Nullable
    @Override

    public View onCreateView (@Nullable LayoutInflater inflater,
                              @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Button regisBtn = getView().findViewById(R.id.regis_regis_btn);
        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = (EditText) getView().findViewById(R.id.username);
                String usernameStr = username.getText().toString();

                EditText name = (EditText) getView().findViewById(R.id.name);
                String nameStr = name.getText().toString();

                EditText age = (EditText) getView().findViewById(R.id.age);
                String ageStr = age.getText().toString();

                EditText password = (EditText) getView().findViewById(R.id.password);
                String passwordStr = password.getText().toString();

                if (usernameStr.isEmpty() || nameStr.isEmpty() || ageStr.isEmpty() || passwordStr.isEmpty()){
                    Toast.makeText(
                            getActivity(),"กรุณาระบุข้อมูลให้ครบถ้วน",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER","FIELD NAME IS EMPTY");
                }else if (usernameStr.equals("admin")){
                    Toast.makeText(
                            getActivity(),"user นี้มีอยู่ในระบบแล้ว",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("REGISTER","USER ALREADY EXIST");
                }else{
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new BmiFragment()).commit();
                    Log.d("REGISTER","GOTO BMI");

                }


            }
        });


    }


}
