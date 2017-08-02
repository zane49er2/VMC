package com.zane49er.MagicalRifts.world;

import java.util.Random;

import com.zane49er.MagicalRifts.features.Registry;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenRifts implements IWorldGenerator {

	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider Provider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, rand, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, rand, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, rand, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateSurface(World world, Random rand, int x, int z) {
		int randPosX = x + rand.nextInt(16);
		int randPosY = 80 + rand.nextInt(10);
		int randPosZ = z + rand.nextInt(16);
		if ((world.getBlock(randPosX, randPosY, randPosZ) == Blocks.air) && (rand.nextInt(15) == 1)) {
			world.setBlock(randPosX, randPosY, randPosZ, Registry.Rift);
			}
		
		

	}

	private void generateNether(World world, Random rand, int x, int z) {
	}

	private void generateEnd(World world, Random rand, int x, int z) {
	}

}
