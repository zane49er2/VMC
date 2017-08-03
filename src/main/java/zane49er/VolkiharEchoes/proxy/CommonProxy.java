package zane49er.VolkiharEchoes.proxy;

import zane49er.VolkiharEchoes.init.ModGUIs;
import zane49er.VolkiharEchoes.init.ModTileEntities;
import zane49er.VolkiharEchoes.main.VolkiharEchoes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

	public void registerRenders() {
		
	}
	
	public void init() {
	    NetworkRegistry.INSTANCE.registerGuiHandler(VolkiharEchoes.instance, new ModGUIs());
	    ModTileEntities.init();
	}

}
