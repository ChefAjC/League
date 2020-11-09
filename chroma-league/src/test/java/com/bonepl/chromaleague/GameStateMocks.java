package com.bonepl.chromaleague;

import com.bonepl.chromaleague.rest.activeplayer.ActivePlayer;
import com.bonepl.chromaleague.rest.activeplayer.ChampionStats;
import com.bonepl.chromaleague.rest.playerlist.Player;
import com.bonepl.chromaleague.rest.playerlist.PlayerList;
import com.bonepl.chromaleague.state.RunningState;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public final class GameStateMocks {
    private GameStateMocks() {
    }

    public static void setActivePlayerName(String name) {
        RunningState.setRunningGame(true);
        ActivePlayer mockedActivePlayer = mock(ActivePlayer.class);
        when(mockedActivePlayer.getSummonerName()).thenReturn(name);
        RunningState.getGameState().setActivePlayer(mockedActivePlayer);
    }

    public static void makePlayerListAvailable() {
        RunningState.setRunningGame(true);
        PlayerList playerList = mock(PlayerList.class);
        RunningState.getGameState().setPlayerList(playerList);
    }

    public static void mockActivePlayerAlive(boolean alive) {
        RunningState.setRunningGame(true);
        Player activePlayer = mock(Player.class);
        when(activePlayer.isDead()).thenReturn(!alive);
        PlayerList playerList = mock(PlayerList.class);
        when(playerList.getActivePlayer()).thenReturn(activePlayer);
        RunningState.getGameState().setPlayerList(playerList);
    }

    public static void mockActivePlayerGold(double gold) {
        RunningState.setRunningGame(true);
        final ChampionStats championStatsMock = mock(ChampionStats.class);
        final ActivePlayer apMock = mock(ActivePlayer.class);
        when(apMock.getChampionStats()).thenReturn(championStatsMock);
        when(apMock.getCurrentGold()).thenReturn(gold);
        RunningState.getGameState().setActivePlayer(apMock);
    }

    public static void clearActivePlayer() {
        RunningState.setRunningGame(true);
        RunningState.getGameState().setActivePlayer(null);
    }

    public static void clearPlayerList() {
        RunningState.setRunningGame(true);
        RunningState.getGameState().setPlayerList(null);
    }

    public static void mockPlayerNameAndIsAllyResponse(String playerName, boolean isAlly) {
        RunningState.setRunningGame(true);
        ActivePlayer activePlayer = mock(ActivePlayer.class);
        when(activePlayer.getSummonerName()).thenReturn(playerName);
        RunningState.getGameState().setActivePlayer(activePlayer);
        final PlayerList mock = mock(PlayerList.class);
        when(mock.isAlly(any())).thenReturn(isAlly);
        RunningState.getGameState().setPlayerList(mock);
    }

    public static void mockActivePlayerHealth(double currentHealth, double maxHealth) {
        RunningState.setRunningGame(true);
        final ChampionStats championStatsMock = mock(ChampionStats.class);
        when(championStatsMock.getCurrentHealth()).thenReturn(currentHealth);
        when(championStatsMock.getMaxHealth()).thenReturn(maxHealth);
        final ActivePlayer apMock = mock(ActivePlayer.class);
        when(apMock.getChampionStats()).thenReturn(championStatsMock);
        RunningState.getGameState().setActivePlayer(apMock);
    }

    public static void mockActivePlayerResource(double currentResource, double maxResource) {
        RunningState.setRunningGame(true);
        final ChampionStats championStatsMock = mock(ChampionStats.class);
        when(championStatsMock.getResourceValue()).thenReturn(currentResource);
        when(championStatsMock.getResourceMax()).thenReturn(maxResource);
        final ActivePlayer apMock = mock(ActivePlayer.class);
        when(apMock.getChampionStats()).thenReturn(championStatsMock);
        RunningState.getGameState().setActivePlayer(apMock);
    }

    public static void mockActivePlayerChampionName(String championName) {
        RunningState.setRunningGame(true);
        Player activePlayer = mock(Player.class);
        when(activePlayer.getChampionName()).thenReturn(championName);
        PlayerList playerList = mock(PlayerList.class);
        when(playerList.getActivePlayer()).thenReturn(activePlayer);
        RunningState.getGameState().setPlayerList(playerList);
    }

    public static ChampionStats mockChampionStats() {
        RunningState.setRunningGame(true);
        final ChampionStats championStatsMock = mock(ChampionStats.class);
        final ActivePlayer apMock = mock(ActivePlayer.class);
        when(apMock.getChampionStats()).thenReturn(championStatsMock);
        RunningState.getGameState().setActivePlayer(apMock);
        return championStatsMock;
    }

    public static ActivePlayer mockActivePlayer(String playerName) {
        RunningState.setRunningGame(true);
        final ChampionStats championStatsMock = mock(ChampionStats.class);
        final ActivePlayer apMock = mock(ActivePlayer.class);
        when(apMock.getSummonerName()).thenReturn(playerName);
        when(apMock.getChampionStats()).thenReturn(championStatsMock);
        RunningState.getGameState().setActivePlayer(apMock);
        return apMock;
    }

    public static PlayerList mockPlayerList() {
        RunningState.setRunningGame(true);
        final PlayerList playerListMock = mock(PlayerList.class);
        RunningState.getGameState().setPlayerList(playerListMock);
        return playerListMock;
    }

    public static void mockResource(double resource, double maxResource) {
        final ChampionStats mockedChampionStats = mockChampionStats();
        when(mockedChampionStats.getResourceValue()).thenReturn(resource);
        when(mockedChampionStats.getResourceMax()).thenReturn(maxResource);
    }
}
