package com.example.recyclergrid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RViewAdapter extends RecyclerView.Adapter<RViewAdapter.RViewViewHolder> {

    private static List<String> titles;
    private static List<Integer> images;
    private LayoutInflater inflater;

    public RViewAdapter(Context context, List<String> titles, List<Integer> images) {
        /*
        * Remember!!!!
        *
        * Should be like the below if not static..
        * we also used these variables in onClick method hence the static qualifier
        *
        * this.titles = titles;
        * this.images = images;
        *
        * */

        RViewAdapter.titles = titles;
        RViewAdapter.images = images;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_list_item, parent, false);
        return new RViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RViewViewHolder holder, int position) {

        holder.title.setText(titles.get(position));
        holder.imageIcon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class RViewViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imageIcon;
        private final Context context;

        public RViewViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
            imageIcon = itemView.findViewById(R.id.imageView);
            context = itemView.getContext();


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(v.getContext() /*or context*/, "You Clicked on position -> "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ItemActivity.class);
                    intent.putExtra("title", titles.get(getAdapterPosition()));
                    intent.putExtra("image", images.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
