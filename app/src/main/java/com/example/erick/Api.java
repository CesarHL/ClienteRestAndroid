package com.example.erick;

import com.example.erick.model.Pago;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Erick on 25/02/2018.
 */

public interface Api {

    @GET("pagos")
    Call<List<Pago>> getPagos();
}
