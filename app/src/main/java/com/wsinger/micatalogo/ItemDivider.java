package com.wsinger.micatalogo;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemDivider extends RecyclerView.ItemDecoration{
    private static final int[] ATTRS =new int[]{android.R.attr.listDivider};//los atributos podemos obtener lineas, colores, etc.
    private Drawable divider;

    //Esta especificacion del contructor es para dibujar con las lineas que viene por defecto con android (sacado de android.R.attr.listdivider)
    public ItemDivider(Context context){
        final TypedArray styledAttributes = context.obtainStyledAttributes(ATTRS);
        divider= styledAttributes.getDrawable(0);
        styledAttributes.recycle(); //elimina el componente creado para liberar recursos, ya que ya se han entregado a la variable
        //divider.
    }
    //Esta especificacio del contructor es para usar la que yo defina a gusto. Puedo usar esta o la anterior.
    public ItemDivider(Context contentx, int resourceId){
        divider= ContextCompat.getDrawable(contentx, resourceId);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        //empezamos a dibujarlo por codigo sobre la recycleview en un area de dibujo canvas c.
        int leftStart= parent.getPaddingLeft(); //punto donde empieza la linea
        int rightEnd= parent.getWidth() - parent.getPaddingRight();//punto donde acaba la linea

        //saber cuantas rayas hay que dibujar.
        int countStripes = parent.getChildCount();
        for(int i=0;i<countStripes;i++){
            //dibuja cada una de los items. Del padre de la recycled view, obtiene el i-esimo hijo para dibujar
            View vchild = parent.getChildAt(i);
            //Parametros del layout a los que se van a anadir los margenes izq y derechos
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) vchild.getLayoutParams();

            int top= vchild.getTop() +params.bottomMargin;
            int bottom= top + divider.getIntrinsicHeight();

            //Asignamos los puntos del rectangulo alrededor de cada elemento de la recyclerview. La asigncion va siempre en sentido horario empezando por la izquierda
            divider.setBounds(leftStart,top,rightEnd,bottom);
            //Luego dibujamos
            divider.draw(c);
            //Por ultimo crear un xml en la carpeta drawable como sigue... (ir al archivo item_divider.xml para ver las especif)
        }
    }
}
