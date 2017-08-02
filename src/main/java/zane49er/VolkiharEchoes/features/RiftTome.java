package zane49er.VolkiharEchoes.features;

import zane49er.VolkiharEchoes.main.References;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class RiftTome extends Item{

	public RiftTome(String registryName){
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		setMaxStackSize(1);
	}
	
}
