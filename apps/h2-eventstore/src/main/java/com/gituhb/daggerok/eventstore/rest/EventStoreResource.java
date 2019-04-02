package com.gituhb.daggerok.eventstore.rest;

import com.gituhb.daggerok.eventstore.data.Event;
import com.gituhb.daggerok.eventstore.data.EventRepository;
import io.vavr.collection.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EventStoreResource {

  final EventRepository eventRepository;

  @PostMapping("/test/**")
  public Event post(@RequestBody Event event) {
    return eventRepository.save(Event.of(event.getMessage()));
  }

  @GetMapping("/test/**")
  public Collection<Event> get() {
    return eventRepository.findAll();
  }

  /*@RequestMapping("/**")
  public Map fallback() {
    return HashMap.of("id", UUID.randomUUID(),
                      "message", "to be continued...").toJavaMap();
  }*/
}
