package com.belen.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImgAerea extends AppCompatActivity {
private AdminSQL baseDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_aerea);
        if (baseDatos==null) {   // Abrimos a base de datos para escritura
            baseDatos = AdminSQL.getInstance(getApplicationContext());
            baseDatos.abrirBD();
        }
        ImageView vista =(ImageView) findViewById(R.id.Aerea);
        TextView tfase= (TextView) findViewById(R.id.Fase);
        TextView tnormas= (TextView) findViewById(R.id.normas);
        Bundle datos = this.getIntent().getExtras();
        String provincia = datos.getString("var");
        Log.d("avisob","aquí llego");
        ArrayList<String> lfase=baseDatos.checkfase(provincia);
        Log.d("aviso12","aquí llego");
        String fase=lfase.get(0);
        tfase.setText(fase);
        ArrayList<String> lnormas=baseDatos.checknormas(fase);
        String normas=lnormas.get(0);
        tnormas.setText(normas);
        switch (provincia) {
            case "A Coruña":
                vista.setImageResource(R.drawable.coru);
                break;
            case "Lugo":
                vista.setImageResource(R.drawable.lugo);
                break;
            case "Pontevedra":
                vista.setImageResource(R.drawable.ponte);
                break;
            case "Ourense":
                vista.setImageResource(R.drawable.orense);
                break;
            default:
                break;
        }
    }
}
