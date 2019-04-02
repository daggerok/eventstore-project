package com.gituhb.daggerok.eventstore.message.command;

import org.springframework.stereotype.Component;

@Component
public class Commander {
  public static <T> GenericCommand<T> send(T cmd) {
    return new GenericCommandInternalImpl<>(cmd);
  }
}
