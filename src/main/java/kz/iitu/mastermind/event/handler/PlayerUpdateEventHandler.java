package kz.iitu.mastermind.event.handler;

import kz.iitu.mastermind.event.PlayerUpdateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PlayerUpdateEventHandler implements ApplicationListener<PlayerUpdateEvent> {

    @Override
    public void onApplicationEvent(PlayerUpdateEvent playerUpdateEvent)
    {
        System.out.println("UserUpdateHandler.onApplicationEvent");
        System.out.println("Updated player info: " + playerUpdateEvent.getPlayer().getWon());
        System.out.println("Updated player info: " + playerUpdateEvent.getPlayer().getLost());
    }
}
