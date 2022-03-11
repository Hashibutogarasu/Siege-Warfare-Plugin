package com.hashibutogarasu.siege_warfare_plugin.Command;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import  net.md_5.bungee.api.chat.*;

import java.util.Collection;

import static org.bukkit.Bukkit.dispatchCommand;
import static org.bukkit.Bukkit.getServer;

public class setteam {
    public static boolean run(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(args.length != 0 && sender.isOp()){
            String mode = args[0];
            if(mode.matches("random")){
                sender.sendMessage("ランダムでチームを設定します");

                return true;
            }

            if(mode.matches("custom")){
                Collection<? extends Player> players = sender.getServer().getOnlinePlayers();
                sender.sendMessage("カスタムでチームを設定します");
                sender.sendMessage("プレイヤー数：" + players.size());

                getServer().dispatchCommand(getServer().getConsoleSender(),
                        "tellraw " + sender.getName() + "[\"\",{\"text\":\"[\"},{\"text\":\"Playername\",\"color\":\"yellow\"},{\"text\":\"] \"},{\"text\":\"赤チームに追加\\u2690\",\"underlined\":true,\"color\":\"red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/team join red Kara_su\"}},{\"text\":\" \"},{\"text\":\"青チームに追加\\u2690\",\"underlined\":true,\"color\":\"blue\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/team join blue Kara_su\"}},{\"text\":\" \"},{\"text\":\"チーム状態をリセット×\",\"underlined\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/team leave Kara_su\"}}]"
                );

                return true;
            }
        }

        return false;
    }
}
