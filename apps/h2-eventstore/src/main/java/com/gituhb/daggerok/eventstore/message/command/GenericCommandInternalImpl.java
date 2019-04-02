package com.gituhb.daggerok.eventstore.message.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
class GenericCommandInternalImpl<T> implements GenericCommand<T> {

  final T payload;

  @Override
  public T getPayload() {
    return payload;
  }
}
