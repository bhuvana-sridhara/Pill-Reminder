package com.example.pill_tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<String> {

    String name[];
    String purpose[];
    String Dosage[];
    String numberOfPills[];
//    String timeOfDay[];
    String time[];
    //    int [] image;
    Context context;

    public MyAdapter(Context context, String[] name, String purpose[], String Dosage[], String numberOfPills[], String time[]){
        super(context, R.layout.row);
        this.name = name;
        this.purpose = purpose;
        this.Dosage = Dosage;
        this.numberOfPills = numberOfPills;
//        this.timeOfDay = timeOfDay;
        this.time = time;
        this.context = context;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView==null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row, parent, false);
//            mViewHolder.mImage = (ImageView) convertView.findViewById(R.id.icon);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.name);
            mViewHolder.mPurpose = (TextView) convertView.findViewById(R.id.purpose);
            mViewHolder.mDosage = (TextView) convertView.findViewById(R.id.dosage);
            mViewHolder.mPills = (TextView) convertView.findViewById(R.id.nop);
//            mViewHolder.mDay = (TextView) convertView.findViewById(R.id.tod);
            mViewHolder.mTime = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(mViewHolder);
        }else{
            mViewHolder= (ViewHolder)convertView.getTag();
        }
//        mViewHolder.mImage.setImageResource(image[position]);
        mViewHolder.mName.setText(name[position]);
        mViewHolder.mPurpose.setText("Purpose: "+purpose[position]);
        mViewHolder.mDosage.setText("Dosage: "+Dosage[position]);
        mViewHolder.mPills.setText("Number of Pills:"+numberOfPills[position]);
//        mViewHolder.mDay.setText("Time of Day:" +timeOfDay[position]);
        mViewHolder.mTime.setText("Time: "+time[position]);

        return convertView;
    }
    static class ViewHolder{
        //        ImageView mImage;
        TextView mName;
        TextView mPurpose;
        TextView mDosage;
        TextView mPills;
        TextView mDay;
        TextView mTime;
    }
}

