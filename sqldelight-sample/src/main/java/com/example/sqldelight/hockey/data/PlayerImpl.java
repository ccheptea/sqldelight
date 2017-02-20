package com.example.sqldelight.hockey.data;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.EnumColumnAdapter;
import com.squareup.sqldelight.RowMapper;

import java.util.Calendar;

@AutoValue
public abstract class PlayerImpl implements PlayerModel {
    public enum Shoots {
        RIGHT, LEFT
    }

    public enum Position {
        LEFT_WING, RIGHT_WING, CENTER, DEFENSE, GOALIE
    }

    private static final DateAdapter DATE_ADAPTER = new DateAdapter();
    private static final EnumColumnAdapter<Shoots> SHOOTS_ADAPTER = EnumColumnAdapter.create(Shoots.class);
    private static final EnumColumnAdapter<Position> POSITION_ADAPTER = EnumColumnAdapter.create(Position.class);

    public static final Factory<PlayerImpl> FACTORY = new Factory<>(new Creator<PlayerImpl>() {
        @Override
        public PlayerImpl create(long id, String firstName, String lastName, int number, Long team, int age,
                                 float weight, Calendar birthDate, Shoots shoots, Position position) {
            return new AutoValue_PlayerImpl(id, firstName, lastName, number, team, age, weight, birthDate,
                shoots, position);
        }
    }, DATE_ADAPTER, SHOOTS_ADAPTER, POSITION_ADAPTER);

    public static final RowMapper<ForTeam> FOR_TEAM_MAPPER = FACTORY.for_teamMapper(new For_teamCreator<PlayerImpl, TeamImpl, ForTeam>() {
        @Override
        public ForTeam create(@NonNull PlayerImpl player, @NonNull TeamImpl team) {
            return new AutoValue_PlayerImpl_ForTeam(player, team);
        }
    }, TeamImpl.FACTORY);

    @AutoValue
    public static abstract class ForTeam implements For_teamModel<PlayerImpl, TeamImpl> {
    }
}
