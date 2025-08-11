package io.papermc.paper.world.waypoint;

import io.papermc.paper.registry.data.client.ClientTextureAsset;
import org.bukkit.Color;

public interface WaypointIcon {

    Color getColor();

    ClientTextureAsset getAsset();

}
