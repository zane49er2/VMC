package zane49er.VolkiharEchoes.features;

import java.util.Random;

import zane49er.VolkiharEchoes.init.ModTabs;
import zane49er.VolkiharEchoes.main.VolkiharEchoes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Destabilizer extends Block {

	boolean powered;
	
	public Destabilizer(String registryName) {
		super(Material.PISTON);
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		setHardness(3.0f);
		setCreativeTab(ModTabs.useful);
	}

	@Override
	//@SideOnly(Side.CLIENT)
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		//if (!worldIn.isBlockPowered(pos)) {
			powered = worldIn.isBlockPowered(pos);
		//}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (!powered) {
			worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) pos.getX() + 0.5 , (double) pos.getY() + 2, (double) pos.getZ() + 0.5 , 0, 0, 0, new int[0]);
			super.randomDisplayTick(stateIn, worldIn, pos, rand);
		}
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