package cz.kominekjan.userInterfacesAPI.types;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public interface IUserInterfaceItem {
    Integer getSlot();
    ItemStack getItem();
    Permission getPermission();

    default void onClick(InventoryClickEvent event) {
    }
}
