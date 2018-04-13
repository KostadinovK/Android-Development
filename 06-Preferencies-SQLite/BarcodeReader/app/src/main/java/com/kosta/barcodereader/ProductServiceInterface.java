package com.kosta.barcodereader;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductServiceInterface {

    public static final String URL = "https://world.openfoodfacts.org/";

    @GET("api/v0/product/{barcode}.json")
    Call<Model> getProductData(@Path("barcode") String barcode);

}