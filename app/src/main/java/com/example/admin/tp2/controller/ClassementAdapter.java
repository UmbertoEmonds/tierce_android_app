package com.example.admin.tp2.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.tp2.R;
import com.example.admin.tp2.model.Cheval;
import com.example.admin.tp2.model.Classement;

import java.util.ArrayList;

/**
 * Created by admin on 20/12/2016.
 */

public class ClassementAdapter extends ArrayAdapter<Classement> {

    public ClassementAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); // créer une vue à partir de notre .xml
            v = vi.inflate(R.layout.line_layout_classement, null);
        }

        TextView place;
        TextView date;
        Classement item = getItem(position);

        place = (TextView)v.findViewById(R.id.place);
        date = (TextView)v.findViewById(R.id.date);

        place.setText(String.valueOf(item.getPlace()));
        date.setText(String.valueOf(item.getDate()));



        return v;

    }

}
