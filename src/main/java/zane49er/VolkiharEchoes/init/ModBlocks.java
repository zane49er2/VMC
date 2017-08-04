package zane49er.VolkiharEchoes.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zane49er.VolkiharEchoes.features.blocks.Destabilizer;
import zane49er.VolkiharEchoes.features.blocks.Rift;
import zane49er.VolkiharEchoes.features.blocks.Stabilizer;
import zane49er.VolkiharEchoes.features.blocks.Deco.WhiteObsidian;
import zane49er.VolkiharEchoes.features.blocks.Deco.WhiteObsidianBricks;
import zane49er.VolkiharEchoes.features.blocks.Deco.WhiteObsidianSmooth;
import zane49er.VolkiharEchoes.features.tileEntities.RiftRenderer;
import zane49er.VolkiharEchoes.features.tileEntities.TileEntityRift;
import zane49er.VolkiharEchoes.main.References;

public class ModBlocks {
	
	//special -------------------

	//energy sources
	public static Block rift;
	public static Block essenceOrb;//TODO makes fucused and pure essence
	public static Block wormholer;//TODO allows transport of existing rifts or essenceOrbs
	
	//rift machines
	public static Block stabilizer;
	public static Block destabilizer;
	
	public static Block gasifier;//TODO makes the plasma that flows through laser networks
	public static Block liquifier;//TODO makes the goop that powers highest lvl machines
	public static Block condensator;//TODO makes essence items without destroying rift
	
	public static Block essenceLaser;//TODO transports plasma
	public static Block essenceDuct;//TODO transports goop (limited distance)
	
	public static Block soulCrusher;//TODO makes essence out of soul gems, can explode if overloaded
	
	public static Block chargePuller;//TODO RF generator
	
	//alchemy
	public static Block alchemyFrame;//TODO outside of engine, glass and solid variant
	public static Block vaccuum;//TODO inside of engine, can contain reactants
	public static Block alchemyRune;//TODO outside of engine, most variants
	public static Block alchemyComputer;//TODO outside of engine, determines what signals to send based on presets
	
	
	//-------DECO-------DECO-------DECO-------DECO-------DECO-------DECO-------DECO-------DECO-------
	
	//white obsidian
	public static Block whiteObsidian;
	public static Block whiteObsidianBricks;
	public static Block whiteObsidianSmooth;
	public static Block whiteObsidianSlab;//TODO
	public static Block whiteObsidianStairs;//TODO
	public static Block whiteObsidianSlabBricks;//TODO
	public static Block whiteObsidianStairsBricks;//TODO
	public static Block whiteObsidianSlabSmooth;//TODO
	public static Block runicObsidan;//TODO
	
	public static void init() {
		rift = new Rift("rift");
		stabilizer = new Stabilizer("stabilizer");
		destabilizer = new Destabilizer("destabilizer");
		whiteObsidian = new WhiteObsidian("WhiteObsidian");
		whiteObsidianBricks = new WhiteObsidianBricks("WhiteObsidianBricks");
		whiteObsidianSmooth = new WhiteObsidianSmooth("WhiteObsidianSmooth");
	}

	public static void register() {
		registerBlock(rift);
		registerBlock(stabilizer);
		registerBlock(destabilizer);
		registerBlock(whiteObsidian);
		registerBlock(whiteObsidianBricks);
		registerBlock(whiteObsidianSmooth);
	}
	
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock (block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}

	public static void registerRenders() {
		//registerRender(rift);
		registerRender(stabilizer);
		registerRender(destabilizer);
		registerRender(whiteObsidian);
		registerRender(whiteObsidianBricks);
		registerRender(whiteObsidianSmooth);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRift.class, new RiftRenderer());
	}


	    
	
	
	@SideOnly(Side.CLIENT)
	public static void registerRender(Block block) {
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(References.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}
