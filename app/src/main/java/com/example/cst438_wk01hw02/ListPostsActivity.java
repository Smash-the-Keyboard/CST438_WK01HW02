package com.example.cst438_wk01hw02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListPostsActivity extends AppCompatActivity {

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, ListPostsActivity.class);
        intent.putExtra("activity_name", ".ListPostsActivity"); // Used in unit testing
        return intent;
    }

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_posts);

        textViewResult = findViewById(R.id.text_view_result);

        // Generate welcome message
        TextView textViewWelcome = findViewById(R.id.welcome_message);
        String username = getIntent().getStringExtra("username");
        int userId =  getIntent().getIntExtra("user_id", 1);
        textViewWelcome.setText("Welcome, " + username + " (user id " + userId + ")");

        // Create Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create API instance
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        // Call getPosts method
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        // Execute call in a separate thread w/callback
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                // Display error message
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post : posts) {
                    // Only show posts with the same user Id as the user currently logged in
                    if (post.getUserId() == userId) {
                        String content = "";
                        content += "ID: " + post.getId() + "\n";
                        content += "User ID: " + post.getUserId() + "\n";
                        content += "Title: " + post.getTitle() + "\n";
                        content += "Body: " + post.getText() + "\n\n";
                        textViewResult.append(content);
                    }
                }
            }
            // Display error message
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}