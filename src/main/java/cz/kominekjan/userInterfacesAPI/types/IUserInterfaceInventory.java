package cz.kominekjan.userInterfacesAPI.types;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public interface IUserInterfaceInventory {
    Inventory getInventory();

    List<IUserInterfaceItem> getItems();

    default InventoryHolder getHolder() {
        return getInventory().getHolder();
    }

    default void onClick(InventoryClickEvent event) {
        for (IUserInterfaceItem item : getItems()) {
            if (item.getSlot() == event.getSlot()) item.onClick(event);
        }
    }
}
