package zane49er.VolkiharEchoes.init;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import zane49er.VolkiharEchoes.features.ModTabDecorative;
import zane49er.VolkiharEchoes.features.ModTabEssence;
import zane49er.VolkiharEchoes.features.ModTabRifts;
import zane49er.VolkiharEchoes.features.ModTabUseful;

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
