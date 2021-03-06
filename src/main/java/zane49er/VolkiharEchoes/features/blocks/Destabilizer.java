package zane49er.VolkiharEchoes.features.blocks;

import java.util.Random;

import zane49er.VolkiharEchoes.init.ModTabs;
import zane49er.VolkiharEchoes.main.VolkiharEchoes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Destabilizer extends Block{

	// stored in NBT
	boolean powered;
	boolean enderFluid;
	int size = 5;

	// should be in config
	int particleRows = 16;
	int particleLayers = 8;

	public Destabilizer(String registryName) {
		super(Material.PISTON);
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		setHardness(3.0f);
		setCreativeTab(ModTabs.useful);
	}

	@Override
	// @SideOnly(Side.CLIENT)
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		// if (!worldIn.isBlockPowered(pos)) {
		powered = worldIn.isBlockPowered(pos);
		// }
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (!worldIn.isBlockPowered(pos)) {
			for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / (particleRows / 2)) {
				for (double phi = 0; phi < Math.PI; phi += Math.PI / particleLayers) {

					double x = size * Math.cos(theta) * Math.sin(phi);
					double y = size * Math.cos(phi);
					double z = size * Math.sin(theta) * Math.sin(phi);

					// if (0 < Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)
					// && 5 > Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2))
					// {
					worldIn.spawnParticle(EnumParticleTypes.DRAGON_BREATH, true, (double) pos.getX() + 0.5 + x, (double) pos.getY() + 2.5 + y + size, (double) pos.getZ() + 0.5 + z, 0, 0, 0, new int[0]);
					// }
				}
			}
		} else {
			worldIn.spawnParticle(EnumParticleTypes.FLAME, true, (double) pos.getX() + 0.5, (double) pos.getY() + 2, (double) pos.getZ() + 0.5, 0, 0, 0, new int[0]);
			super.randomDisplayTick(stateIn, worldIn, pos, rand);
		}
		super.randomDisplayTick(stateIn, worldIn, pos, rand);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// super.isOpaqueCube(state);
		return false;
	}

	@Override
	public boolean isFullBlock(IBlockState p_isFullBlock_1_) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState p_isFullCube_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFullyOpaque(IBlockState p_isFullyOpaque_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess access, BlockPos pos, EnumFacing facing) {
		return true;
	}

}