package com.hashibutogarasu.siege_warfare_plugin;

import com.hashibutogarasu.siege_warfare_plugin.Command.setteam;
import com.hashibutogarasu.siege_warfare_plugin.Command.startsiegewarfare;
import com.hashibutogarasu.siege_warfare_plugin.Command.teamnext;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Siege_Warfare_Plugin extends JavaPlugin {

    /**
     * サーバー開始時
     */
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("攻城戦プラグインを読み込んでいます");
        getLogger().info("攻城戦プラグインを読み込みました");
    }

    /**
     * コマンド実行時
     * @param sender
     * @param cmd
     * @param commandLabel
     * @param args
     * @return
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        /**
         * /setteam コマンド
         * チームをセットする
         */
        if(cmd.getName().equalsIgnoreCase("setteam")){
            return setteam.run(sender,cmd,commandLabel,args);
        }

        /**
         * /startsiegewarfare コマンド
         * セットしたチームで攻城戦を開始する
         */
        if(cmd.getName().equalsIgnoreCase("startsiegewarfare")){
            return startsiegewarfare.run(sender,cmd,commandLabel,args);
        }

        /**
         * /teamnext コマンド
         * /setteam コマンドで次へを押したときに実行されるコマンド
         */
        if(cmd.getName().equalsIgnoreCase("teamnext")){
            return teamnext.run(sender,cmd,commandLabel,args);
        }

        return false;
    }

    /**
     * サーバー停止時
     */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("攻城戦プラグインを停止しました");
    }
}