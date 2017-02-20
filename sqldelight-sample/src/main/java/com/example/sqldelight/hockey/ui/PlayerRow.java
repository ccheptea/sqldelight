package com.example.sqldelight.hockey.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sqldelight.hockey.R;
import com.example.sqldelight.hockey.data.PlayerImpl;
import com.example.sqldelight.hockey.data.TeamImpl;

public final class PlayerRow extends LinearLayout {
  @BindView(R.id.player_name) TextView playerName;
  @BindView(R.id.team_name) TextView teamName;
  @BindView(R.id.player_number) TextView playerNumber;

  public PlayerRow(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }

  public void populate(PlayerImpl player, TeamImpl teamImpl) {
    playerName.setText(player.first_name() + " " + player.last_name());
    playerNumber.setText(String.valueOf(player.number()));
    teamName.setText(teamImpl.name());
  }
}
