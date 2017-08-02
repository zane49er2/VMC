package com.zane49er.MagicalRifts.features;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.Gui;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.zane49er.MagicalRifts.main.MagicalRifts;

public class Registry {

	public static void MainRegistry() {
		initThings();
		registerThings();
	}

	public static CreativeTabs RiftTab = new CreativeTabs("Rift Colors") {
		public Item getTabIconItem() {
			return RiftReader;
		}
	};
	public static CreativeTabs EssenceTab = new CreativeTabs("Crafting Rift Items") {
		public Item getTabIconItem() {
			return Essence;
		}
	};
	public static CreativeTabs RiftItemsTab = new CreativeTabs("Useful Rift Items") {
		public Item getTabIconItem() {
			return RiftTome;
		}
	};

	public static Block Rift;

	public static Item Essence;
	public static Item RiftTome;
	public static Item RiftReader;

	private static void initThings() {
		Rift = new Rift(Material.CLOTH).setHardness(1.5F).setBlockName("Rift");
		Essence = new Essence().setUnlocalizedName("Essence");
		RiftTome = new RiftTome().setUnlocalizedName("RiftTome");
		RiftReader = new RiftReader().setUnlocalizedName("RiftReader");
	}

	private static void registerThings() {
		GameRegistry.registerBlock(Rift, "Rift");
		
		GameRegistry.registerItem(Essence, "Essence");
		GameRegistry.registerItem(RiftTome, "RiftTome");
		GameRegistry.registerItem(RiftReader, "RiftReader");
	}

}
