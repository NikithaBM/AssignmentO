package com.nikitha.oyelabstask;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.ViewHolder>{

    private final MainActivity context;
    private final ArrayList<ItemModel> itemModelArrayList;

    public GroceryAdapter(MainActivity context, ArrayList<ItemModel> itemModelArrayList) {
        this.context = context;
        this.itemModelArrayList = itemModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.grocery_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel itemModel= itemModelArrayList.get(position);
        holder.tvName.setText(itemModel.name);
        Glide.with(context)
                .asBitmap()
                .apply(new RequestOptions().override(100, 100))
                .load(itemModel.image)
                .placeholder(R.drawable.giftcard)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(holder.img);

    holder.itemView.setOnClickListener(view -> {
        Intent intent = new Intent(context, GroceryDetails.class);
        intent.putExtra("name", itemModel.name);
        context.startActivity(intent);
    });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvGrocName);
            img = itemView.findViewById(R.id.imgGrocery);
        }
    }
}
