package cz.kominekjan.userInterfacesAPI.types;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public interface IUserInterfaceInventoryHolder extends InventoryHolder, Inventory {
    void onClick(InventoryClickEvent event);
}
