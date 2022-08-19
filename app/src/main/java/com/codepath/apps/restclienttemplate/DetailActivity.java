package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.User;

import org.parceler.Parcels;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    User user;
    TwitterClient client;
    Tweet tweet;



    ImageView ivDetailProfile;
    TextView tvDetailName;
    TextView tvDetailScreenName;
    TextView tvTime;
    TextView body;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailName = findViewById(R.id.tvDetailName);
        ivDetailProfile = findViewById(R.id.ivDetailProfile);
        tvDetailScreenName = findViewById(R.id.tvDetailScreenName);
        tvTime=findViewById(R.id.tvDetailTime);
        body=findViewById(R.id.tvDetailBody);






        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        tvTime.setText(tweet.getFormattedTimestamp());
        tvDetailScreenName.setText(tweet.user.screenName);
        tvDetailName.setText(tweet.user.name);
        body.setText(tweet.body);







    }
}