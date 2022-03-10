package com.hashibutogarasu.siege_warfare_plugin;

import com.hashibutogarasu.siege_warfare_plugin.Command.setteam;
import com.hashibutogarasu.siege_warfare_plugin.Command.startsiegewarfare;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Siege_Warfare_Plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("攻城戦プラグインを開始しました");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("setteam")){
            return setteam.run(sender,cmd,commandLabel,args);
        }
        if(cmd.getName().equalsIgnoreCase("startsiegewarfare")){
            return startsiegewarfare.run(sender,cmd,commandLabel,args);
        }

        return false;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("攻城戦プラグインを停止しました");
    }
}