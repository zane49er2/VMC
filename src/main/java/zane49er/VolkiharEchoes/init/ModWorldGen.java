package zane49er.VolkiharEchoes.init;

import zane49er.VolkiharEchoes.features.WorldGenRifts;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModWorldGen {

	public static void init() {
		initWorldGen();
	}
	
	public static void initWorldGen(){
		registerWorldGen(new WorldGenRifts(),1);
	}
	
	public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProbability){
		GameRegistry.registerWorldGenerator(worldGenClass, weightedProbability);
	}
	
}
