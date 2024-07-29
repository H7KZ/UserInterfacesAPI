package cz.kominekjan.userInterfacesAPI.managers;

import cz.kominekjan.userInterfacesAPI.types.IUserInterfaceInventoryHolder;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class UserInterfacesManager {
    private static UserInterfacesManager instance;
    private static List<IUserInterfaceInventoryHolder> inventories;

    private UserInterfacesManager() {
        inventories = new ArrayList<>();
    }

    public static UserInterfacesManager getInstance() {
        if (instance == null) {
            instance = new UserInterfacesManager();
        }
        return instance;
    }

    public List<IUserInterfaceInventoryHolder> getRegisteredInventories() {
        return inventories;
    }

    public void registerInventory(IUserInterfaceInventoryHolder inventory) {
        inventories.add(inventory);
    }

    public void unregisterInventory(IUserInterfaceInventoryHolder inventory) {
        inventories.remove(inventory);
    }

    public void unregisterAllInventories() {
        inventories.clear();
    }
}
