package com.example.erick.serviciorest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.erick.model.Example;
import com.example.erick.model.Pago;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class RestService extends AppCompatActivity  {

    private ListView list;
    RequestQueue requestQueue;
    TextView textViewService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = (ListView) findViewById(R.id.custom_list);
        requestQueue = Volley.newRequestQueue(this);
                consumirServicioDePagos();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void consumirServicioDePagos() {
        String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
        final Gson gson = new Gson();
        final List<Example> listPago = new ArrayList<>();
        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0) {
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject jsonObj = response.getJSONObject(i);
                                    Example pago = gson.fromJson(jsonObj.toString(), Example.class);
                                    listPago.add(pago);
                                } catch (JSONException e) {
                                    Log.e("Error", "Invalid JSON Object.");
                                }
                            }
                            PagoAdapter productAdapter = new PagoAdapter(listPago, RestService.this);
                            list.setAdapter(productAdapter);
                        } else {
                            Log.e("WARNING", "The response is empty.");
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", error.toString());
                    }
                }
        );
        requestQueue.add(arrReq);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
