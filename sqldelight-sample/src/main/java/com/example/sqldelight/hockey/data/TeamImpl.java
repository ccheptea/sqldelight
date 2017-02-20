package com.example.sqldelight.hockey.data;

import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.RowMapper;

import java.util.Calendar;

@AutoValue
public abstract class TeamImpl implements TeamModel {
    private static final DateAdapter DATE_ADAPTER = new DateAdapter();

    public static final Factory<TeamImpl> FACTORY = new Factory<>(new Creator<TeamImpl>() {
        @Override
        public TeamImpl create(long Id, String name, Calendar founded, String coach, Long captain,
                                boolean wonCup) {
            return new AutoValue_TeamImpl(Id, name, founded, coach, captain, wonCup);
        }
    }, DATE_ADAPTER);

    public static final RowMapper<TeamImpl> MAPPER = FACTORY.select_allMapper();
}
