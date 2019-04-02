package com.gituhb.daggerok.eventstore.message;

public interface GenericMessage {
  <T> T getPayload();
}
