package me.h12z.discord;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import me.h12z.Variables;

public class RPC {

    private long start;
    public DiscordRPC rpc = DiscordRPC.INSTANCE;
    private DiscordEventHandlers handlers;
    private boolean initialized = false;

    public void init() {

        handlers = new DiscordEventHandlers();

        handlers.ready = (user) -> System.out.println("Ready!");
        start = System.currentTimeMillis();

        rpc.Discord_Initialize("application_id", handlers, true, "");

        initialized = true;

    }

    public static void update(String state, String details, String s, String ss) {

        if(!initialized)
            init()

        DiscordRichPresence richPresence = new DiscordRichPresence();
        richPresence.state = state;
        richPresence.details = details;
        richPresence.largeImageKey = "large";
        richPresence.startTimestamp = start;

        rpc.Discord_UpdatePresence(richPresence);

    }

}
