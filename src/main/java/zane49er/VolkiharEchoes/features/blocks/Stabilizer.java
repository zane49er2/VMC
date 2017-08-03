package zane49er.VolkiharEchoes.features.blocks;

import java.util.List;
import java.util.Random;

import zane49er.VolkiharEchoes.init.ModItems;
import zane49er.VolkiharEchoes.init.ModTabs;
import zane49er.VolkiharEchoes.main.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Stabilizer extends Block {

	public Stabilizer(String registryName) {
		super(Material.PISTON);
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		setLightLevel(0.6f);
		setLightOpacity(0);
		setHardness(3.0f);
		setCreativeTab(ModTabs.useful);
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

}