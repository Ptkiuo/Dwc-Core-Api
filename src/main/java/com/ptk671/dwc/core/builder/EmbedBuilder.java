package com.ptk671.dwc.core.builder;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.jetbrains.annotations.Nullable;

public class EmbedBuilder {
    @Nullable private String title;
    @Nullable private String type;
    @Nullable private String description;
    @Nullable private String url;
    @Nullable private String timestamp;
    @Nullable private Integer color;

    public EmbedBuilder() {
        this.title = null;
        this.type = null;
        this.description = null;
        this.url = null;
        this.timestamp = null;
        this.color = null;
    }

    public EmbedBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public EmbedBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public EmbedBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public EmbedBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public EmbedBuilder setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public EmbedBuilder setColor(Integer color) {
        this.color = color;
        return this;
    }

    public JsonObject build() {
        JsonObject json = new JsonObject();

        if(this.title != null) {
            json.add("title", new JsonPrimitive(this.title));
        }

        if(this.type != null) {
            json.add("type", new JsonPrimitive(this.type));
        }

        if(this.description != null) {
            json.add("description", new JsonPrimitive(this.description));
        }

        if(this.url != null) {
            json.add("url", new JsonPrimitive(this.url));
        }

        if(this.timestamp != null) {
            json.add("timestamp", new JsonPrimitive(this.timestamp));
        }

        if(this.color != null) {
            json.add("color", new JsonPrimitive(this.color));
        }

        return json;
    }
}
