package ru.absolute.superCoolPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ru.absolute.superCoolPlugin.SuperCoolPlugin;

import static org.bukkit.Bukkit.getLogger;

public class ExplosionCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("explosion")) {
            if (args.length != 4) {
                getLogger().warning("Usage /explosion [arg1] [arg2] [arg3] [arg4]");
            }
            else {
                SuperCoolPlugin.ExplosionpPower = Integer.parseInt(args[0]);
                SuperCoolPlugin.ExplosionSetFire = Boolean.parseBoolean(args[1]);
                SuperCoolPlugin.ExplosionsBreakBlocks = Boolean.parseBoolean(args[2]);
                SuperCoolPlugin.ArmorBreak = Boolean.parseBoolean(args[3]);
                getLogger().info("New values applied!");
            }
        }
        return true;
    }
}
