package zane49er.VolkiharEchoes.features.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import zane49er.VolkiharEchoes.init.ModItems;

public class ModTabEssence extends CreativeTabs{

	public ModTabEssence(String name) {
		super("TabEssence");
	}
	
	@Override
	public Item getTabIconItem() {
		return ModItems.essence;
	}

}
