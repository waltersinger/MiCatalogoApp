package com.wsinger.micatalogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wsinger.micatalogo.controllers.ArticulosAdapter;
import com.wsinger.micatalogo.models.Articulos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewProductos);


        ArticulosAdapter articulosAdapter = new ArticulosAdapter(inicializarDatosPrueba());

        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration(new ItemDivider(this, R.drawable.item_divider));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(articulosAdapter);


    }
    private static ArrayList<Articulos> inicializarDatosPrueba(){

        ArrayList<Articulos> f = new ArrayList<Articulos>();

        f.add(new Articulos("Zapatillas topper vs colores",2200,"Zapatillas reforzadas varios colores talle 36 al 43"));
        f.add(new Articulos("Camisa hombre",900,"Camisa a cuadro de vestir hombre/talles M, X, XL"));
        f.add(new Articulos("Vestido floreado",850,"Vestido dama floreado varios colores/motivos, talles S, M, X"));
        f.add(new Articulos("Pantalon Jean niño",1500,"Pantalon Jean colores azul marino, Negro, blanco, talles del 10 al 14"));

        return f;
    }
}
