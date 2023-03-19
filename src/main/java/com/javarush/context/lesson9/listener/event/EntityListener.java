package com.javarush.context.lesson9.listener.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EntityListener {

    @EventListener(condition = "#p0.accessType.name() == 'READ'")
    public void acceptEntity(EntityEvent entityEvent) {
        log.info("Entity event: {}", entityEvent);
    }

    @EventListener(condition = "#p0.accessType.name() == 'DELETE'")
    public void acceptDeleteEntity(EntityEvent entityEvent) {
        log.info("Delete entity event: {}", entityEvent);
    }
}