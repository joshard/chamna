package com.example.root.chamna;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
 private Context mContext;
 private List<item> mData;

    public RecyclerViewAdapter(Context mContext, List<item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_book,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {




        myViewHolder.tv_item_title.setText(mData.get(i).getname());
        myViewHolder.tv_item_bonus.setText(mData.get(i).getname()+" "+mData.get(i).getprice()+"UGX Bonus: "+mData.get(i).getbonus());


        //myViewHolder.img_item_thumbnail.setImageResource(mData.get(i).getThumbnails());
        Bitmap dbimg = ImageUtils.convert(mData.get(i).getpic());
        myViewHolder.img_item_thumbnail.setImageBitmap(dbimg);
        //setting click listener
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,Item_activity.class);
                //passing data to the book activity
                intent.putExtra("ItemTitle",mData.get(i).getTitle());
                intent.putExtra("Details",mData.get(i).getDescription());

                intent.putExtra("Name",mData.get(i).getname());
                intent.putExtra("Price",mData.get(i).getprice());
                intent.putExtra("Pic",mData.get(i).getpic());
                intent.putExtra("Seller",mData.get(i).getseller());
                intent.putExtra("Bonus",mData.get(i).getbonus());



//                lstItem.add(new item(nam,cat,com,desc,pric,pii,seller,pi,R.drawable.cassava));

                //start the activity
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_item_title;
        TextView tv_item_bonus;
        ImageView img_item_thumbnail;
        CardView cardView;


        public MyViewHolder(View itemView){
            super(itemView);
            tv_item_title = (TextView) itemView.findViewById(R.id.item_id);
            tv_item_bonus = (TextView) itemView.findViewById(R.id.item_bonus);
            img_item_thumbnail=(ImageView) itemView.findViewById(R.id.image_id);
            cardView=(CardView)itemView.findViewById(R.id.cardView_id);


        }
    }
}
