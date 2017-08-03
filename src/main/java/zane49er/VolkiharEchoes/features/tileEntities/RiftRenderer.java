package zane49er.VolkiharEchoes.features.tileEntities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;

public class RiftRenderer extends TileEntitySpecialRenderer {
	
	int r = 200;
	int g = 200;
	int b = 200;
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTick, int destroyStage) {
		GlStateManager.pushMatrix(); {
			GlStateManager.translate(x + 0.5, y + 0.066, z + 0.75);
			//GlStateManager.rotate(90F, 1.0F, 0.0F, 0.0F);
			//GlStateManager.scale(0.25F, 0.25F, 0.25F);
			GlStateManager.color(r, g, b);
	        GlStateManager.disableLighting();
			Tessellator wrt = Tessellator.getInstance();
	        VertexBuffer wr = wrt.getBuffer();
	        wr.begin(7, DefaultVertexFormats.POSITION_COLOR);
	        wr.color(r, g, b, 255);
			wr.pos(x, y, z);
			wr.pos(x+1, y, z);
			wr.pos(x+1, y+1, z);
			wr.pos(x, y+1, z);
			wrt.draw();
		}
		GlStateManager.popMatrix();
	}
}
