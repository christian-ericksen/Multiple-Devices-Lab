package com.example.christian.multipledeviceslab;

/**
 * Created by Christian on 4/1/16.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;


public class CalendarRecyclerAdapter extends
        RecyclerView.Adapter<CalendarRecyclerAdapter.CalendarViewHolder> {

    private int mOrientation;
    private LinkedList<Date> mItems;

    public CalendarRecyclerAdapter(int orientation) {
        mOrientation = orientation;
        mItems = new LinkedList<>();
        Calendar calendar = Calendar.getInstance(); // current date
        for (int i = 0; i < 20; i++) { // add 20 dates starting w/ current date
            calendar.add(Calendar.DATE, 1);
            mItems.add(calendar.getTime());
        }
    }

    @Override
    public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.calendar_item, parent, false);
        return new CalendarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CalendarViewHolder holder, int position) {
        Locale locale = Locale.getDefault();
        DateFormat monthAbbrev = new SimpleDateFormat("MMM", locale);
        DateFormat dateNum = new SimpleDateFormat("d", locale);
        DateFormat dateName;
        if (mOrientation == LinearLayout.HORIZONTAL) {
            dateName = new SimpleDateFormat("EEE", locale);  // 3 letter abbreviation
        } else {
            dateName = new SimpleDateFormat("EEEE", locale); // full weekday name
        }

        Date date = mItems.get(position);

        holder.mMonthAbbrev.setText(monthAbbrev.format(date));
        holder.mDayNum.setText(dateNum.format(date));
        holder.mDayName.setText(dateName.format(date));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView mMonthAbbrev, mDayNum, mDayName;

        public CalendarViewHolder(View itemView) {
            super(itemView);
            mMonthAbbrev = (TextView) itemView.findViewById(R.id.month_abbrev);
            mDayNum = (TextView) itemView.findViewById(R.id.day_number);
            mDayName = (TextView) itemView.findViewById(R.id.day_name);
        }
    }
}