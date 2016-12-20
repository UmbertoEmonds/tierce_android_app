package com.example.admin.tp2.vue;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.admin.tp2.R;
import com.example.admin.tp2.controller.ClassementAdapter;
import com.example.admin.tp2.model.Cheval;

/**
 * Created by admin on 19/12/2016.
 */

public class DetailsFragment extends Fragment {

    private TextView nomTV;
    private TextView numeroTV;
    private TextView ageTV;
    private ListView listeClassementLV;
    private ClassementAdapter classementAdapter;
    private Switch switchF;
    Cheval cheval;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container,false);

        nomTV = (TextView)view.findViewById(R.id.nom);
        numeroTV = (TextView)view.findViewById(R.id.numero);
        ageTV = (TextView)view.findViewById(R.id.age);
        listeClassementLV = (ListView)view.findViewById(R.id.listviewClassement);
        switchF = (Switch)view.findViewById(R.id.switch1);

        switchF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                boolean isFavori = b;

                AccueilFragment firstFragment;

                cheval.setFavori(isFavori);

                firstFragment=(AccueilFragment) getTargetFragment();
                firstFragment.setResult(cheval);

            }
        });

        classementAdapter = new ClassementAdapter(getContext());
        listeClassementLV.setAdapter(classementAdapter);

        Bundle args=getArguments();
        cheval = (Cheval) args.getSerializable("currentCheval");

        nomTV.setText(cheval.getNom());
        numeroTV.setText(String.valueOf(cheval.getNumero()));
        ageTV.setText(String.valueOf(cheval.getAge()));
        switchF.setChecked(cheval.isFavori());

        for(int i = 0; i<cheval.getClassement().size(); i++){
            classementAdapter.add(cheval.getClassement().get(i));
        }

        return view;
    }
}
