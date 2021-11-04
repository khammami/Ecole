package com.example.ecole;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Ecole> ecole =new ArrayList<Ecole>();
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls=findViewById(R.id.lst);

        ecole.add(new Ecole("ENET'Com","Ecole Nationale d'Electronique " +
                "et des Télécommunications de Sfax",R.drawable.enetcom));
        ecole.add(new Ecole("ENIS","École Nationale d'Ingénieurs de Sfax",R.drawable.enis));
        ecole.add(new Ecole("ENIM","École nationale d'ingénieurs de Monastir",R.drawable.enim));
        ecole.add(new Ecole("ENISO","Ecole Nationale des Ingénieurs de Sousse",R.drawable.eniso));
        ArrayAdapter<Ecole> adapter = new MyListAdapter();
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int i, long l) {
                Ecole clikedEcole = ecole.get(i);
                if (clikedEcole.getNom().equals("ENET'Com")){
                    String url = "http://www.enetcom.rnu.tn/";
                    Uri webpage = Uri.parse(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Log.d("ImplicitIntents", "Can't handle this intent! to enetcom");
                    }
                }

            }
        });

    }
    private class MyListAdapter extends ArrayAdapter<Ecole>{
        public MyListAdapter(){
            super(getApplicationContext(),R.layout.item,ecole);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            View itemView =convertView;
            if(itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item,parent,false);
            }
            Ecole currentEcole =ecole.get(position);
            ImageView imageView =(ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(currentEcole.getIconID());

            TextView textNom=(TextView) itemView.findViewById(R.id.txt1);
            textNom.setText(currentEcole.getNom());

            TextView textDes=(TextView) itemView.findViewById(R.id.txt2);
            textDes.setText(currentEcole.getDes());

            return itemView;
        }
    }
}