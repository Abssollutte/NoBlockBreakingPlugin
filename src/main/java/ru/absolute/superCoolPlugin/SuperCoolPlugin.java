package ru.absolute.superCoolPlugin;

import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import ru.absolute.superCoolPlugin.commands.ExplosionCommand;

public final class SuperCoolPlugin extends JavaPlugin implements Listener {
    public static float ExplosionpPower = 45;
    public static boolean ExplosionSetFire = false;
    public static boolean ExplosionsBreakBlocks = false;
    public static boolean ArmorBreak = true;

    private void explodePlayer(Player player) {
        Location playerLocation = player.getLocation();
        World playerWord = player.getWorld();
        ItemStack[] armorContents = player.getInventory().getArmorContents();
        for (ItemStack armorContent : armorContents) {
            if (armorContent != null && ArmorBreak) {
                armorContent.setDurability((short) 591);
            }
        }
        playerWord.createExplosion(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ(), ExplosionpPower, ExplosionSetFire, ExplosionsBreakBlocks);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enabled!");
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("explosion").setExecutor(new ExplosionCommand());


    }


    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
        event.setCancelled(true);
        explodePlayer(event.getPlayer());


    }

//    @Override
//    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//        if (label.equalsIgnoreCase("explosion")) {
//            if (args.length == 1) {
//                sender.sendMessage(args[0]);
//            }
//        }
//        return true;
//    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabled!");
    }
}
