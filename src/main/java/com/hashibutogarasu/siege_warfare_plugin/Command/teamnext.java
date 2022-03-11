package com.hashibutogarasu.siege_warfare_plugin.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import static com.hashibutogarasu.siege_warfare_plugin.Command.setteam.players;
import static org.bukkit.Bukkit.getServer;

public class teamnext {
    public static int count = 0;

    /**
     * Send next rawtext to sender
     * for文だと鯖にいるプレイヤーの選択テキストのすべてを一気に送って見にくくなるのでステップ形式にした
     * @return void
     */
    public static boolean run(CommandSender sender, Command cmd, String commandLabel, String[] args){

        String playername = "Kara_su";

        getServer().dispatchCommand(getServer().getConsoleSender(),
                "team join " + args[0] + " " + playername
        );

        getServer().dispatchCommand(getServer().getConsoleSender(),
                "tellraw " + sender.getName() + " [\"\",{\"text\":\"[\"},{\"text\":\"" + playername + "\",\"color\":\"yellow\"},{\"text\":\"] \"},{\"text\":\"赤チームに追加\\u2690\",\"underlined\":true,\"color\":\"red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/teamnext red " + playername + "\"}},{\"text\":\" \"},{\"text\":\"青チームに追加\\u2690\",\"underlined\":true,\"color\":\"blue\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/teamnext blue " + playername + "\"}},{\"text\":\" \"},{\"text\":\"チーム状態をリセット×\",\"underlined\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/team leave " + "Kara_su" + "\"}}]"
        );

        count++;

        return true;
    }
}
