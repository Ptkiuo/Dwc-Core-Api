package com.ptk671.dwc.CommandLineArgument;

import com.ptk671.dwc.core.WebhookUtils;

public class SendContent {
    public static void main(String[] args) {
            WebhookUtils.sendContent(args[0], args[1]);
    }
}