package com.wsinger.micatalogo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wsinger.micatalogo.controllers.ArticulosAdapter;
import com.wsinger.micatalogo.data.AsyncDataResponse;
import com.wsinger.micatalogo.data.ProductData;
import com.wsinger.micatalogo.models.Articulo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    ArticulosAdapter articulosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setToolBar();
        setDrawer();

        progressBar = findViewById(R.id.progress_Bar);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.recyclerViewProductos);

        bringProducts();
        //articulosAdapter = new ArticulosAdapter(bringProducts());  // new ArticulosAdapter(inicializarDatosPrueba());

        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration(new ItemDivider(this, R.drawable.item_divider));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(articulosAdapter);


    }

    private void setDrawer() {

        drawerLayout = findViewById(R.id.drawer_layout);
        //Con esto hace aparecer las 3 rayitas del menu a la izq
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        //Set the actions when touch items
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();

                //van los fragments

                return false;
            }
        });
    }

    private void setToolBar() {

            toolbar = findViewById(R.id.tool_bar);

            if(toolbar != null){
                setSupportActionBar(toolbar);
            }

    }

    private static ArrayList<Articulo> inicializarDatosPrueba(){

        ArrayList<Articulo> f = new ArrayList<Articulo>();

        f.add(new Articulo("Zapatillas topper vs colores",2200,"Zapatillas reforzadas varios colores talle 36 al 43"));
        f.add(new Articulo("Camisa hombre",900,"Camisa a cuadro de vestir hombre/talles M, X, XL"));
        f.add(new Articulo("Vestido floreado",850,"Vestido dama floreado varios colores/motivos, talles S, M, X"));
        f.add(new Articulo("Pantalon Jean niño",1500,"Pantalon Jean colores azul marino, Negro, blanco, talles del 10 al 14"));
        f.add(new Articulo("Enterito bebe talle 1",900f,"Enterito bebe varios colores y motivos, varoncito y nenita"));
        return f;
    }

    //private ArrayList<Articulo> bringProducts(){
    private void bringProducts(){
        final ArrayList<Articulo> products= new ArrayList<Articulo>();

        new ProductData().getProductsFromApi(new AsyncDataResponse() {
            @Override
            public void processFinished(List arrayList) {
                products.addAll(arrayList);
                progressBar.setVisibility(View.INVISIBLE);

                articulosAdapter = new ArticulosAdapter(products);
                recyclerView.setAdapter(articulosAdapter);
            }

            @Override
            public void timeOutException() {
                progressBar.setVisibility(View.INVISIBLE);
                articulosAdapter = new ArticulosAdapter(products);
                recyclerView.setAdapter(articulosAdapter);
            }
        });


        //return products;
    }
}
