package me.h12z.discord;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import me.h12z.Variables;

public class RPC {

    public long start;
    public DiscordRPC rpc = DiscordRPC.INSTANCE;
    private DiscordEventHandlers handlers;
    public boolean initialized = false;

    public void init() {

        handlers = new DiscordEventHandlers();

        handlers.ready = (user) -> System.out.println("Ready!");
        start = System.currentTimeMillis();

        rpc.Discord_Initialize("application_id", handlers, true, "");

        initialized = true;

    }

    public static RPC instance() {

        return new RPC();
        
    }

    public static void update(String state, String details, String s, String ss) {

        RPC rpc1 = new RPC();
        
        if(!rpc1.initialized)
            rpc1.init();

        DiscordRichPresence richPresence = new DiscordRichPresence();
        richPresence.state = state;
        richPresence.details = details;
        richPresence.largeImageKey = "large";
        richPresence.startTimestamp = rpc1.start;

        rpc1.rpc.Discord_UpdatePresence(richPresence);

    }

}
