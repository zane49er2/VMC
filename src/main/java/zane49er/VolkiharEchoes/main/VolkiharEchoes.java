package zane49er.VolkiharEchoes.main;

import zane49er.VolkiharEchoes.features.tabs.ModTabUseful;
import zane49er.VolkiharEchoes.init.ModBlocks;
import zane49er.VolkiharEchoes.init.ModItems;
import zane49er.VolkiharEchoes.init.ModTabs;
import zane49er.VolkiharEchoes.init.ModWorldGen;
import zane49er.VolkiharEchoes.proxy.CommonProxy;
import zane49er.VolkiharEchoes.util.Util;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
//version convention: "content version . patch . trial"

public class VolkiharEchoes {

	//@Mod.Instance(References.MODID)
	@Instance
	public static VolkiharEchoes instance;
	
	@SidedProxy(serverSide = References.SERVER_PROXY_CLASS, clientSide = References.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	void preInit(FMLPreInitializationEvent event){
		ModTabs.init();
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		ModWorldGen.init();
		proxy.registerRenders();
		proxy.init();
	}
	
	@EventHandler
	void Init(FMLInitializationEvent event){
		//proxy.init();
	}
	
	@EventHandler
	void postInit(FMLPostInitializationEvent event){
		
	}
	
}
