package com.mrbacon.raidcleaner;

import com.mrbacon.raidcleaner.commands.ChannelCleanCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    public static void main(String[] args) {
        // Bot Builder

        // Your Bot Token Goes Below

        JDA bot = JDABuilder.createDefault("token")

                // Sets Bot Activity

                .setActivity(Activity.watching("MrBacon#7458"))

                // Enabling Intents

                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_BANS)

                // Adding Listeners/Command

                .addEventListeners(new ChannelCleanCommand())

                // Building The Bot

                .build();

        // Adding The Slash Commands

        bot.upsertCommand("cleanchannels", "Deleted all the channels with a specific name. ( Bot will shutdown after it is done! )").addOptions(
                new OptionData(OptionType.STRING, "channelname", "Channel name you want to remove.")
        ).setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.ADMINISTRATOR)).queue();


        // This Gets Printed When The Bot Is Ready/Loaded

        System.out.println("-----------------------------------");
        System.out.println("[Bot] Bot has successfully started!");
        System.out.println("-----------------------------------");
    }
}