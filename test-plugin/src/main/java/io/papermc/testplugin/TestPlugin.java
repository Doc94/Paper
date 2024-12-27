package io.papermc.testplugin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);

        // io.papermc.testplugin.brigtests.Registration.registerViaOnEnable(this);
    }

    @EventHandler
    public void onEntityExplodeEvent(EntityExplodeEvent event) {
        Bukkit.broadcastMessage(ToStringBuilder.reflectionToString(event));
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockExplodeEvent(BlockExplodeEvent event) {
        Bukkit.broadcastMessage(ToStringBuilder.reflectionToString(event));
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreakEvent(EntityDamageEvent event) {
        Bukkit.broadcastMessage(ToStringBuilder.reflectionToString(event));
        if (event instanceof EntityDamageByEntityEvent entityDamageByEntityEvent) {
            Bukkit.broadcastMessage("Damager: " + entityDamageByEntityEvent.getDamager());
        } else if (event instanceof EntityDamageByBlockEvent entityDamageByBlockEvent) {
            Bukkit.broadcastMessage("Damager: " + entityDamageByBlockEvent.getDamager());
        }
    }

}
