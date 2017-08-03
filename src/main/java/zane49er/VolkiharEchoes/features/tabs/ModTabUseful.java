package zane49er.VolkiharEchoes.features.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import zane49er.VolkiharEchoes.init.ModItems;

public class ModTabUseful extends CreativeTabs{

	public ModTabUseful(String name) {
		super("TabUseful");
	}
	
	@Override
	public Item getTabIconItem() {
		return ModItems.riftReader;
	}

}
