package com.example.coinsdex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.coinsdex.coinsAPI.CoinsService;
import com.example.coinsdex.models.Coins;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG="COINS";

    private RecyclerView recyclerView;
    private RecyclerCoinsAdapter listaCoinsAdapter;

    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuracionRecyclerView();
        setRetrofit();
        obtenerDatos();
    }

    private void configuracionRecyclerView(){

        //seteando id de el recycler
        recyclerView=findViewById(R.id.recyclerview);

        //Instanciando el adaptador
        listaCoinsAdapter= new RecyclerCoinsAdapter(this);

        //Agregando el adaptador al objeto recycler
        recyclerView.setAdapter(listaCoinsAdapter);
        recyclerView.setHasFixedSize(true);

        //LayoutManager de el Recycler
       final GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setRetrofit(){
        retrofit= new Retrofit.Builder()
                .baseUrl("https://pdm-taller2.herokuapp.com/")
                //.baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("RETRO",retrofit.toString());
    }

    private void obtenerDatos() {
        //INTERFAZ
        CoinsService service = retrofit.create(CoinsService.class);

        //OBTENIENDO RESPUESTA
        Call <List<Coins>> coinsRespuestaCall=service.obtenerListaCoins();

        coinsRespuestaCall.enqueue(new Callback<List<Coins>>() {
            @Override
            public void onResponse(Call<List<Coins>> call, Response<List<Coins>> response) {
                if(response.isSuccessful()){

                    List<Coins> coinsList= response.body();


                    //AGREGANDO LOS RESULTADOS Al ADAPTADOR

                    listaCoinsAdapter.agregarCoinLista(coinsList);

                    /**
                    for(int i=0;i<coinsList.size();i++){
                        Coins coins=coinsList.get(i);
                        Log.i(TAG,"NOMBRE DE LA MONEDA: "+coins.getName());
                    }**/
                }
                else{
                    Log.e(TAG,"onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Coins>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }
}
