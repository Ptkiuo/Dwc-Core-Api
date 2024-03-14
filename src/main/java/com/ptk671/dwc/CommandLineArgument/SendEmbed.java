package com.ptk671.dwc.CommandLineArgument;

import com.ptk671.dwc.core.WebhookUtils;
import com.ptk671.dwc.core.builder.EmbedBuilder;

public class SendEmbed {
    public static void main(String[] args) {
        int COLOR = Integer.parseInt(args[1]);
        WebhookUtils.sendEmbed(args[0], new EmbedBuilder()
                .setColor(COLOR)
                .setTitle(args[2])
                .setDescription(args[3])
                .setTimestamp(args[4])
        );
    }
}
