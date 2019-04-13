package com.example.coinsdex.coinsAPI;

import com.example.coinsdex.models.Coins;
import com.example.coinsdex.models.CoinsRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinsService {

    @GET("coins")
    Call<List<Coins>> obtenerListaCoins();

}
