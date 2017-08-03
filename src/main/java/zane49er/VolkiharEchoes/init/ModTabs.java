package zane49er.VolkiharEchoes.init;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import zane49er.VolkiharEchoes.features.tabs.ModTabDecorative;
import zane49er.VolkiharEchoes.features.tabs.ModTabEssence;
import zane49er.VolkiharEchoes.features.tabs.ModTabRifts;
import zane49er.VolkiharEchoes.features.tabs.ModTabUseful;

public class ModTabs {

	public static CreativeTabs useful;
	public static CreativeTabs rifts;
	public static CreativeTabs essence;
	public static CreativeTabs crafting;
	public static CreativeTabs decorative;

	public static void init() {
		useful = new ModTabUseful("TabUseful");
		rifts = new ModTabRifts("TabRifts");
		essence = new ModTabEssence("TabEssence");
		decorative = new ModTabDecorative("TabDecorative");
	}
}
