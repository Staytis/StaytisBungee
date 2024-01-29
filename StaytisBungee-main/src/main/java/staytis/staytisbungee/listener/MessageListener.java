package staytis.staytisbungee.listener;

import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import staytis.staytisbungee.staytisBungee;

public class MessageListener implements Listener {


    private staytisBungee staytisBungee;

    public MessageListener(staytisBungee staytisBungee)
    {
        this.staytisBungee=staytisBungee;

    }


    @EventHandler
    public void onQuit(PlayerDisconnectEvent e)
    {
        if(staytisBungee.getRecentMessages().containsKey(e.getPlayer().getUniqueId())) staytisBungee.getRecentMessages().remove(e.getPlayer().getUniqueId());
    }


}
