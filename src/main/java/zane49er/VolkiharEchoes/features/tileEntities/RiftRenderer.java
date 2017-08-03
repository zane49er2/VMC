package zane49er.VolkiharEchoes.features.tileEntities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;

public class RiftRenderer extends TileEntitySpecialRenderer<TileEntityRift> {
	
	
	@Override
	public void renderTileEntityAt(TileEntityRift te, double x, double y, double z, float partialTicks, int destroyStage) {
		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		GlStateManager.pushMatrix(); {

			int r = te.r-1;
			int g = te.g-1;
			int b = te.b-1;
			
			float PBX = OpenGlHelper.lastBrightnessX;
			float PBY = OpenGlHelper.lastBrightnessX;
			int PBT = OpenGlHelper.lightmapTexUnit;
			
			GlStateManager.translate(x, y, z);
			//GlStateManager.rotate(90F, 1.0F, 0.0F, 0.0F);
			//GlStateManager.scale(0.25F, 0.25F, 0.25F);
			
			Tessellator wrt = Tessellator.getInstance();
	        VertexBuffer wr = wrt.getBuffer();
	        
	        GlStateManager.disableLighting();
	        GlStateManager.disableTexture2D();
	        OpenGlHelper.setLightmapTextureCoords(1, 240, 240);

	        wr.begin(7, DefaultVertexFormats.POSITION_COLOR);
			wr.pos(0, 0, 0).color(r, b, g, 255).endVertex();
			wr.pos(1, 0, 0).color(r, b, g, 255).endVertex();
			wr.pos(1, 1, 0).color(r, b, g, 255).endVertex();
			wr.pos(0, 1, 0).color(r, b, g, 255).endVertex();

			wrt.draw();
			
	        wr.begin(7, DefaultVertexFormats.POSITION_COLOR);
			wr.pos(0, 0, 0).color(r, b, g, 255).endVertex();
			wr.pos(0, 1, 0).color(r, b, g, 255).endVertex();
			wr.pos(1, 1, 0).color(r, b, g, 255).endVertex();
			wr.pos(1, 0, 0).color(r, b, g, 255).endVertex();
			
			wrt.draw();
			
	        GlStateManager.enableLighting();
	        GlStateManager.enableTexture2D();
	        OpenGlHelper.setLightmapTextureCoords(PBT, PBX, PBY);
	        
		}
		GlStateManager.popMatrix();
	}

	private void branch(int x, int y, int z, int r, int g, int b, int Br, int h, VertexBuffer wr, Tessellator wrt){
		wr.begin(7, DefaultVertexFormats.POSITION_COLOR);
		wr.pos(0, 0, 0).color(r, b, g, 255).endVertex();
		wr.pos(1, 0, 0).color(r, b, g, 255).endVertex();
		wr.pos(1, 1, 0).color(r, b, g, 255).endVertex();
		wrt.draw();
	}
	
}