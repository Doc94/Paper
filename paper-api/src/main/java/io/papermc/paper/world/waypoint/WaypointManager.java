package io.papermc.paper.world.waypoint;

import org.bukkit.World;
import org.jspecify.annotations.NullMarked;
import java.util.List;

@NullMarked
public interface WaypointManager {

    World getWorld();

    List<WaypointTransmitter> getWaypoints();

    boolean isEnabled();

    void untrackWaypoint(WaypointTransmitter waypoint);

    void trackWaypoint(WaypointTransmitter waypoint);

}
