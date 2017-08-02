package zane49er.VolkiharEchoes.features;

import java.util.Random;

import zane49er.VolkiharEchoes.init.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenRifts implements IWorldGenerator {

	/*public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider Provider) {
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
	}*/

	private void generateSurface(World world, Random rand, int x, int z) {
		int randPosX = x + rand.nextInt(16);
		int randPosY = 80 + rand.nextInt(10);
		int randPosZ = z + rand.nextInt(16);
		if ((world.getBlockState(new BlockPos(randPosX, randPosY, randPosZ)) == Blocks.AIR.getDefaultState()) && (rand.nextInt(15) == 1)) {
			while(world.getBlockState(new BlockPos(randPosX, randPosY-1, randPosZ)) == Blocks.AIR.getDefaultState()) randPosY--;
			randPosY+=rand.nextInt(5);
			world.setBlockState(new BlockPos(randPosX, randPosY, randPosZ), ModBlocks.rift.getDefaultState());
		}
	}

	private void generateNether(World world, Random rand, int x, int z) {
		for(int i = 0; i< 10; i++){
			int randPosX = x + rand.nextInt(16);
			int randPosY = rand.nextInt(255);
			int randPosZ = z + rand.nextInt(16);
			if ((world.getBlockState(new BlockPos(randPosX, randPosY, randPosZ)) == Blocks.AIR.getDefaultState()) && (rand.nextInt(5) == 1)) {
				if(rand.nextInt(2) == 1){
					while(world.getBlockState(new BlockPos(randPosX, randPosY-1, randPosZ)) == Blocks.AIR.getDefaultState()) {
						randPosY--;
					}
					randPosY+=rand.nextInt(5);
					world.setBlockState(new BlockPos(randPosX, randPosY, randPosZ), ModBlocks.rift.getDefaultState());
				} else
				world.setBlockState(new BlockPos(randPosX, randPosY, randPosZ), ModBlocks.rift.getDefaultState());
			}
		}
	}

	private void generateEnd(World world, Random rand, int x, int z) {
		for(int i = 0; i < 10; i++){
			int randPosX = x + rand.nextInt(16);
			int randPosY = rand.nextInt(255);
			int randPosZ = z + rand.nextInt(16);
			if ((world.getBlockState(new BlockPos(randPosX, randPosY, randPosZ)) == Blocks.AIR.getDefaultState())) {
				world.setBlockState(new BlockPos(randPosX, randPosY, randPosZ), ModBlocks.rift.getDefaultState());
			}
		}
	}

	private void generateEndModerate(World world, Random rand, int x, int z) {
		for(int i = 0; i < 16; i++){
			int randPosX = x + rand.nextInt(16);
			int randPosY = rand.nextInt(255);
			int randPosZ = z + rand.nextInt(16);
			if ((world.getBlockState(new BlockPos(randPosX, randPosY, randPosZ)) == Blocks.AIR.getDefaultState())) {
				world.setBlockState(new BlockPos(randPosX, randPosY, randPosZ), ModBlocks.rift.getDefaultState());
			}
		}
	}

	private void generateEndCrazy(World world, Random rand, int x, int z) {
		for(int i = 0; i < 32; i++){
			int randPosX = x + rand.nextInt(16);
			int randPosY = rand.nextInt(255);
			int randPosZ = z + rand.nextInt(16);
			if ((world.getBlockState(new BlockPos(randPosX, randPosY, randPosZ)) == Blocks.AIR.getDefaultState())) {
				world.setBlockState(new BlockPos(randPosX, randPosY, randPosZ), ModBlocks.rift.getDefaultState());
			}
		}
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider Provider) {
		switch (world.provider.getDimension()) {
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

}
