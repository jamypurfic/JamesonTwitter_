package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{

    // pass context and list of tweets

    List<Tweet> tweet;
    Context context;

    public TweetsAdapter(List<Tweet> tweet, Context context) {
        this.tweet = tweet;
        this.context = context;
    }

    // for each row inflate a layout

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // get date at position
        Tweet tweets = tweet.get(position);

        // bind tweet with vh
        holder.bind(tweets);

    }

    @Override
    public int getItemCount() {
        return tweet.size();
    }
// clear elements ont the RV
    public void clear() {
        tweet.clear();
        notifyDataSetChanged();
    }

    // add back a list of items

    public void addAll(List<Tweet> tweetList) {
        tweet.addAll(tweetList);
        notifyDataSetChanged();
    }
    // bind values based on the position

    // define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;
        TextView timeStamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            timeStamp = itemView.findViewById(R.id.timeStamp);
        }

        public void bind(Tweet tweet) {
            tvBody.setText((tweet.body));
            tvScreenName.setText((tweet.user.screenName));
            timeStamp.setText(tweet.getFormattedTimestamp());
            Glide.with(context).load(tweet.user.profileImageUrl)
                    .transform(new CircleCrop())
                    .into(ivProfileImage);
        }
    }
}

