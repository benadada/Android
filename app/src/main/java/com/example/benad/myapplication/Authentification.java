package com.example.benad.myapplication;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by benad on 11/10/2016.
 */
public class Authentification extends AsyncTask<String, Void, Boolean> {

    private LoginListener loginListener;

    public LoginListener getLoginListener(){
        return loginListener;
    }

    public void setLoginListener(LoginListener loginListener){
        this.loginListener = loginListener;
    }
    protected Boolean doInBackground(String... params) {

        URL url = null;
        try {
            url = new URL("https://training.loicortola.com/chat-rest/1.0/connect/" + params[0] + "/" + params[1]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String result = InputStreamOperations.InputStreamToString(in);
            JSONObject jsonObject = new JSONObject(result);
            String r = jsonObject.getString("message");
            if (r.equals("Login successful")) {
                urlConnection.disconnect();
                return true;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }

        return false;
    }
    protected void onPostExecute (Boolean result){
        loginListener.onLogin(result);
    }

    public interface LoginListener {
        void onLogin(boolean result);
    }

}
