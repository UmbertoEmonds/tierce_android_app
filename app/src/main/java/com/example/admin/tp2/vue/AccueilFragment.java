package com.example.admin.tp2.vue;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.admin.tp2.R;
import com.example.admin.tp2.controller.ChevalAdapter;
import com.example.admin.tp2.model.Cheval;
import com.example.admin.tp2.model.PMU;

import java.util.ArrayList;

/**
 * Created by admin on 19/12/2016.
 */

public class AccueilFragment extends Fragment {

    private Button jouerTV;
    private EditText nombreChevauxET;
    private ListView listeChevauxLV;
    private ChevalAdapter adapterChevaux;
    private Cheval chevalCurrent;

    PMU pmu  = new PMU();

    ArrayList<Cheval> resultatTierce = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapterChevaux = new ChevalAdapter(getContext());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.accueil_fragment, container,false);

        jouerTV = (Button)view.findViewById(R.id.jouer);
        nombreChevauxET = (EditText)view.findViewById(R.id.nombreChevauxET);
        listeChevauxLV = (ListView)view.findViewById(R.id.listView);

        listeChevauxLV.setAdapter(adapterChevaux);

        jouerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombreChevauxS = nombreChevauxET.getText().toString();

                if(nombreChevauxS.trim().equals("")){
                    alert("Veuillez saisir un nombre...");
                }
                else{

                    int nombreChevaux = Integer.parseInt(nombreChevauxET.getText().toString());

                    adapterChevaux.clear();

                    if(nombreChevaux>15){
                        alert("Veuillez saisir un nombre inferieur à 15");
                    }else{
                        resultatTierce = pmu.tirageTierce(nombreChevaux);

                        for (int i = 0; i < resultatTierce.size(); i++) {
                            adapterChevaux.add(resultatTierce.get(i));
                        }

                    }

                }



            }

        });

        listeChevauxLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Cheval param;
                Bundle args = new Bundle();

                param = (Cheval)adapterView.getItemAtPosition(i);
                args.putSerializable("currentCheval", param);

                pushSecondFragment(args);

            }
        });

        if(savedInstanceState==null){

        }else{
            nombreChevauxET.setText(savedInstanceState.getString("editText"));
            resultatTierce = (ArrayList<Cheval>)savedInstanceState.getSerializable("liste");

            for(int i = 0; i<resultatTierce.size(); i++){
                adapterChevaux.add(resultatTierce.get(i));
            }
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();



    }

    public void pushSecondFragment(Bundle args) {
        MainActivity mainActivity;
        DetailsFragment fragment;

        mainActivity=(MainActivity)getActivity();
        fragment=new DetailsFragment();
        fragment.setTargetFragment(this, 0);
        fragment.setArguments(args);
        mainActivity.pushFragment(fragment);

    }

    @Override
    public void onSaveInstanceState(Bundle params) {
        super.onSaveInstanceState(params);

        params.putString("editText", nombreChevauxET.getText().toString());
        params.putSerializable("liste", resultatTierce);

    }

    public void setResult(Cheval result) {
        this.chevalCurrent=result;
    }

    public Cheval getResult(){
        return chevalCurrent;
    }

    private void alert(String message){

        AlertDialog alert = new AlertDialog.Builder(getContext()).create();
        alert.setCancelable(false);
        alert.setMessage(message);

        alert.setButton(DialogInterface.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();

            }
        });

        alert.show();

    }

}
