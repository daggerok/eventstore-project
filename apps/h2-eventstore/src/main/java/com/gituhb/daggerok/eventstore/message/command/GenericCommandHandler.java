package com.gituhb.daggerok.eventstore.message.command;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class GenericCommandHandler {

  @Subscribe(threadMode = ThreadMode.ASYNC)
  public <T> void on(GenericCommand<T> cmd) {
    T payload = cmd.getPayload();
  }
}
