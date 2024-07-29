package cz.kominekjan.userInterfacesAPI.types;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public interface IUserInterfaceItem {
    Integer getSlot();

    ItemStack getItem();

    default void onClick(InventoryClickEvent event) {
    }
}
