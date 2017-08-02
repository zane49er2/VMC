package zane49er.VolkiharEchoes.proxy;

import zane49er.VolkiharEchoes.init.ModBlocks;
import zane49er.VolkiharEchoes.init.ModItems;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenders(){
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}

}
