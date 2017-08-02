package com.zane49er.MagicalRifts.features;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Essence extends Item {

	public Essence() {
		super();
		this.setCreativeTab(Registry.EssenceTab);
		this.setMaxStackSize(64);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		this.itemIcon = reg.registerIcon("zanesmod:Essence");
	}

}
