package com.bonepl.chromaleague.rest.eventdata;

import com.bonepl.chromaleague.GameStateMocks;
import com.bonepl.chromaleague.rest.playerlist.PlayerList;
import com.bonepl.chromaleague.state.RunningState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EventTypeTest {
    private static final String ACTIVE_PLAYER_NAME = "BooonE";

    @BeforeEach
    void setUp() {
        GameStateMocks.mockPlayerNameAndIsAllyResponse(ACTIVE_PLAYER_NAME, true);
    }

    @AfterEach
    void tearDown() {
        RunningState.setRunningGame(false);
    }

    @Test
    void testActivePLayerKill() {
        //given
        final Event event = mockActivePlayerKillEvent();

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ACTIVE_PLAYER_KILL, eventType);
    }

    private static Event mockActivePlayerKillEvent() {
        final Event mock = mock(Event.class);
        when(mock.getEventName()).thenReturn("ChampionKill");
        when(mock.getKillerName()).thenReturn(ACTIVE_PLAYER_NAME);
        return mock;
    }

    @Test
    void testActivePLayerAssist() {
        //given
        final Event event = mockActivePlayerAssistEvent();

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ACTIVE_PLAYER_ASSIST, eventType);
    }

    private static Event mockActivePlayerAssistEvent() {
        final Event mock = mock(Event.class);
        when(mock.getEventName()).thenReturn("ChampionKill");
        when(mock.getKillerName()).thenReturn("My Teammate");
        when(mock.getAssisters()).thenReturn(List.of(ACTIVE_PLAYER_NAME));
        return mock;
    }

    @Test
    void testAllyOceanDragonAnimation() {
        //given
        final Event event = mockDragonEvent(DragonType.OCEAN);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ALLY_OCEAN_DRAGON_KILL, eventType);
    }

    @Test
    void testAllyInfernalDragonAnimation() {
        //given
        final Event event = mockDragonEvent(DragonType.INFERNAL);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ALLY_INFERNAL_DRAGON_KILL, eventType);
    }

    @Test
    void testAllyCloudDragonAnimation() {
        //given
        final Event event = mockDragonEvent(DragonType.CLOUD);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ALLY_CLOUD_DRAGON_KILL, eventType);
    }

    @Test
    void testAllyMountainDragonAnimation() {
        //given
        final Event event = mockDragonEvent(DragonType.MOUNTAIN);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ALLY_MOUNTAIN_DRAGON_KILL, eventType);
    }

    @Test
    void testAllyElderDragonAnimation() {
        //given
        final Event event = mockDragonEvent(DragonType.ELDER);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ALLY_ELDER_DRAGON_KILL, eventType);
    }

    @Test
    void testEnemyOceanDragonAnimation() {
        //given
        GameStateMocks.mockPlayerNameAndIsAllyResponse(ACTIVE_PLAYER_NAME, false);
        final Event event = mockDragonEvent(DragonType.OCEAN);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ENEMY_OCEAN_DRAGON_KILL, eventType);
    }

    @Test
    void testEnemyInfernalDragonAnimation() {
        //given
        GameStateMocks.mockPlayerNameAndIsAllyResponse(ACTIVE_PLAYER_NAME, false);
        final Event event = mockDragonEvent(DragonType.INFERNAL);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ENEMY_INFERNAL_DRAGON_KILL, eventType);
    }

    @Test
    void testEnemyCloudDragonAnimation() {
        //given
        GameStateMocks.mockPlayerNameAndIsAllyResponse(ACTIVE_PLAYER_NAME, false);
        final Event event = mockDragonEvent(DragonType.CLOUD);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ENEMY_CLOUD_DRAGON_KILL, eventType);
    }

    @Test
    void testEnemyMountainDragonAnimation() {
        //given
        GameStateMocks.mockPlayerNameAndIsAllyResponse(ACTIVE_PLAYER_NAME, false);
        final Event event = mockDragonEvent(DragonType.MOUNTAIN);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ENEMY_MOUNTAIN_DRAGON_KILL, eventType);
    }

    @Test
    void testEnemyElderDragonAnimation() {
        //given
        GameStateMocks.mockPlayerNameAndIsAllyResponse(ACTIVE_PLAYER_NAME, false);
        final Event event = mockDragonEvent(DragonType.ELDER);

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ENEMY_ELDER_DRAGON_KILL, eventType);
    }

    private static Event mockDragonEvent(DragonType dragonType) {
        final Event mock = mock(Event.class);
        when(mock.getEventName()).thenReturn("DragonKill");
        when(mock.getDragonType()).thenReturn(dragonType.getApiType());
        return mock;
    }

    @Test
    void testAllyHeraldAnimation() {
        //given
        final Event event = mockHeraldEvent();

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ALLY_HERALD_KILL, eventType);
    }

    @Test
    void testEnemyHeraldAnimation() {
        //given
        GameStateMocks.mockPlayerNameAndIsAllyResponse(ACTIVE_PLAYER_NAME, false);
        final Event event = mockHeraldEvent();

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ENEMY_HERALD_KILL, eventType);
    }

    @Test
    void testAllyBaronAnimation() {
        //given
        final Event event = mockBaronEvent();

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ALLY_BARON_KILL, eventType);
    }

    @Test
    void testEnemyBaronAnimation() {
        //given
        GameStateMocks.mockPlayerNameAndIsAllyResponse(ACTIVE_PLAYER_NAME, false);
        final Event event = mockBaronEvent();

        //when
        final EventType eventType = EventType.fromEvent(event);

        //then
        assertEquals(EventType.ENEMY_BARON_KILL, eventType);
    }

    private static Event mockHeraldEvent() {
        final Event mock = mock(Event.class);
        when(mock.getEventName()).thenReturn("HeraldKill");
        return mock;
    }

    private static Event mockBaronEvent() {
        final Event mock = mock(Event.class);
        when(mock.getEventName()).thenReturn("BaronKill");
        return mock;
    }

    private static void mockIsAllyResponse(boolean isAlly) {
        RunningState.setRunningGame(true);
        final PlayerList mock = mock(PlayerList.class);
        when(mock.isAlly(any())).thenReturn(isAlly);
        RunningState.getGameState().setPlayerList(mock);
    }
}