package me.staud.apollo;

import me.staud.apollo.command.*;
import me.staud.apollo.kits.KitsCommand;
import me.staud.apollo.listener.KitsListener;
import me.staud.apollo.listener.PlayerListener;
import me.staud.apollo.listener.SoupListener;
import me.staud.apollo.scoreboard.Negox;
import me.staud.apollo.scoreboard.provider.Board;
import me.staud.apollo.scoreboard.provider.BoardAdapter;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Apollo extends JavaPlugin implements Listener, BoardAdapter {

    @Getter
    private static Apollo instance;
    static Apollo plugin;
    private Player player;

    @Override
    public void onEnable() {
        System.out.println("Apollo has been enabled.");
        registerCommands();
        registerListeners();
        instance = this;
        plugin = this;
        Bukkit.getPluginManager().registerEvents(this, this);
        new Negox(this, this, 2L);
    }

    public void registerCommands() {
        getCommand("kits").setExecutor(new KitsCommand());
        getCommand("reset").setExecutor(new ResetCommand());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("report").setExecutor(new ReportCommand());
        getCommand("help").setExecutor(new HelpCommand());
    }

    public void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new SoupListener(), this);
        pm.registerEvents(new KitsListener(), this);
    }
    @Override
    public void onDisable() {

        System.out.println("Apollo has been disabled.");
    }
    public static Apollo getPlugin() {
        return Apollo.plugin;
    }

    public static Apollo getInstance() {
        return Apollo.instance;
    }

    public String getTitle(final Player player) {
        return "&3&lKITPVP &7| &fSeason 1";
    }

    public List<String> getHeader() {
        final List<String> strings = new ArrayList<String>();
        strings.add("&7&m--------------------------");
        return strings;
    }

    public List<String> getFooter() {
        final List<String> strings = new ArrayList<String>();
        strings.add("&7&m--------------------------");
        return strings;
    }

    @Override
    public List<String> getScoreboard(Player player, Board board) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < getHeader().size(); i++) {
            strings.add(getHeader().get(i).toString().replace("[", "").replace("]", ""));
        }
        strings.add("&bKills&7: &f" + player.getStatistic(Statistic.PLAYER_KILLS));
        strings.add("&bDeaths&7: &f" + player.getStatistic(Statistic.DEATHS));
        strings.add("");
        strings.add("&7&oapollohq.club");

        for (int i = 0; i < getFooter().size(); i++) {
            strings.add(getFooter().get(i).toString().replace("[", "").replace("]", ""));
        }
        return strings;
    }
}
