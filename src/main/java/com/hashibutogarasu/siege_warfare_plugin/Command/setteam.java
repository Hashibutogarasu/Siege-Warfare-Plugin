package com.hashibutogarasu.siege_warfare_plugin.Command;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class setteam {
    public static boolean run(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(args.length != 0 && !(sender instanceof Player)){
            String mode = args[0];
            if(mode.matches("random")){
                sender.sendMessage("ランダムでチームを設定します");

                return true;
            }

            if(mode.matches("custom")){
                Collection<? extends Player> players = sender.getServer().getOnlinePlayers();
                sender.sendMessage("カスタムでチームを設定します");
                sender.sendMessage("プレイヤー数：" + players.size());

                //sender.sendMessage(ChatColor.RED + "Correct usage: /" + commandLabel + " <player>");

                if(players.size() != 0){
                    for(Player player : players){
                            BaseComponent[] command = new ComponentBuilder()
                                    .append("[").color(ChatColor.WHITE)
                                    .append(player.getName()).color(ChatColor.YELLOW)
                                    .append("]").color(ChatColor.WHITE)
                                    .append("赤チームに追加⚐").color(ChatColor.RED).bold(true).event(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/team join red " + player.getName()))
                                    .append("青チームに追加⚐").color(ChatColor.BLUE).bold(true).event(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/team join blue " + player.getName()))
                                    .append("チーム状態をリセット×").color(ChatColor.WHITE).bold(true).event(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/team leave " + player.getName()))
                                    .create();



                            return true;
                    }
                }

                return true;
            }
        }

        return false;
    }
}
