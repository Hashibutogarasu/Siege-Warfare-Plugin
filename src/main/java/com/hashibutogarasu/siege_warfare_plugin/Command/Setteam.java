package com.hashibutogarasu.siege_warfare_plugin.Command;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class Setteam {
    public static boolean run(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if (sender.isOp()) {
            Server server = sender.getServer();
            Collection<? extends Player> players = server.getOnlinePlayers();

            if(args.length != 0){
                String mode = args[0];
                if(mode.equalsIgnoreCase("random")) {
                    sender.sendMessage("ランダムでチームを指定しています...");

                    return true;
                }
                if(mode.equalsIgnoreCase("custom")) {
                    sender.sendMessage("カスタムでチームを指定します");
                    sender.sendMessage("プレイヤー数：" + players.size());

                    return true;
                }
            }

        } else {
            sender.sendMessage("OPではないな あんた？？");
        }

        return false;
    }
}