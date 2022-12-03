package com.greenchild.green;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Run implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        StringBuilder cmd = new StringBuilder();
        for (String arg : args) {
            cmd.append(" ").append(arg);
        }
        String out = Green.execCmd(cmd.toString());
        Green.log(out);
        return true;
    }
}
