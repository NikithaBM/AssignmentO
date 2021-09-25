package com.nikitha.oyelabstask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView .Adapter<ItemAdapter.ViewHolder>{

    private final MainActivity context;
    private final ArrayList<ItemModel> itemModelArrayList;

    public ItemAdapter(MainActivity context, ArrayList<ItemModel> itemModelArrayList) {
        this.context = context;
        this.itemModelArrayList = itemModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel itemModel= itemModelArrayList.get(position);
        holder.tvName.setText(itemModel.name);
        holder.tvQuantity.setText(itemModel.quantity);
        Glide.with(context)
                .asBitmap()
                .apply(new RequestOptions().override(100, 100))
                .load(itemModel.image)
                .placeholder(R.drawable.giftcard)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvQuantity, tvPrice;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            img = itemView.findViewById(R.id.img);
        }
    }
}
