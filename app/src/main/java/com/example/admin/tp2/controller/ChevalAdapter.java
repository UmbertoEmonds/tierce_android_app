package com.example.admin.tp2.controller;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.tp2.R;
import com.example.admin.tp2.model.Cheval;

/**
 * Created by admin on 15/12/2016.
 */

public class ChevalAdapter extends ArrayAdapter<Cheval> {

    public ChevalAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); // créer une vue à partir de notre .xml
            v = vi.inflate(R.layout.line_layout, null);
        }

        TextView numero;
        TextView nom;
        ImageView favori;
        Cheval item = getItem(position);

        numero = (TextView)v.findViewById(R.id.idCheval);
        nom = (TextView)v.findViewById(R.id.nomCheval);
        favori = (ImageView)v.findViewById(R.id.etoile);

        numero.setText(String.valueOf(item.getNumero()));

        if(item.isFavori()){
            favori.setVisibility(View.VISIBLE);
        }else{
            favori.setVisibility(View.INVISIBLE);
        }

        nom.setText(item.getNom());

        return v;

    }
}
