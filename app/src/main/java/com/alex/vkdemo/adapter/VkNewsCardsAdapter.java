package com.alex.vkdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.vkdemo.R;
import com.alex.vkdemo.dummy.VkNewsItem;
import com.alex.vkdemo.model.NewsDesc;
import com.alex.vkdemo.model.VkNewsResponse;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class VkNewsCardsAdapter extends RecyclerView.Adapter<VkNewsCardsAdapter.ContactViewHolder> {

    private final Context context;
    private final RecyclerView adapterView;
    private final  VkNewsResponse contactList;

    private OnItemClickListener itemClickListener;
    private LayoutInflater inflater;
    public VkNewsCardsAdapter(Context context,RecyclerView adapterView,VkNewsResponse contactList) {

            this.context=context;
        this.contactList = contactList;
        this.adapterView=adapterView;
        inflater= LayoutInflater.from(context);

    }
    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.itemClickListener=clickListener;
    }
    @Override
    public int getItemCount() {
          return contactList.getNewsCount();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, final int i) {
        VkNewsItem ci = contactList.get(i);
        if (itemClickListener!=null)
        {
            final View itemView=contactViewHolder.view;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(adapterView,itemView,i,getItemId(i));
                }
            });
        }
        if(ci.item!=null)
            if (ci.item.text!=null)
        contactViewHolder.newsText.setText(ci.item.text);

        NewsDesc desc = ci.getDescription();
        contactViewHolder.newsTitle.setText(desc.getTitle());
        if (desc.getLikeCount()==0)
            contactViewHolder.newsLikeCount.setVisibility(View.GONE);
        contactViewHolder.newsLikeCount.setText(String.valueOf(desc.getLikeCount()));
        contactViewHolder.newsPostDate.setText(String.valueOf(desc.getPostDate()));

        ImageLoader.getInstance().displayImage(desc.getPhotoUrl(), contactViewHolder.newsIcon);

   }

   @Override
   public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView =inflater.
                    inflate(R.layout.news_card_item, viewGroup, false);

        return new ContactViewHolder(itemView);
   }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        private  TextView newsPostDate;
        private  TextView newsLikeCount;
        protected  TextView newsTitle;
        protected TextView newsText;
        protected ImageView newsIcon;
            protected View view;
        public ContactViewHolder(View v) {
            super(v);
            this.view=v;
            newsText =  (TextView) v.findViewById(R.id.news_text);
            newsTitle= (TextView) v.findViewById(R.id.news_title);
            newsIcon= (ImageView) v.findViewById(R.id.news_icon);
            newsLikeCount= (TextView) v.findViewById(R.id.like_count);
            newsPostDate= (TextView) v.findViewById(R.id.post_date);

        }
    }

    public interface OnItemClickListener {

        void onItemClick(RecyclerView adapterView, View itemView, int i, long itemId);
    }

}