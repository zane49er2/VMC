package com.zane49er.MagicalRifts.features;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RiftReader extends Item {

	public RiftReader() {
		super();
		this.setCreativeTab(Registry.RiftItemsTab);
		this.setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		this.itemIcon = reg.registerIcon("zanesmod:RiftReader");
	}

}
