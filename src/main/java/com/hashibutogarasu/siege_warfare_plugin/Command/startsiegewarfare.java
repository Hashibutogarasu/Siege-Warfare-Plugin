package com.hashibutogarasu.siege_warfare_plugin.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class startsiegewarfare {
    public static boolean run(CommandSender sender, Command cmd, String commandLabel, String[] args){
        sender.sendMessage("開始");
        return true;
    }
}