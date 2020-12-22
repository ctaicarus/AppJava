package com.example.c_note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.customview.widget.ViewDragHelper;

import java.util.List;

public class CongViecAdapter extends BaseAdapter {
    private MainActivity  context;
    private int layout;
    private List<CongViec> congViecList;

    public CongViecAdapter(MainActivity context ,int layout , List<CongViec> congViecList) {
        this.context = context;
        this.layout = layout;
        this.congViecList = congViecList;
    }

    @Override
    public int getCount() {
        return congViecList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView txtTen;
        ImageView imgDalete , imgEdit, imgwu;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout , null);
            holder.txtTen = view.findViewById(R.id.namework);
            holder.imgDalete = view.findViewById(R.id.delete);
            holder.imgEdit = view.findViewById(R.id.edit);
            holder.imgwu = view.findViewById(R.id.imageWu);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final CongViec congViec = congViecList.get(i);
        holder.txtTen.setText(congViec.getTenCV());
        // bắt sự kiện
        holder.imgwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dat gio
                context.DialogWakeUp();
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context , "sửa : " + congViec.getTenCV(), Toast.LENGTH_SHORT).show();
                context.DialogSuaCongViec(congViec.getTenCV() , congViec.getIdCV());
            }
        });
        holder.imgDalete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogXoaCV(congViec.getTenCV() , congViec.getIdCV());
            }
        });
        return view;
    }
}
