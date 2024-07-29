package cz.kominekjan.userInterfacesAPI.builders;

import cz.kominekjan.userInterfacesAPI.types.IUserInterfaceAction;
import cz.kominekjan.userInterfacesAPI.types.IUserInterfaceItem;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class UserInterfaceItemBuilder {
    private Integer slot;
    private ItemStack item;
    private IUserInterfaceAction action;

    public UserInterfaceItemBuilder() {
        this.slot = null;
        this.item = null;
        this.action = null;
    }

    public UserInterfaceItemBuilder setSlot(Integer slot) {
        this.slot = slot;
        return this;
    }

    public UserInterfaceItemBuilder setItem(ItemStack item) {
        this.item = item;
        return this;
    }

    public UserInterfaceItemBuilder setAction(IUserInterfaceAction action) {
        this.action = action;
        return this;
    }

    public IUserInterfaceItem build() {
        return new IUserInterfaceItem() {
            @Override
            public Integer getSlot() {
                return slot != null ? slot : 0;
            }

            @Override
            public ItemStack getItem() {
                return item != null ? item : null;
            }

            @Override
            public void onClick(InventoryClickEvent event) {
                if (action != null) action.onClick(event);
            }
        };
    }
}
