package zane49er.VolkiharEchoes.features.blocks.Deco;

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

public class RunicObsidianHorizontal extends Block {

	public RunicObsidianHorizontal(String registryName) {
		super(Material.ROCK);
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		setHardness(100.0f);
		setCreativeTab(ModTabs.decorative);
	}

}