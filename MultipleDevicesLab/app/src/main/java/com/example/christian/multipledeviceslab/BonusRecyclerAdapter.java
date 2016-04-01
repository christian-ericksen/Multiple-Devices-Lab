package com.example.christian.multipledeviceslab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Christian on 4/1/16.
 */
public class BonusRecyclerAdapter extends RecyclerView.Adapter<BonusRecyclerAdapter.BonusViewHolder> {

    private LinkedList<String> mItems;

    public BonusRecyclerAdapter() {
        mItems = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            mItems.add(String.valueOf(i));
        }
    }

    @Override
    public BonusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_bonus, parent, false);
        return new BonusViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(BonusViewHolder holder, int position) {
        holder.mText.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class BonusViewHolder extends RecyclerView.ViewHolder {
        TextView mText;

        public BonusViewHolder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.bonus_card_text);
        }
    }
}