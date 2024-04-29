package me.h12z.discord;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import me.h12z.Variables;

public class RPC {

    private long start;
    public DiscordRPC rpc = DiscordRPC.INSTANCE;
    private DiscordEventHandlers handlers;

    public void create() {

        handlers = new DiscordEventHandlers();

        handlers.ready = (user) -> System.out.println("Ready!");
        start = System.currentTimeMillis();

        rpc.Discord_Initialize("1211915607323447297", handlers, true, "");

    }

    public void update(String state, String details) {

        DiscordRichPresence richPresence = new DiscordRichPresence();
        richPresence.state = state;
        richPresence.details = details;
        richPresence.largeImageKey = "large";
        richPresence.startTimestamp = start;

        rpc.Discord_UpdatePresence(richPresence);

    }

}
