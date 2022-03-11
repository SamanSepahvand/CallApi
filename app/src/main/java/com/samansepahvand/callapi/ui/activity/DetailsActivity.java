package com.samansepahvand.callapi.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.samansepahvand.callapi.R;
import com.samansepahvand.callapi.api.ApiClient;
import com.samansepahvand.callapi.model.GetAllBrandsModelInput;
import com.samansepahvand.callapi.model.GetAllBrandsModelResult;
import com.samansepahvand.callapi.model.GetProductsModelResult;
import com.samansepahvand.callapi.model.InputData;
import com.samansepahvand.callapi.ui.adapter.AllBrandAdapter;
import com.samansepahvand.callapi.ui.adapter.ListProductsAdapter;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView txtResultResponse;
    public RecyclerView recyclerView;
    public ListProductsAdapter listProcdutsAdapter;
    public ProgressDialog dialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initView();

    }

    private void initView(){

        txtResultResponse=findViewById(R.id.txt_header_result);

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //get data from Intent
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            GetAllBrandsModelResult.BrandList resultAdapter= (GetAllBrandsModelResult.BrandList) getIntent().getSerializableExtra("Brand");
            if (resultAdapter!=null){
                initData(resultAdapter);
            }
        }else{
            Toast.makeText(getBaseContext(), "Error!", Toast.LENGTH_SHORT).show();
        }




    }


    private  void initData(GetAllBrandsModelResult.BrandList brandList){

        //fill model
        InputData inputData =new InputData();

        inputData.setBrandId(brandList.getId());


        GetAllBrandsModelInput modelInput=new GetAllBrandsModelInput();
        modelInput.setOrder("productList");
        modelInput.setInputData(inputData);



        showDialog();
        Call<GetProductsModelResult> call = ApiClient.getInstance().getMyApi().GetProducts(modelInput);
        call.enqueue(new Callback<GetProductsModelResult>() {
            @Override
            public void onResponse(Call<GetProductsModelResult> call, Response<GetProductsModelResult> response) {
                hideDialog();


              GetProductsModelResult result = response.body();


                txtResultResponse.setText(result.getMessage());
                listProcdutsAdapter=new ListProductsAdapter(DetailsActivity.this, result.getData());
                recyclerView.setAdapter(listProcdutsAdapter);


            }
            @Override
            public void onFailure(Call<GetProductsModelResult> call, Throwable t) {
                hideDialog();

                Log.e(TAG, "onResponse: "+t.getMessage());

            }

        });
    }



    public void showDialog() {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
        }
        dialog.setMessage("Calling Api..Please wait..");
        dialog.show();

    }
    public void hideDialog(){
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}