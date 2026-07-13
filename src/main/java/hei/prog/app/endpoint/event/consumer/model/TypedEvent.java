package hei.prog.app.endpoint.event.consumer.model;

import hei.prog.app.PojaGenerated;
import hei.prog.app.endpoint.event.model.PojaEvent;

@PojaGenerated
public record TypedEvent(String typeName, PojaEvent payload) {}
