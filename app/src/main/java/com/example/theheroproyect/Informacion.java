package com.example.theheroproyect;

import android.content.Intent;
import android.os.Bundle;

import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Informacion extends AppCompatActivity {

    private RequestQueue mQueue;
    private String busqueda = "";
    private static String url_source = "https://superheroapi.com/api.php/3064099423635247/search/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        mQueue = Volley.newRequestQueue(this);
        Intent main = getIntent();
        this.busqueda = (String)main.getExtras().get("idheroe");
        buscarHeroe(busqueda);
    }

    private void buscarHeroe(String busqueda) {
        String url_Busqueda = url_source + busqueda;

        final TextView txtResultadosLen = (TextView) findViewById(R.id.txtResultados);
        Intent listado_heroes = new Intent(getBaseContext(), Informacion.class);


        final ScrollView scrollContenedorHeroes = (ScrollView) findViewById(R.id.ContenedorHeroes);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url_Busqueda, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            txtResultadosLen.setText( String.valueOf(response.getJSONArray("results").length()));
                            LinearLayout linearHeroes = (LinearLayout) findViewById(R.id.listaHero3);

                            for(int i = 0 ; i<response.getJSONArray("results").length();i++){
                                TextView nombreHeroe = new TextView(Informacion.this);
                                final JSONObject j = (JSONObject)response.getJSONArray("results").get(i);

                                nombreHeroe.setTextSize(24);
                                System.out.println(j.getString("name").toString());


                                nombreHeroe.setText(j.getString("name").toString());
                                linearHeroes.addView(nombreHeroe);

                                nombreHeroe.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        try {
                                            Intent grafica_heroes = new Intent(getBaseContext(), Tabla.class);
                                            grafica_heroes.putExtra("nombre_heroe", j.getString("name"));
                                            //grafica_heroes.putExtra("nombre_heroe", j.g("name"));
                                            startActivity(grafica_heroes);
                                            System.out.println(j.getString("name"));
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                            scrollContenedorHeroes.addView(linearHeroes);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog alertDialog = new
                        AlertDialog.Builder(Informacion.this).create();
                alertDialog.setTitle("Alerta!!!");
                alertDialog.setMessage("No existe dichos heroes");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int
                                    which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
        mQueue.add(request);
    }
}



