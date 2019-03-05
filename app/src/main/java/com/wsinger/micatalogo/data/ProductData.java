package com.wsinger.micatalogo.data;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.wsinger.micatalogo.controllers.AppController;
import com.wsinger.micatalogo.models.Articulo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class ProductData {
    private ArrayList<Articulo> products = new ArrayList<>();

    public void getProductsFromApi(final AsyncDataResponse callback){
        final String url = "http://192.168.0.15:8080/articulos";

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("GET", "OK");
                try {

                    JSONArray jsonArray = response.getJSONArray("articulos");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Articulo articulo = new Articulo();
                        articulo.setId(jsonObject.getInt("id"));
                        articulo.setArticulo(jsonObject.getString("articulo"));
                        articulo.setImagen(jsonObject.getString("imagen"));
                        articulo.setDescripcion(jsonObject.getString("descripcion"));
                        articulo.setCosto(jsonObject.getDouble("costo"));
                        articulo.setId_categoria(jsonObject.getInt("id_categoria"));
                        articulo.setCantidad(jsonObject.getDouble("cantidad"));
                        articulo.setCalificacion(jsonObject.getInt("calificacion"));

                        products.add(articulo);
                        Log.d("ARTICULOS", jsonObject.toString()) ;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                }

                if(callback != null){
                    callback.processFinished(products);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("GET ERROR", error.toString());
                callback.timeOutException();
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type","application/json");
                headers.put("cache-control", "no-cache");


                return headers;
            }
        };


        AppController.getInstance().addToRequestQueue(objectRequest);
    }


}
