package com.mrbacon.raidcleaner.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;

public class ChannelCleanCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("cleanchannels")) {


            while (true) {

                int delaySeconds = 1;

                try {
                    Thread.sleep(delaySeconds * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                String channelName = event.getOption("channelname").getAsString();

                List<TextChannel> channels = event.getGuild().getTextChannelsByName(channelName, true);

                if (channels.isEmpty()) {
                    break;

                } else {
                    for (TextChannel channel : channels) {
                        channel.delete().queue();
                    }
                    System.out.println("Deleted " + channels.size() + " channels with name " + channelName + ".");
                    event.getJDA().shutdown();
                }
            }
        }
    }
}
