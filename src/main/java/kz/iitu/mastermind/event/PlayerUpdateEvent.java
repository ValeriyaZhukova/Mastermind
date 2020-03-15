package kz.iitu.mastermind.event;

import kz.iitu.mastermind.models.Player;
import org.springframework.context.ApplicationEvent;

public class PlayerUpdateEvent extends ApplicationEvent {

    private Player player;

    public PlayerUpdateEvent(Object source)
    {
        super(source);
        this.player = player;
    }

    public Player getPlayer()
    {
        return player;
    }
}
