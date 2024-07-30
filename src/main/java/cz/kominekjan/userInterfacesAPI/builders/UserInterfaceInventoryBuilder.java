package cz.kominekjan.userInterfacesAPI.builders;

import cz.kominekjan.userInterfacesAPI.types.IUserInterfaceInventory;
import cz.kominekjan.userInterfacesAPI.types.IUserInterfaceItem;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.permissions.Permission;

import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class UserInterfaceInventoryBuilder {
    private Inventory inventory;
    private Permission permission;
    private List<IUserInterfaceItem> items;

    public UserInterfaceInventoryBuilder createInventory(InventoryHolder holder, InventoryType type, String title) {
        this.inventory = Bukkit.createInventory(holder, type, title);
        return this;
    }

    public UserInterfaceInventoryBuilder createInventory(InventoryHolder holder, int size, String title) {
        this.inventory = Bukkit.createInventory(holder, size, title);
        return this;
    }

    public UserInterfaceInventoryBuilder setInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }

    public UserInterfaceInventoryBuilder setPermission(String permission) {
        this.permission = new Permission(permission);
        return this;
    }

    public UserInterfaceInventoryBuilder setPermission(Permission permission) {
        this.permission = permission;
        return this;
    }

    public UserInterfaceInventoryBuilder addItems(List<IUserInterfaceItem> items) {
        for (IUserInterfaceItem item : items) {
            this.addItem(item);
        }
        return this;
    }

    public UserInterfaceInventoryBuilder addItem(IUserInterfaceItem... items) {
        for (IUserInterfaceItem item : items) {
            this.addItem(item);
        }
        return this;
    }

    public UserInterfaceInventoryBuilder addItem(IUserInterfaceItem item) {
        this.items.add(item);
        return this.setItem(item);
    }

    private UserInterfaceInventoryBuilder setItem(IUserInterfaceItem item) {
        this.inventory.setItem(item.getSlot(), item.getItem());
        return this;
    }

    public IUserInterfaceInventory build() {
        return new IUserInterfaceInventory() {
            @Override
            public Inventory getInventory() {
                return inventory;
            }

            @Override
            public Permission getPermission() {
                return permission;
            }

            @Override
            public List<IUserInterfaceItem> getItems() {
                return items;
            }
        };
    }
}
