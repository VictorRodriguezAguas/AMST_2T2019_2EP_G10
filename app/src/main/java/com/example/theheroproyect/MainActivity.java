package com.example.theheroproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import com.example.theheroproyect.R;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void buscarHeroe(View view ){
            final TextView buscar = (TextView) findViewById(R.id.Nombretxt);
            Intent manejoDeHeroes = new Intent(getBaseContext(), Informacion.class);
            manejoDeHeroes.putExtra("idheroe", buscar.getText().toString());
            startActivity(manejoDeHeroes);

    }
}
























/*

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


        public class MainActivity extends AppCompatActivity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
            }

            public void buscarHeroe(View view ){
                final TextView busqueda = (TextView) findViewById(R.id.txtBusquedaH);
                Intent manejoDeHeroes = new Intent(getBaseContext(), ManejoHeroes.class);
                manejoDeHeroes.putExtra("idheroe", busqueda.getText().toString());
                startActivity(manejoDeHeroes);
            }

        }


        public class GraficaPoderes extends AppCompatActivity {
            String  nombre_heroe = "";
            public BarChart graficoBarras;


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_grafica_poderes);
                Intent heroelista = getIntent();
                this.nombre_heroe= (String)heroelista.getExtras().get("nombre_heroe");
                this.iniciarGrafico();
            }


            public void iniciarGrafico() {
                graficoBarras = findViewById(R.id.barChart);
                graficoBarras.getDescription().setEnabled(false);
                graficoBarras.setMaxVisibleValueCount(60);
                graficoBarras.setPinchZoom(false);
                graficoBarras.setDrawBarShadow(false);
                graficoBarras.setDrawGridBackground(false);
                XAxis xAxis = graficoBarras.getXAxis();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setDrawGridLines(false);
                graficoBarras.getAxisLeft().setDrawGridLines(false);
                graficoBarras.animateY(1500);
                graficoBarras.getLegend().setEnabled(false);
            }




        }
package com.example.steven.examenfinalG1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.estudiante.examenfinalG1SS.R;

import org.json.JSONException;
import org.json.JSONObject;

        public class ManejoHeroes extends AppCompatActivity {

            private RequestQueue mQueue;
            private String busqueda = "";
            private static String url_source = "https://superheroapi.com/api.php/2556144074436346/search/";

            @Override
            protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_manejo_heroes);
                mQueue = Volley.newRequestQueue(this);
                Intent main = getIntent();
                this.busqueda = (String)main.getExtras().get("idheroe");
                buscarHeroe(busqueda);

            }

            /**
             * Recibe un String con el paràmetro de bùsqueda y llena el scrollbar con los nombres de los hèroes
             *
             * @param parametroDelHeroe
             */
/*
            public void buscarHeroe(String parametroDelHeroe){

                String url_Busqueda = url_source + parametroDelHeroe;

                final TextView txtResultadosLen = (TextView) findViewById(R.id.txtResultados);
                Intent listado_heroes = new Intent(getBaseContext(), ManejoHeroes.class);


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
                                        TextView nombreHeroe = new TextView(ManejoHeroes.this);
                                        final JSONObject j = (JSONObject)response.getJSONArray("results").get(i);

                                        nombreHeroe.setTextSize(24);
                                        System.out.println(j.getString("name").toString());


                                        nombreHeroe.setText(j.getString("name").toString());
                                        linearHeroes.addView(nombreHeroe);

                                        nombreHeroe.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                try {
                                                    Intent grafica_heroes = new Intent(getBaseContext(), GraficaPoderes.class);
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
                                AlertDialog.Builder(ManejoHeroes.this).create();
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

    }
}
*/
