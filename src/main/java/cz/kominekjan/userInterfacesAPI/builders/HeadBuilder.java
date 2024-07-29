package cz.kominekjan.userInterfacesAPI.builders;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class HeadBuilder extends ItemBuilder {
    public HeadBuilder() {
        super(Material.PLAYER_HEAD);
    }

    private SkullMeta getSkullMeta() {
        return (SkullMeta) this.getItemMeta();
    }

    public HeadBuilder setSkullMeta(SkullMeta meta) {
        this.setItemMeta(meta);
        return this;
    }

    public HeadBuilder setTexture(String texture) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");

        profile.getProperties().put("textures", new Property("textures", texture));

        SkullMeta meta = this.getSkullMeta();

        Field profileField;

        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setItemMeta(meta);

        return this;
    }

    public ItemBuilder setHeadOwner(OfflinePlayer owner) {
        SkullMeta meta = (SkullMeta) this.getItemMeta();
        meta.setOwningPlayer(owner);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setHeadOwner(String owner) {
        SkullMeta meta = (SkullMeta) this.getItemMeta();
        meta.setOwner(owner);
        this.setItemMeta(meta);
        return this;
    }
}
