package com.greenchild.green;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public final class Green extends JavaPlugin {
    public static Green instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        log("Nice, I'm Bloody Awake");
        log(execCmd("uname -a"));

        getCommand("run").setExecutor(new Run());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static String execCmd(String cmd) {
        String result = null;
        try (InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
             Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
            result = s.hasNext() ? s.next() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void log(String msg) {
        Bukkit.getLogger().info("/// {\n\t" + msg + "\n}");
    }
}

