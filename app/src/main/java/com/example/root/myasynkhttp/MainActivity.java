package com.example.root.myasynkhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv1;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView1);
        bt1 = findViewById(R.id.button1);

        tv1.setOnClickListener(this);
        bt1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textView1:
                Log.i("mainx", " Textview1 clicked:");
                break;
            case R.id.button1:
                Log.i("mainx", " Button1 clicked:");
                String myUrlString = "https://geek-jokes.sameerkumar.website/api";
                URL myURL = null;
                try{
                    myURL = new URL(myUrlString);
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }

                new Downloader(MainActivity.this).execute(myURL);
                break;
        }
    }
}
