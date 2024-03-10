package com.ptk671.dwc.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ptk671.dwc.core.builder.EmbedBuilder;
import okhttp3.*;

import java.io.IOException;

public class WebhookUtils {
    private static final OkHttpClient client = new OkHttpClient();

    public static boolean sendEmbed(String url, EmbedBuilder builder) {
        JsonObject json = new JsonObject();
        JsonArray array = new JsonArray();

        array.add(builder.build());

        json.add("embeds", array);

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(json.toString(), MediaType.get("application/json")))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return false;
            }

            System.out.println("ok");

        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    public static boolean sendContent(String url, String message) {
        JsonObject json = new JsonObject();

        json.add("content", new JsonPrimitive(message));

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(json.toString(), MediaType.get("application/json")))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }
}
