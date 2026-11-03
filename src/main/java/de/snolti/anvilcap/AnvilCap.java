package de.snolti.anvilcap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.view.AnvilView;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The vanilla client refuses anvil results costing 40+ levels ("Too Expensive!").
 * Lift the server-side limit and clamp the shown/charged cost to 39 so the client accepts it.
 */
public final class AnvilCap extends JavaPlugin implements Listener {

    private static final int MAX_CLIENT_COST = 39;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {
        if (event.getView() instanceof AnvilView view) {
            view.setMaximumRepairCost(Integer.MAX_VALUE);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPrepare(PrepareAnvilEvent event) {
        AnvilView view = event.getView();
        view.setMaximumRepairCost(Integer.MAX_VALUE);
        if (view.getRepairCost() > MAX_CLIENT_COST) {
            view.setRepairCost(MAX_CLIENT_COST);
        }
    }
}
