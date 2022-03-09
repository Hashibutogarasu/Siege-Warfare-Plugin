package com.hashibutogarasu.siege_warfare_plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Siege_Warfare_Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("攻城戦プラグインを開始しました");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("攻城戦プラグインを停止しました");
    }
}
