package com.example.batapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;



public  class AdaptadorListaVillanos extends RecyclerView.Adapter<AdaptadorListaVillanos.VillanoViewHolder> {
    private ArrayList<Villano> villanos;

    public class VillanoViewHolder extends RecyclerView.ViewHolder{
        private TextView lblAlias;

        public VillanoViewHolder(View view){
            super(view);
            lblAlias = view.findViewById(R.id.lblAlias);
        }
    }
     public AdaptadorListaVillanos(ArrayList<Villano> villanos){
        this.villanos = villanos;
     }

     @Override

    public VillanoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_top5, parent, false);
        return new VillanoViewHolder(itemview);
     }

     @Override
    public void onBindViewHolder(VillanoViewHolder holder, int position){
        Villano villano = villanos.get(position);
        holder.lblAlias.setText(villanos.get(position).getAlias());
     }

     @Override
    public int getItemCount(){
        return villanos.size();
     }
}
