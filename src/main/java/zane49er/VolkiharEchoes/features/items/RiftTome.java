package zane49er.VolkiharEchoes.features.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zane49er.VolkiharEchoes.features.GUIs.book.GUIBookLvl1;
import zane49er.VolkiharEchoes.init.ModGUIs;
import zane49er.VolkiharEchoes.init.ModTabs;
import zane49er.VolkiharEchoes.main.VolkiharEchoes;

public class RiftTome extends Item {

	public RiftTome(String registryName) {
		setRegistryName(registryName);
		setUnlocalizedName(getRegistryName().toString());
		setMaxStackSize(1);
		setCreativeTab(ModTabs.useful);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			playerIn.openGui(VolkiharEchoes.instance, ModGUIs.BOOK_LVL_1_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ());
		} else {
			Minecraft.getMinecraft().displayGuiScreen(new GUIBookLvl1());
		}
		return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}

}
