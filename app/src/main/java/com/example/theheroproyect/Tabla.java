package com.example.theheroproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;

public class Tabla extends AppCompatActivity {
    String  nombre_heroe = "";
    public BarChart grafico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);
        Intent heroelista = getIntent();
        this.nombre_heroe= (String)heroelista.getExtras().get("nombre_heroe");
        this.iniciarGrafico();
    }
    public void iniciarGrafico() {
        grafico = findViewById(R.id.barChart);
        grafico.getDescription().setEnabled(false);
        grafico.setMaxVisibleValueCount(60);
        grafico.setPinchZoom(false);
        grafico.setDrawBarShadow(false);
        grafico.setDrawGridBackground(false);
        XAxis xAxis = grafico.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        grafico.getAxisLeft().setDrawGridLines(false);
        grafico.animateY(1500);
        grafico.getLegend().setEnabled(false);
    }




}
