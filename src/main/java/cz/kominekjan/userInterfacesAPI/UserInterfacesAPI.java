package cz.kominekjan.userInterfacesAPI;

import cz.kominekjan.userInterfacesAPI.builders.HeadBuilder;
import cz.kominekjan.userInterfacesAPI.builders.ItemBuilder;
import cz.kominekjan.userInterfacesAPI.builders.UserInterfaceInventoryBuilder;
import cz.kominekjan.userInterfacesAPI.events.UserInterfaceInventoryClickEvent;
import cz.kominekjan.userInterfacesAPI.managers.UserInterfacesManager;
import org.bukkit.Material;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public final class UserInterfacesAPI {
    public static ItemBuilder getItemBuilder(Material mat) {
        return new ItemBuilder(mat);
    }

    public static HeadBuilder getHeadBuilder() {
        return new HeadBuilder();
    }

    public static UserInterfaceInventoryBuilder getInventoryBuilder() {
        return new UserInterfaceInventoryBuilder();
    }

    public static UserInterfacesManager getManager() {
        return UserInterfacesManager.getInstance();
    }

    public static UserInterfaceInventoryClickEvent getInventoryClickEvent() {
        return new UserInterfaceInventoryClickEvent();
    }
}
