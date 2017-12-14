package zane49er.VolkiharEchoes.init;

import zane49er.VolkiharEchoes.features.GUIs.book.GUIBookLvl1;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGUIs implements IGuiHandler{

	
	public static final int BOOK_LVL_1_GUI = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	    if (ID == BOOK_LVL_1_GUI)
	        return new GUIBookLvl1();
	    return null;
	}

}
