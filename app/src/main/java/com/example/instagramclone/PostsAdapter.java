package com.example.instagramclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    // Using swiper to refresh
    public void clear (){
        posts.clear();
        notifyDataSetChanged();
    }

    // Using swiper to refresh
    public void addAll(List<Post> postList){
        posts.addAll(postList);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUsername;
        private ImageView ivImage;
        private TextView tvDescription;
        private TextView tvTimestamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvTimestamp = itemView.findViewById(R.id.tvTimestamp);
        }

        public void bind(Post post) {
            // Bind the post data to the view elements
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            Date timeStamp = post.getCreatedAt();
            String formattedDate = DateFormat.getDateInstance().format(timeStamp);
            String formattedTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(timeStamp);
            tvTimestamp.setText(formattedDate + " @ " + formattedTime);
            ParseFile image = post.getImage();
            if (image != null){
                Glide.with(context).load(post.getImage().getUrl()).into(ivImage);
            }
        }
    }
}
