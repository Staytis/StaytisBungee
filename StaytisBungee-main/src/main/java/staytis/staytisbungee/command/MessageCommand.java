package staytis.bungee.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import staytis.staytisbungee.staytisBungee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageCommand extends Command implements TabExecutor {

    private StaytisBungee staytisBungee;

    public MessageCommand(staytisBungee staytisBungee)
    {
        super("message");
        this.staytisBungee=staytisBungee;
    }


    @Override
    public void execute(CommandSender sender, String[] args) {


        if(sender instanceof ProxiedPlayer)
        {
            ProxiedPlayer player = (ProxiedPlayer) sender;



            if(args.length>=2)
            {
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
                if(target!=null)
                {
                    StringBuilder sb = new StringBuilder();
                    for(int i = 1; i<args.length; i++)
                    {
                        sb.append(args[i]+" ");
                    }

                    player.sendMessage(ChatColor.DARK_GRAY+"["+ChatColor.YELLOW+"Você -> " + target.getName() +": " + sb+ChatColor.DARK_GRAY+"]");
                    target.sendMessage(ChatColor.DARK_GRAY+"["+ChatColor.YELLOW+ player.getName()+ " -> Você: " + sb+ChatColor.DARK_GRAY+"]");

                    staytisBungee.getRecentMessages().put(player.getUniqueId(), target.getUniqueId());
                }
                else{
                    player.sendMessage(ChatColor.RED+"O jogador não encontrado!");
                }



            }
            else {
                player.sendMessage(ChatColor.RED+"Uso inválido! Utilize /message <player> <mensagem>");
            }

        }


    }


    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {

        List<String> results = new ArrayList<>();
        if(args.length==1)
        {
            ProxyServer.getInstance().getPlayers().forEach(p -> results.add(p.getName()));
            return results.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).collect(Collectors.toList());
        }
        return results;




    }
}
