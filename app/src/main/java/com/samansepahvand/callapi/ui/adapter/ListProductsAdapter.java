package com.samansepahvand.callapi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samansepahvand.callapi.R;
import com.samansepahvand.callapi.helper.Constant;
import com.samansepahvand.callapi.model.GetProductsModelResult;

import java.util.List;

public class ListProductsAdapter extends RecyclerView.Adapter<ListProductsAdapter.MyViewHolder> {


    private Context mContext;
    private List<GetProductsModelResult.Products> productsList;


    public ListProductsAdapter(Context mContext, List<GetProductsModelResult.Products> productsList) {
        this.mContext = mContext;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_products, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        GetProductsModelResult.Products item = productsList.get(position);


        holder.txtId.setText(item.getId());
        holder.txtName.setText(item.getName());


        try {
            Glide.with(mContext)
                    .load(Constant.API_URL_IMAGE + item.getImages().get(0))
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.images);
        } catch (Exception e) {
        }


    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtId, txtName;
        private ImageView images;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {

            txtId = itemView.findViewById(R.id.txt_id);
            txtName = itemView.findViewById(R.id.txt_name);
            images = itemView.findViewById(R.id.img_images);

        }
    }
}
