package com.kosta.barcodereader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txt_product_info)
    TextView mProductInfo;
    @BindView(R.id.edt_barcode)
    EditText mBarcode;

    private Model data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_submit)
    public void onSubmitBtnClicked(){
        if(mBarcode.getText().toString() != null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://world.openfoodfacts.org/api/v0/product/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ProductServiceInterface service = retrofit.create(ProductServiceInterface.class);

            service.getProductData(mBarcode.getText().toString()).enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    if (response.isSuccessful()) {
                        data = response.body();
                        Log.e("getCode: ",data.getProduct().getCode());

                        displayData(data);
                    }

                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Log.e("TAG", "Failure");
                }


            });

        }

    }

    public void displayData(Model data) {
        String code = data.getProduct().getCode();
        String s = data.getProduct().getIngredients_text();
        String s2 = data.getProduct().getProduct_name();

            mProductInfo.setText(code + " " + s + " " + s2);
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();


    }
}
