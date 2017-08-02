package com.zane49er.MagicalRifts.features;

import java.util.Random;

import com.zane49er.MagicalRifts.main.MagicalRifts;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Rift extends Block {

	public Rift(Material mat) {
		super(mat);
		this.setCreativeTab(Registry.RiftTab);
		this.setTickRandomly(true);
		this.setLightLevel(12);
		this.setLightOpacity(0);
	}

	@Override
	public void registerBlockIcons(IIconRegister reg) {
		this.blockIcon = reg.registerIcon("zanesmod:Rift2");
	}

	public Item getItemDropped() {
		return Registry.Essence;
	}

	public int quantityDropped(Random rand) {
		return 1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		float f1 = (float) x + 0.5F;
		float f2 = (float) y + 0.5F;
		float f3 = (float) z + 0.5F;
		double fxm = random.nextDouble();
		double fym = random.nextDouble();
		double fzm = random.nextDouble();

		//world.spawnParticle("magicCrit", (double) f1, (double) f2, (double) f3, fxm, fym, fzm);
		//world.spawnParticle("magicCrit", (double) f1, (double) f2, (double) f3, fxm, fym, fzm);
		//world.spawnParticle("magicCrit", (double) f1, (double) f2, (double) f3, fxm, fym, fzm);
		//world.spawnParticle("magicCrit", (double) f1, (double) f2, (double) f3, fxm, fym, fzm);
		//world.spawnParticle("magicCrit", (double) f1, (double) f2, (double) f3, fxm, fym, fzm);
	}
}
