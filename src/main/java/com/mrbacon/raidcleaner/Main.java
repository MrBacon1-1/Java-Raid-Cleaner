package com.mrbacon.raidcleaner;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    public static void main(String[] args) {
        // Bot Builder

        // Your Bot Token Goes Below

        JDA bot = JDABuilder.createDefault("token")

                // Sets Bot Activity

                .setActivity(Activity.watching("MrBacon"))

                // Enabling Intents

                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_BANS)

                // Adding Listeners/Command

                // Building The Bot

                .build();

        // Adding The Slash Commands


        // This Gets Printed When The Bot Is Ready/Loaded

        System.out.println("-----------------------------------");
        System.out.println("[Bot] Bot has successfully started!");
        System.out.println("-----------------------------------");
    }
}