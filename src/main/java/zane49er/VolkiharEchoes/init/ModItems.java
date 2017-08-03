package zane49er.VolkiharEchoes.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zane49er.VolkiharEchoes.features.items.RiftReader;
import zane49er.VolkiharEchoes.features.items.RiftTome;
import zane49er.VolkiharEchoes.main.References;

public class ModItems {

	public static Item essence;
	public static Item riftTome;
	public static Item riftReader;
	
	public static void init() {
		essence = new RiftReader("essence");
		riftTome = new RiftTome("rift_tome");
		riftReader = new RiftReader("rift_reader");
	}

	public static void register() {
		GameRegistry.register(essence);
		GameRegistry.register(riftTome);
		GameRegistry.register(riftReader);
	}

	public static void registerRenders() {
		registerRender(essence);
		registerRender(riftTome);
		registerRender(riftReader);
	}

	@SideOnly(Side.CLIENT)
	public static void registerRender(Item item) {
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.MODID + ":" + item.getUnlocalizedName()/*.substring(5)*/,"inventory"));
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
