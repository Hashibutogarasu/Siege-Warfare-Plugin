package com.hashibutogarasu.siege_warfare_plugin.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;

public class setteam {

    /**
     * Players list in the server {@linkplain
     * teamnext#run(CommandSender, Command, String, String[])}
     */
    @NotNull
    public static Collection<? extends Player> players;

    /**
     * args[0]:Selection mode random:Random selection,custom:Custom selection
     *
     * @param sender
     * @param cmd
     * @param commandLabel
     * @param args
     * @return
     */
    public static boolean run(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(args.length != 0 && sender.isOp()){
            String mode = args[0];
            if(mode.matches("random")){
                sender.sendMessage("ランダムでチームを設定します");

                return true;
            }

            if(mode.matches("custom")){
                players = sender.getServer().getOnlinePlayers();
                sender.sendMessage("カスタムでチームを設定します");
                sender.sendMessage("プレイヤー数：" + players.size());

                teamnext.count = 0;

                teamnext.run(sender, cmd, commandLabel, args);

                return true;
            }
        }

        return false;
    }
}
