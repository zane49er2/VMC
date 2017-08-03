package zane49er.VolkiharEchoes.init;

import zane49er.VolkiharEchoes.features.tileEntities.TileEntityRift;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
    public static void init() {
        GameRegistry.registerTileEntity(TileEntityRift.class, "Rift_Tile_Entity");
    }
    
}
