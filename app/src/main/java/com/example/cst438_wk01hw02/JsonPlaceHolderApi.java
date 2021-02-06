package com.example.cst438_wk01hw02;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();
}
