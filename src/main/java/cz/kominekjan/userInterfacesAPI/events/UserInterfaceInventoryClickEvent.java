package cz.kominekjan.userInterfacesAPI.events;

import cz.kominekjan.userInterfacesAPI.managers.UserInterfacesManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class UserInterfaceInventoryClickEvent implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {
        UserInterfacesManager manager = UserInterfacesManager.getInstance();

        manager.getRegisteredInventories().forEach(inventory -> {
            if (inventory.equals(event.getInventory().getHolder())) {
                inventory.onClick(event);
            }
        });
    }
}
