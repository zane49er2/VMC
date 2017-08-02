package zane49er.VolkiharEchoes.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zane49er.VolkiharEchoes.features.Destabilizer;
import zane49er.VolkiharEchoes.features.Rift;
import zane49er.VolkiharEchoes.features.Stabilizer;
import zane49er.VolkiharEchoes.main.References;

public class ModBlocks {
	
	public static Block rift;
	public static Block stabilizer;
	public static Block destabilizer;
	
	public static void init() {
		rift = new Rift("rift");
		stabilizer = new Stabilizer("stabilizer");
		destabilizer = new Destabilizer("destabilizer");
	}

	public static void register() {
		registerBlock(rift);
		registerBlock(stabilizer);
		registerBlock(destabilizer);
	}
	
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock (block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}

	public static void registerRenders() {
		registerRender(rift);
		registerRender(stabilizer);
		registerRender(destabilizer);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRender(Block block) {
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(References.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}
