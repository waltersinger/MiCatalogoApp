package com.wsinger.micatalogo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wsinger.micatalogo.R;
import com.wsinger.micatalogo.models.Articulos;

import java.util.ArrayList;

public class ArticulosAdapter extends RecyclerView.Adapter<ViewHolderRv> {


    final ArrayList<Articulos> articulosArrayList;

    public ArticulosAdapter(ArrayList<Articulos> articulosArrayList) {
        this.articulosArrayList = articulosArrayList;

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
         Articulos articulos = articulosArrayList.get(position);
        ImageView imageView = holder.imageViewProd;
        Picasso.get().load(R.drawable.camera_icon).into(imageView);


        TextView textView = holder.textViewTitulo;
        textView.setText(articulos.getArticulo());

        TextView textViewD = holder.textViewDescripcion;
        textViewD.setText(articulos.getDescripcion());

        TextView textVprecio = holder.textViewPrecio;
        String precio = String.valueOf(articulos.getCosto());
        textVprecio.setText(precio);

    }

    @Override
    public int getItemCount() {
        return articulosArrayList.size();
    }
}
