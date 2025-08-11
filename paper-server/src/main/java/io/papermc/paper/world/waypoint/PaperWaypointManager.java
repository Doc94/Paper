package io.papermc.paper.world.waypoint;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.waypoints.ServerWaypointManager;
import net.minecraft.world.level.GameRules;
import org.bukkit.World;
import org.bukkit.craftbukkit.entity.CraftLivingEntity;
import java.util.List;

public class PaperWaypointManager implements WaypointManager {

    private final ServerLevel world;
    private final ServerWaypointManager handle;

    public PaperWaypointManager(ServerLevel serverLevel, ServerWaypointManager handle) {
        this.world = serverLevel;
        this.handle = handle;
    }


    @Override
    public World getWorld() {
        return this.world.getWorld();
    }

    @Override
    public List<WaypointTransmitter> getWaypoints() {
        return List.of();
    }

    @Override
    public boolean isEnabled() {
        return this.world.getGameRules().getBoolean(GameRules.RULE_LOCATOR_BAR);
    }

    @Override
    public void untrackWaypoint(final WaypointTransmitter waypoint) {
        if (waypoint instanceof CraftLivingEntity craftLivingEntity) {
            this.handle.untrackWaypoint(craftLivingEntity.getHandle());
        }
    }

    @Override
    public void trackWaypoint(final WaypointTransmitter waypoint) {
        if (waypoint instanceof CraftLivingEntity craftLivingEntity) {
            this.handle.trackWaypoint(craftLivingEntity.getHandle());
        }
    }
}
