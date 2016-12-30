package com.yeti.vipertest.Interactor;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PictureInteractor extends AsyncTask<String, Integer, String> {
    private OkHttpClient client = new OkHttpClient();
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json");

    private String run(String url, String method) throws IOException {
        Request request;
        Request.Builder requestBuilder = new Request.Builder().url(url);

        // No breaks, using fall through casing so that each case is executed
        switch (method) {
            case "POST":
                requestBuilder.post(RequestBody.create(MEDIA_TYPE_JSON, "{}"));
            case "GET":
            default:
                request = requestBuilder.build();
                break;
        }

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    protected String doInBackground(String... params) {  // Takes any number of strings in an array
        PictureInteractor example = new PictureInteractor();
        String response;

        try {
            response = example.run("http://10.0.0.202:8000/pictures", params[0]);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
            response = "error";
        }

        return response;
    }
}