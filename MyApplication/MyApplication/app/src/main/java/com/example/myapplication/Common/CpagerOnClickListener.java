package com.example.myapplication.Common;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;

public class CpagerOnClickListener implements View.OnClickListener{

    Context mContext;
    public CpagerOnClickListener(Context mContext){
        this.mContext=mContext;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case 1:
                Toast.makeText(mContext, "图片1被点击", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(mContext, "图片2被点击", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(mContext, "图片3被点击", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(mContext, "图片4被点击", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(mContext, "图片5被点击", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
