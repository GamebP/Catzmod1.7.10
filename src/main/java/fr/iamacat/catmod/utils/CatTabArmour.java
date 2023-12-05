package fr.iamacat.catmod.utils;

import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import fr.iamacat.catmod.init.RegisterItems;

public class CatTabArmour extends CreativeTabs{

    public CatTabArmour(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return RegisterItems.catCoin;
    }

    @Override
    public String getTranslatedTabLabel() {
        return "Cat Armor";
    }
}
