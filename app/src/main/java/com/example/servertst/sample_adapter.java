package com.example.servertst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class sample_adapter extends RecyclerView.Adapter<sample_adapter.sampleviewholder> {

    private Context context;
    private List<upload_data> upload_dataList;

    public sample_adapter(Context context, List<upload_data> upload_dataList)
    {
        this.context = context;
        this.upload_dataList = upload_dataList;
    }
    @NonNull
    @Override
    public sampleviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_item,parent,false);
        return new sampleviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sampleviewholder holder, int position) {
            upload_data upload_data = upload_dataList.get(position);

            holder.t1.setText(upload_data.getSample_name());
            holder.t2.setText(upload_data.getLocation());
            holder.t3.setText(upload_data.getAcoustic_value());
            holder.t4.setText(upload_data.getMineral());

        Picasso.with(context)
                .load(upload_data.getImageurl())
                .placeholder(R.drawable.ic_loading)
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return upload_dataList.size();
    }

    public class sampleviewholder extends RecyclerView.ViewHolder{

        public TextView t1,t2,t3,t4;
        public ImageView imageView;

        public sampleviewholder(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.sample_title);
            t2=itemView.findViewById(R.id.sample_location);
            t3=itemView.findViewById(R.id.sample_acoustic);
            t4=itemView.findViewById(R.id.sample_mineral);
            imageView = itemView.findViewById(R.id.sample_image);
        }
    }
}
