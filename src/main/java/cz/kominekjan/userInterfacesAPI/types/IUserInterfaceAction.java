package cz.kominekjan.userInterfacesAPI.types;

import org.bukkit.event.inventory.InventoryClickEvent;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public interface IUserInterfaceAction {
    void onClick(InventoryClickEvent event);
}
