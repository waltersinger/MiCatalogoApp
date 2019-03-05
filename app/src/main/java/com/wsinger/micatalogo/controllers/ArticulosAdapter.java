package com.wsinger.micatalogo.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wsinger.micatalogo.R;
import com.wsinger.micatalogo.models.Articulo;

import java.util.ArrayList;

public class ArticulosAdapter extends RecyclerView.Adapter<ViewHolderRv> {


    final ArrayList<Articulo> articuloArrayList;

    public ArticulosAdapter(ArrayList<Articulo> articuloArrayList) {
        this.articuloArrayList = articuloArrayList;

    }

    @Override
    public ViewHolderRv onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_view_productos,parent,false);
        ViewHolderRv viewHolderRv = new ViewHolderRv(view);

        return viewHolderRv;
    }

    @Override
    public void onBindViewHolder(ViewHolderRv holder, int position) {
         Articulo articulo = articuloArrayList.get(position);
        ImageView imageView = holder.imageViewProd;
        //Picasso.get().load(R.drawable.no_image).into(imageView);


        TextView textView = holder.textViewTitulo;
        textView.setText(articulo.getArticulo());

        TextView textViewD = holder.textViewDescripcion;
        textViewD.setText(articulo.getDescripcion());

        TextView textVprecio = holder.textViewPrecio;
        String precio = String.valueOf(articulo.getCosto());
        textVprecio.setText(precio);

    }

    @Override
    public int getItemCount() {
        return articuloArrayList.size();
    }
}
