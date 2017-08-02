package zane49er.VolkiharEchoes.features;

import zane49er.VolkiharEchoes.init.ModTabs;
import zane49er.VolkiharEchoes.main.References;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class Essence extends Item{

	public Essence(String registryName){
		/*setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(References.MODID, registryName));*/
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		setMaxStackSize(64);
		setCreativeTab(ModTabs.essence);
	}
	
}