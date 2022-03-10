package com.hashibutogarasu.siege_warfare_plugin.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class setteam {
    public static boolean run(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(args.length != 0){
            String mode = args[0];
            if(mode.matches("random")){
                sender.sendMessage("ランダムでチームを設定します");

                return true;
            }

            if(mode.matches("custom")){
                Collection<? extends Player> players = sender.getServer().getOnlinePlayers();
                sender.sendMessage("カスタムでチームを設定します");
                sender.sendMessage("プレイヤー数：" + players.size());

                if(players.size() != 0){

                }

                return true;
            }
        }

        return false;
    }
}
