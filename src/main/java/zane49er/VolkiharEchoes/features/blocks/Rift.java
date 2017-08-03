package zane49er.VolkiharEchoes.features.blocks;

import java.util.List;
import java.util.Random;

import zane49er.VolkiharEchoes.features.tileEntities.TileEntityRift;
import zane49er.VolkiharEchoes.init.ModItems;
import zane49er.VolkiharEchoes.init.ModTabs;
import zane49er.VolkiharEchoes.main.References;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Rift extends BlockContainer {

	public Rift(String registryName) {
		super(Material.CLOTH);
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		//setLightLevel(1f);
		setLightOpacity(0);
		setHardness(1.0f);
		setCreativeTab(ModTabs.rifts);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int amount) {
		return ModItems.essence;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullBlock(IBlockState p_isFullBlock_1_) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState p_isFullCube_1_) {
		return false;
	}

	@Override
	public boolean isFullyOpaque(IBlockState p_isFullyOpaque_1_) {
		return false;
	}

	@Override
	public void dropXpOnBlockBreak(World world, BlockPos pos, int amount) {
		super.dropXpOnBlockBreak(world, pos, 10);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState p_getCollisionBoundingBox_1_, World p_getCollisionBoundingBox_2_, BlockPos p_getCollisionBoundingBox_3_) {
		return null;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityRift();
	}

	/*
	 * @Override public int getFlammability(IBlockAccess p_getFlammability_1_,
	 * BlockPos p_getFlammability_2_, EnumFacing p_getFlammability_3_) { // TODO
	 * Auto-generated method stub //return
	 * super.getFlammability(p_getFlammability_1_, p_getFlammability_2_,
	 * p_getFlammability_3_); return 0; }
	 * 
	 * @Override public boolean canCreatureSpawn(IBlockState
	 * p_canCreatureSpawn_1_, IBlockAccess p_canCreatureSpawn_2_, BlockPos
	 * p_canCreatureSpawn_3_, SpawnPlacementType p_canCreatureSpawn_4_) { //
	 * TODO Auto-generated method stub return
	 * super.canCreatureSpawn(p_canCreatureSpawn_1_, p_canCreatureSpawn_2_,
	 * p_canCreatureSpawn_3_, p_canCreatureSpawn_4_); }
	 * 
	 * @Override public boolean canPlaceTorchOnTop(IBlockState
	 * p_canPlaceTorchOnTop_1_, IBlockAccess p_canPlaceTorchOnTop_2_, BlockPos
	 * p_canPlaceTorchOnTop_3_) { // TODO Auto-generated method stub return
	 * super.canPlaceTorchOnTop(p_canPlaceTorchOnTop_1_,
	 * p_canPlaceTorchOnTop_2_, p_canPlaceTorchOnTop_3_); }
	 */

	/*
	 * @Override public AxisAlignedBB getBoundingBox(IBlockState
	 * p_getBoundingBox_1_, IBlockAccess p_getBoundingBox_2_, BlockPos
	 * p_getBoundingBox_3_) { // TODO Auto-generated method stub return
	 * super.getBoundingBox(p_getBoundingBox_1_, p_getBoundingBox_2_,
	 * p_getBoundingBox_3_); }
	 */

}