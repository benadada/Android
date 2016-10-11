package com.example.benad.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by benad on 11/10/2016.
 */
public class ItemAdapter extends BaseAdapter {
    List<MessageText> messages;

    Context context;
    LayoutInflater layoutInflater;

    public  ItemAdapter(List<MessageText> messages, Context context) {
        super();
        this.messages = messages;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override public int getCount() {
        return messages.size();
    }

    @Override public Object getItem(int position) {
        return messages.get(position);
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.element_message, null);
        TextView txt = (TextView) convertView.findViewById(R.id.message);
        TextView txt1 = (TextView) convertView.findViewById(R.id.login);
        txt1.setText(messages.get(position).getLogin());
        txt.setText(messages.get(position).getMessage());
        return convertView;
    }
}