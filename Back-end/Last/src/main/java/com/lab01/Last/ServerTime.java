package com.lab01.Last;

import java.time.LocalTime;

public class ServerTime {

    String serverTime;

    public ServerTime() {
        
        this.serverTime = "" + LocalTime.now();
        this.serverTime = serverTime.substring(0, serverTime.length()-4);
    }

    /**
     * @return the serverTime
     */
    public String getServerTime() {
        return serverTime;
    }
}
