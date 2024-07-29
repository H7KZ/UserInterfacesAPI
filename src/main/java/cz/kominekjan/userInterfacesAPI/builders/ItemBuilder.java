package cz.kominekjan.userInterfacesAPI.builders;

import com.google.common.collect.Multimap;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Warning;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.components.FoodComponent;
import org.bukkit.inventory.meta.components.JukeboxPlayableComponent;
import org.bukkit.inventory.meta.components.ToolComponent;

import java.util.ArrayList;

import static org.bukkit.inventory.ItemFlag.*;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class ItemBuilder {
    protected ItemStack stack;

    public ItemBuilder(Material mat) {
        this.stack = new ItemStack(mat);
    }

    protected ItemMeta getItemMeta() {
        ItemMeta meta = this.stack.getItemMeta();

        if (meta == null) meta = Bukkit.getItemFactory().getItemMeta(this.stack.getType());

        return meta;
    }

    public ItemBuilder setItemMeta(ItemMeta meta) {
        this.stack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setColor(Color color) {
        LeatherArmorMeta meta = (LeatherArmorMeta) this.getItemMeta();
        meta.setColor(color);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setGlow(boolean glow) {
        if (glow) {
            this.addEnchantment(Enchantment.KNOCKBACK, 1);
            this.addItemFlag(ItemFlag.HIDE_ENCHANTS);
        } else {
            ItemMeta meta = this.getItemMeta();
            for (Enchantment enchantment : meta.getEnchants().keySet()) {
                meta.removeEnchant(enchantment);
            }
        }
        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        ItemMeta meta = this.getItemMeta();
        meta.setUnbreakable(unbreakable);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.stack.setAmount(amount);
        return this;
    }

    public ItemBuilder setDisplayName(String name) {
        ItemMeta meta = this.getItemMeta();
        meta.setDisplayName(name);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setItemStack(ItemStack stack) {
        this.stack = stack;
        return this;
    }

    public ItemBuilder setLore(ArrayList<String> lore) {
        ItemMeta meta = this.getItemMeta();
        meta.setLore(lore);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(String lore) {
        ArrayList<String> loreList = new ArrayList<>();
        loreList.add(lore);
        ItemMeta meta = this.getItemMeta();
        meta.setLore(loreList);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        ItemMeta meta = this.getItemMeta();
        meta.addEnchant(enchantment, level, true);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addStoredEnchantment(Enchantment enchantment, int level) {
        ItemMeta meta = this.getItemMeta();

        if (meta instanceof EnchantmentStorageMeta storage)
            storage.addStoredEnchant(enchantment, level, true);
        else meta.addEnchant(enchantment, level, true);

        this.setItemMeta(meta);

        return this;
    }

    public ItemBuilder setEnchantmentGlint(boolean glint) {
        ItemMeta meta = this.getItemMeta();
        meta.setEnchantmentGlintOverride(glint);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addItemFlag(ItemFlag flag) {
        ItemMeta meta = this.getItemMeta();
        meta.addItemFlags(flag);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag[] flags) {
        for (ItemFlag flag : flags) {
            this.addItemFlag(flag);
        }

        return this;
    }

    public ItemBuilder addAllItemFlags() {
        ItemMeta meta = this.getItemMeta();
        meta.addItemFlags(
                HIDE_ENCHANTS,
                HIDE_ATTRIBUTES,
                HIDE_UNBREAKABLE,
                HIDE_DESTROYS,
                HIDE_PLACED_ON,
                HIDE_ADDITIONAL_TOOLTIP,
                HIDE_DYE,
                HIDE_ARMOR_TRIM,
                HIDE_STORED_ENCHANTS
        );
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder addAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        ItemMeta meta = this.getItemMeta();
        meta.addAttributeModifier(attribute, modifier);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setAttributeModifiers(Multimap<Attribute, AttributeModifier> attributeModifiers) {
        ItemMeta meta = this.getItemMeta();
        meta.setAttributeModifiers(attributeModifiers);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setCustomModelData(int data) {
        ItemMeta meta = this.getItemMeta();
        meta.setCustomModelData(data);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setFireResistant(boolean fireResistant) {
        ItemMeta meta = this.getItemMeta();
        meta.setFireResistant(fireResistant);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setFood(FoodComponent food) {
        ItemMeta meta = this.getItemMeta();
        meta.setFood(food);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder hideTooltip(boolean hide) {
        ItemMeta meta = this.getItemMeta();
        meta.setHideTooltip(hide);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setJukeboxPlayable(JukeboxPlayableComponent jukeboxPlayable) {
        ItemMeta meta = this.getItemMeta();
        meta.setJukeboxPlayable(jukeboxPlayable);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setMaxStackSize(int maxStackSize) {
        ItemMeta meta = this.getItemMeta();
        meta.setMaxStackSize(maxStackSize);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setRarity(ItemRarity rarity) {
        ItemMeta meta = this.getItemMeta();
        meta.setRarity(rarity);
        this.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setTool(ToolComponent tool) {
        ItemMeta meta = this.getItemMeta();
        meta.setTool(tool);
        this.setItemMeta(meta);
        return this;
    }

    @Warning(reason = "Internal use only")
    public ItemBuilder setVersion(int version) {
        ItemMeta meta = this.getItemMeta();
        meta.setVersion(version);
        this.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return this.stack;
    }
}
