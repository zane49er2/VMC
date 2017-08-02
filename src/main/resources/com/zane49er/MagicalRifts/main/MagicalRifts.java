package com.zane49er.MagicalRifts.main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.Gui;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.zane49er.MagicalRifts.features.Essence;
import com.zane49er.MagicalRifts.features.Registry;
import com.zane49er.MagicalRifts.features.Rift;
import com.zane49er.MagicalRifts.features.RiftReader;
import com.zane49er.MagicalRifts.features.RiftTome;
import com.zane49er.MagicalRifts.world.RiftsWorld;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Metadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MagicalRifts.MODID, version = MagicalRifts.VERSION)
public class MagicalRifts {
	
	public static final String MODID = "MagicalRifts";
	public static final String VERSION = "0.1";

	@Metadata
	public static ModMetadata meta;

	@Instance(MODID)
	public static MagicalRifts modInstance;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		RiftsWorld.MainRegistry();
		Registry.MainRegistry();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {

	}
}
