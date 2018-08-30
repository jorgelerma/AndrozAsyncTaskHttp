package com.example.root.myasynkhttp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Downloader extends AsyncTask<URL, Integer, Long> {

    OkHttpClient client = new OkHttpClient();
    String myResponse;
    MainActivity mainActivity;

    Downloader(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    protected Long doInBackground(URL... urls) {

//        String myUrl = "https://geek-jokes.sameerkumar.website/api";
//        URL urlx = null;

        Log.i("mainx", " @doInBackground: ");

        String myUrls =  urls[0].toString();
        try{
            myResponse = post(myUrls);

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);

        this.mainActivity.tv1.setText(myResponse);


    }

    String post(String url) throws IOException{
//        String post(String url, String json) throws IOException{


//        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        String myResponse = response.body().string();
        Log.i("mainx", " The RESPONSE: " + myResponse);
        return myResponse;

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
