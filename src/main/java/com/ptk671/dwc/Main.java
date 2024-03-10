package com.ptk671.dwc;

import com.ptk671.dwc.core.WebhookUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input a webhook url");
        String url = scanner.nextLine();

        System.out.println("input a message");
        String message = scanner.nextLine();

        if(!url.contains("https://discord.com/api/webhooks/")) {
            System.out.println("invalid url");
            return;
        }

        if(WebhookUtils.sendContent(url, message)) {
            System.out.println("success");
        }
    }
}