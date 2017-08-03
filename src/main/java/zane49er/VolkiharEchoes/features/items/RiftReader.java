package zane49er.VolkiharEchoes.features.items;

import zane49er.VolkiharEchoes.init.ModTabs;
import zane49er.VolkiharEchoes.main.References;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class RiftReader extends Item{

	public RiftReader(String registryName){
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		setMaxStackSize(1);
		setCreativeTab(ModTabs.useful);
	}
	
}