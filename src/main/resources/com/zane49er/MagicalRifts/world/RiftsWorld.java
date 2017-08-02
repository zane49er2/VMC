package com.zane49er.MagicalRifts.world;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class RiftsWorld {

	public static void MainRegistry() {
		initWorldGen();
	}
	
	public static void initWorldGen(){
		registerWorldGen(new WorldGenRifts(),1);
	}
	
	public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProbability){
		GameRegistry.registerWorldGenerator(worldGenClass, weightedProbability);
	}
	
}
