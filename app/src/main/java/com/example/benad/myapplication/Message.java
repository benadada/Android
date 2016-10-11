package com.example.benad.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        List<MessageText> messages = new ArrayList<MessageText>();
        MessageText m1 = new MessageText("Leo :","Salut");
        MessageText m2 = new MessageText("Adam :","Salut");
        MessageText m3 = new MessageText("Leo :","ca va?");
        MessageText m4 = new MessageText("Adam :","Et toi");
        messages.add(m1);
        messages.add(m2);
        messages.add(m3);
        messages.add(m4);

        ListView list = (ListView) findViewById(R.id.listView);

        ItemAdapter adapter = new ItemAdapter(messages, this);
        list.setAdapter(adapter);

    }
}
