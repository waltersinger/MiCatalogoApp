package com.wsinger.micatalogo.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wsinger.micatalogo.R;

public class ViewHolderRv extends RecyclerView.ViewHolder {


    ImageView imageViewProd;
    TextView textViewTitulo;
    TextView textViewDescripcion;
    TextView textViewPrecio;

    public ViewHolderRv(View itemView) {
        super(itemView);
        imageViewProd = (ImageView) itemView.findViewById(R.id.image_view_producto);
        textViewDescripcion = (TextView) itemView.findViewById(R.id.tv_card_view_descripcioon);
        textViewTitulo = (TextView) itemView.findViewById(R.id.tv_card_view_titulo);
        textViewPrecio = (TextView) itemView.findViewById(R.id.text_view_precio);

    }


}
