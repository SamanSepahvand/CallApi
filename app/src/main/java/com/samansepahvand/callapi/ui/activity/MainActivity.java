package com.samansepahvand.callapi.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.samansepahvand.callapi.R;
import com.samansepahvand.callapi.api.ApiClient;
import com.samansepahvand.callapi.model.GetAllBrandsModelInput;
import com.samansepahvand.callapi.model.GetAllBrandsModelResult;
import com.samansepahvand.callapi.ui.adapter.AllBrandAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AllBrandAdapter.IGetBrand {
    private static final String TAG = "MainActivity";

     private  TextView txtResultResponse;
    private RecyclerView recyclerView;
    private AllBrandAdapter allBrandAdapter;
    private ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView(){
        txtResultResponse=findViewById(R.id.txt_header_result);

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        initData(); //call Api

    }


    private  void initData(){



        showDialog();
        Call<GetAllBrandsModelResult> call = ApiClient.getInstance().getMyApi().GetAllBrands(getAllBrand());

        call.enqueue(new Callback<GetAllBrandsModelResult>() {
            @Override
            public void onResponse(Call<GetAllBrandsModelResult> call, Response<GetAllBrandsModelResult> response) {
                hideDialog();

                GetAllBrandsModelResult result = response.body();

                txtResultResponse.setText(result.getMessage());

                allBrandAdapter=new AllBrandAdapter(MainActivity.this, result.getData());
                recyclerView.setAdapter(allBrandAdapter);


            }
            @Override
            public void onFailure(Call<GetAllBrandsModelResult> call, Throwable t) {
                hideDialog();



            }

        });
    }
    private GetAllBrandsModelInput getAllBrand() {
        GetAllBrandsModelInput modelInput=new GetAllBrandsModelInput();
        modelInput.setOrder("getAllBrands");
        modelInput.setInputData(null);
        return  modelInput;
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

    @Override
    public void GetBrand(GetAllBrandsModelResult.BrandList brandInfo) {

        if (brandInfo!=null){
            Intent intent =new Intent(this,DetailsActivity.class);
            intent.putExtra("Brand", brandInfo);
            startActivity(intent);
        }




    }
}