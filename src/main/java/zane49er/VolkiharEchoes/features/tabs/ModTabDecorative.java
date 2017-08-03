package zane49er.VolkiharEchoes.features.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import zane49er.VolkiharEchoes.init.ModBlocks;
import zane49er.VolkiharEchoes.init.ModItems;

public class ModTabDecorative extends CreativeTabs{

	public ModTabDecorative(String name) {
		super("TabDecorative");
	}
	
	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.whiteObsidian);
	}

}
