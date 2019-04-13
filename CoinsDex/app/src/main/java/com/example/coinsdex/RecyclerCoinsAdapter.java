package com.example.coinsdex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.coinsdex.models.Coins;

import java.util.ArrayList;
import java.util.List;

public class RecyclerCoinsAdapter extends RecyclerView.Adapter<RecyclerCoinsAdapter.ViewHolder> {

    private List<Coins> dataset;

    private Context context;

    public RecyclerCoinsAdapter (Context context){
        this.context=context;
        dataset=new ArrayList<>();
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coins,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Coins cn=dataset.get(position);
        holder.nombreTextView.setText(cn.getName());

        //SE CARGAN LAS IMAGENES
        Glide.with(context)
                .load(cn.getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void agregarCoinLista(List<Coins> listaCoins){
        dataset.addAll(listaCoins);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoImageView;
        private TextView nombreTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            fotoImageView =  itemView.findViewById(R.id.fotoCoinsView);
            nombreTextView =  itemView.findViewById(R.id.nombreTextView);
        }
    }
}
