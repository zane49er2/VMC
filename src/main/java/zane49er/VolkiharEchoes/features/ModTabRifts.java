package zane49er.VolkiharEchoes.features;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import zane49er.VolkiharEchoes.init.ModBlocks;
import zane49er.VolkiharEchoes.init.ModItems;

public class ModTabRifts extends CreativeTabs{

	public ModTabRifts(String name) {
		super("TabRifts");
	}
	
	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.rift);
	}

}
