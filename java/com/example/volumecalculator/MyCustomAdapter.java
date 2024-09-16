package com.example.volumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private Context context;
    private ArrayList<Shape> shapeList;


    public MyCustomAdapter(Context context, ArrayList<Shape> shapeList) {
        super(context, R.layout.gridview_item_layout,shapeList);
        this.context = context;
        this.shapeList = shapeList;
    }

    private static class ViewHolder
    {
        ImageView imgView;
        TextView textView;
    }

    //used to create and return a view for a specific item in grid
    //verify that if a recycled view that went off the screen is available (if it isn't you inflate a new layout and create a ViewHolder)
    //if it's available, just update the data in the existing viewHolder and reuse it
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        final View result;
        Shape shape=getItem(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.gridview_item_layout,parent,false);

            holder=new ViewHolder();
            holder.imgView=convertView.findViewById(R.id.image);
            holder.textView=convertView.findViewById(R.id.shapeName);
            convertView.setTag(holder);
        }
        else {
            holder= (ViewHolder) convertView.getTag();
        }
        result=convertView;
        holder.imgView.setImageResource(shape.getShapeImg());
        holder.textView.setText(shape.getShapeName());
        return result;
    }
}
