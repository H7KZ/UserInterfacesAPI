package cz.kominekjan.userInterfacesAPI.types;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.permissions.Permission;

import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public interface IUserInterfaceInventory {
    Inventory getInventory();
    Permission getPermission();

    List<IUserInterfaceItem> getItems();

    default InventoryHolder getHolder() {
        return getInventory().getHolder();
    }

    default void onClick(InventoryClickEvent event) {
        if (getPermission() != null && !event.getWhoClicked().hasPermission(getPermission())) return;

        for (IUserInterfaceItem item : getItems()) {
            if (item.getSlot() != event.getSlot()) continue;

            if (item.getPermission() != null && !event.getWhoClicked().hasPermission(item.getPermission())) return;

            item.onClick(event);
        }
    }
}
