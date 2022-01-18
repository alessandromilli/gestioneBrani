package com.example.musicatpsit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextAutore = (EditText) findViewById(R.id.editTextAutore);
        EditText editTextTitolo = (EditText) findViewById(R.id.editTextTitolo);

        Button buttonAdd = (Button) findViewById(R.id.addButton);
        Button buttonFind = (Button) findViewById(R.id.findButton);
        GestioneBrano gb = new GestioneBrano();
        ArrayList<String> generi = new ArrayList();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (spinner.getSelectedItem().toString().equals("Genere:")) {
                    Toast.makeText(getApplicationContext(), "Necessario selezionare il Genere", Toast.LENGTH_SHORT).show();
                } else {
                    if(editTextAutore.getText().toString().equals("Cerca Autore")||editTextTitolo.getText().toString().equals("Cerca Titolo")){
                        Toast.makeText(getApplicationContext(), "Necessario compilare tutti i campi", Toast.LENGTH_SHORT).show();
                    } else{
                        gb.inserisciBrano(editTextTitolo.getText().toString() , editTextAutore.getText().toString(), spinner.getSelectedItem().toString());


                        //open new activity

                    }
                }
            }
        });

        buttonFind.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (spinner.getSelectedItem().toString().equals("Genere:")) {
                    Toast.makeText(getApplicationContext(), "Necessario selezionare il Genere", Toast.LENGTH_SHORT).show();
                } else {
                    if(editTextAutore.getText().toString().equals("Cerca Autore")||editTextTitolo.getText().toString().equals("Cerca Titolo")){
                        Toast.makeText(getApplicationContext(), "Necessario compilare almeno tutti i campi", Toast.LENGTH_SHORT).show();
                    } else{
                        //The Spinner has been correctly selected
                        Brano foundB = gb.searchBrano(editTextTitolo.getText().toString() , editTextAutore.getText().toString(), spinner.getSelectedItem().toString());
                        if(foundB.getTitolo().isEmpty() && foundB.getGenere().isEmpty() && foundB.getAutore().isEmpty()){
                            Toast.makeText(getApplicationContext(), "Nessun Brano trovato", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Trovata una corrispondenza", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), showBrano.class);
                            i.putExtra("brano", );
                        }
                    }
                }
            }
        });

        //Popola spinner con Generi
        generi.add("Genere:");
        generi.add("rock");
        generi.add("pop");
        generi.add("jazz");
        generi.add("country");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, generi){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the second item from Spinner
                    return false;
                }
                else
                {
                    return true;
                }
            }
        };
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //Make

    }


}
