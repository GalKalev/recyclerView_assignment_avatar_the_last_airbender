package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    ArrayList<DataModel> dataSet;

    public CustomeAdapter(ArrayList<DataModel> dataSet) {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;
        TextView textViewDes;
        TextView textViewExtendedDes; //added
        ImageView imageViewCharaImg;
        LinearLayout cardLayout;
        LinearLayout itemSection;
        ImageView arrowImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textView);
            textViewDes = itemView.findViewById(R.id.textView2);
            textViewExtendedDes = itemView.findViewById(R.id.extended_des); //added
            imageViewCharaImg = itemView.findViewById(R.id.imageView);
            cardLayout = itemView.findViewById(R.id.card_layout);
            itemSection = itemView.findViewById(R.id.item_section);
            arrowImage = itemView.findViewById(R.id.arrow_image);

            itemSection.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.item_section) {
                // Toggle visibility of textViewDes and textViewExtendedDes
                textViewDes.setVisibility(textViewDes.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                textViewExtendedDes.setVisibility(textViewExtendedDes.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                // Change arrowImage drawable based on textViewDes visibility
                arrowImage.setImageResource(textViewDes.getVisibility() == View.VISIBLE ? R.drawable.arrow_down : R.drawable.arrow_up);
            }
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewDes;
        TextView textViewExtendedDes = holder.textViewExtendedDes;
        ImageView imageView = holder.imageViewCharaImg;
        LinearLayout linearLayout = holder.cardLayout;

        textViewName.setText(dataSet.get(position).getName());
        textViewVersion.setText(dataSet.get(position).getVersion());
        textViewExtendedDes.setText(dataSet.get(position).getVersion());
        imageView.setImageResource(dataSet.get(position).getImage());
        linearLayout.setBackgroundResource(dataSet.get(position).getBg());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
