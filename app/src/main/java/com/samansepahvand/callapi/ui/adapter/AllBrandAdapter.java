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
import com.samansepahvand.callapi.model.GetAllBrandsModelResult;

import java.util.List;

public class AllBrandAdapter extends RecyclerView.Adapter<AllBrandAdapter.MyViewHolder> {


    private Context mContext;
    private List<GetAllBrandsModelResult.BrandList> resultList;
    private IGetBrand _iGetBrand;


    public interface IGetBrand {
        void GetBrand(GetAllBrandsModelResult.BrandList brandInfo);
    }


    public AllBrandAdapter(Context mContext, List<GetAllBrandsModelResult.BrandList> resultList) {
        this.mContext = mContext;
        this.resultList = resultList;
        this._iGetBrand = (IGetBrand) mContext;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_brand_category, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        GetAllBrandsModelResult.BrandList item = resultList.get(position);

        holder.txtId.setText(item.getId());
        holder.txtName.setText(item.getName());

        try {
            Glide
                    .with(mContext)
                    .load(Constant.API_URL_IMAGE+item.getImageAddress())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imgAddress);
        } catch (Exception e) {
        }

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtId, txtName;
        private ImageView imgAddress;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {

            txtId = itemView.findViewById(R.id.txt_id);
            txtName = itemView.findViewById(R.id.txt_name);
            imgAddress = itemView.findViewById(R.id.img_address);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    _iGetBrand.GetBrand(resultList.get(getAdapterPosition()));
                }
            });

        }


    }
}
