package staytis.staytisbungee;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.Favicon;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;
import staytis.staytisbungee.command.MessageCommand;
import staytis.staytisbungee.command.ReplyCommand;
import staytis.staytisbungee.listener.MessageListener;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public final class staytisBungee extends Plugin {

    private HashMap<UUID, UUID> recentMessages;

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new ReplyCommand(this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new MessageCommand(this));
        ProxyServer.getInstance().getPluginManager().registerListener(this, new MessageListener(this));
        recentMessages=new HashMap<>();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public HashMap<UUID, UUID> getRecentMessages() {
        return recentMessages;
    }
}
