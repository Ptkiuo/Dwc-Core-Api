package com.ptk671.dwc.core.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WebhookBuilder {
    @Nullable private String content;
    @Nullable private String username;
    @Nullable private String avatarUrl;
    @Nullable private Boolean tts;
    @Nullable private JsonArray embeds;
    @Nullable private JsonObject component;
    @Nullable private Integer flags;

    public WebhookBuilder() {
        this.content = "";
        this.username = null;
        this.avatarUrl = null;
        this.tts = null;
        this.embeds = null;
        this.component = null;
        this.flags = null;
    }

    public WebhookBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public WebhookBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public WebhookBuilder setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public WebhookBuilder setTTS(Boolean tts) {
        this.tts = tts;
        return this;
    }

    public WebhookBuilder addEmbed(EmbedBuilder embed) {
        if(this.embeds == null) {
            this.embeds = new JsonArray();
        }

        this.embeds.add(embed.build());
        return this;
    }

    public WebhookBuilder addEmbeds(List<EmbedBuilder> embeds) {
        if(this.embeds == null) {
            this.embeds = new JsonArray();
        }

        for(EmbedBuilder embed : embeds) {
            this.embeds.add(embed.build());
        }

        return this;
    }

    /*public WebhookBuilder setComponent(ComponentBuilder component) {
        this.component = component.build();
        return this;
    }*/

    public WebhookBuilder setFlags(int flags) {
        this.flags = flags;
        return this;
    }

    public JsonObject build() {
        if(this.isMultiContent()) {
            throw new IllegalStateException("Cannot have both content and embeds or components");
        }

        if(this.content == null && this.embeds == null && this.component == null) {
            throw new IllegalStateException("Cannot have empty content, embeds, or components");
        }

        JsonObject json = new JsonObject();

        if(this.content != null) {
            json.add("content", new JsonPrimitive(this.content));
        }

        if(this.username != null) {
            json.add("username", new JsonPrimitive(this.username));
        }

        if(this.avatarUrl != null) {
            json.add("avatar_url", new JsonPrimitive(this.avatarUrl));
        }

        if(this.tts != null) {
            json.add("tts", new JsonPrimitive(this.tts));
        }

        if(this.embeds != null) {
            json.add("embeds", this.embeds);
        }

        if(this.component != null) {
            json.add("components", this.component);
        }

        if(this.flags != null) {
            json.add("flags", new JsonPrimitive(this.flags));
        }

        return json;
    }

    private boolean isMultiContent() {
        if(this.content != null) {
            return this.embeds != null || this.component != null;
        }

        return this.embeds != null && this.component != null;
    }
}
