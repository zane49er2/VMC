package zane49er.VolkiharEchoes.init;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import zane49er.VolkiharEchoes.features.ModTabUseful;

public class ModTabs {
	
	public static CreativeTabs useful;

	public static void init() {
		useful = new ModTabUseful("TabUseful");
	}
}
