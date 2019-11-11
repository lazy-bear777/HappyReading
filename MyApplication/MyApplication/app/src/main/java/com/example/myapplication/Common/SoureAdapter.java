package com.example.myapplication.Common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Spider.Bean;

import java.util.List;

public class SoureAdapter extends ArrayAdapter<Bean> {
    private int resourceId;
    public  SoureAdapter(Context context, int textViewResourceId, List<Bean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Bean soure =getItem(position);//获取当前Soure实例
        View view;
        ViewHolder viewHolder;
        if(convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder =new ViewHolder();
            viewHolder.soureName=(TextView) view.findViewById(R.id.soure_name);

            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.soureName.setText(soure.getName());
        return view;
    }
    class ViewHolder {
        TextView soureName;

    }
}