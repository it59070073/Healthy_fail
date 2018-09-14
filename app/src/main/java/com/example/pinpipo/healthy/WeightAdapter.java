package com.example.pinpipo.healthy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WeightAdapter extends ArrayAdapter<Weight> {

    Context context;
    ArrayList<Weight> weights = new ArrayList<Weight>();

    public WeightAdapter(@Nullable Context context,
                         int resource,
                         @Nullable List<Weight> objects){
        super(context, resource, objects);
        this.context = context;
        this.weights = (ArrayList<Weight>) objects; //ให้วน list ใน object นี้ สร้าง adaptor ไว้แล้วแต่ยังไม่ได้ลงที่ text


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View weightItem = LayoutInflater.from(context)
                .inflate(R.layout.fragment_weight_item,
                        parent,
                        false);

        TextView date = weightItem.findViewById(R.id.date);
        TextView weight = weightItem.findViewById(R.id.weight);
        TextView status = weightItem.findViewById(R.id.status);

        Weight row = weights.get(position);//set ของข้อความ

        date.setText(row.getDate());
        weight.setText(row.getWeight().toString());
        status.setText(row.getStatus());

        return weightItem; //ไม่มี void เลยต้อง return

    } //เอาข้อความอ่ะ เข้าไปใส่ใน fragment_weight_item นะจ้ะ
}
