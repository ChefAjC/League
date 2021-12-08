package com.bonepl.chromaleague.tasks;

import com.bonepl.chromaleague.rest.NewLeagueHttpClient;
import com.bonepl.chromaleague.rest.PlayerListResponseHandler;
import com.bonepl.chromaleague.state.RunningState;

import java.util.logging.Logger;

public class FetchPlayerListTask implements Runnable {
    public static final String URL = "https://127.0.0.1:2999/liveclientdata/playerlist";
    private static final Logger LOGGER = Logger.getLogger(FetchPlayerListTask.class.getName());
    private final PlayerListResponseHandler playerListResponseHandler = new PlayerListResponseHandler();

    @Override
    public void run() {
        NewLeagueHttpClient.getResponse(URL, playerListResponseHandler)
                .ifPresent(playerList -> RunningState.getGameState().setPlayerList(playerList));
    }
}
