package me.h12z.discord;

public class RPCCache {

    private final String details;
    private final String state;
    private final String smallKey;
    private final String smallText;

    public RPCCache(String details,String state, String smallKey, String smallText) {

        this.details = details;
        this.state = state;
        this.smallKey = smallKey;
        this.smallText = smallText;

    }

    public String getDetails() {
        return details;
    }

    public String getState() {
        return state;
    }

    public String getSmallKey() {
        return smallKey;
    }

    public String getSmallText() {
        return smallText;
    }
}
