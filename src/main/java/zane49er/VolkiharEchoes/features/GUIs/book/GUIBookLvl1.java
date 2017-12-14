package zane49er.VolkiharEchoes.features.GUIs.book;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import zane49er.VolkiharEchoes.init.ModItems;
import zane49er.VolkiharEchoes.main.References;

public class GUIBookLvl1 extends GuiScreen {

	// global
	private Random random = new Random();
	private GuiButton home;
	// private GuiButton b;
	private int xScroll = 0;
	private int yScroll = 0;
	private int pMouseX = 0;
	private int pMouseY = 0;
	private int pxScroll = 0;
	private int pyScroll = 0;
	private String pageID = "getting_started";
	private int scrolling;

	private ArrayList<BookSymbol> particles = new ArrayList<BookSymbol>();

	ResourceLocation texture = new ResourceLocation(References.MODID, "textures/gui/RiftTomeGui.png");
	int GUIWidth = 170;
	int GUIHeight = 220;
	int left;
	int top;

	// page info
	private String page = "getting started";
	private ArrayList<BookItem> bItems = new ArrayList<BookItem>();

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();

		// scrolling
		if (Mouse.isButtonDown(0)) {

			if ((this.scrolling == 0 || this.scrolling == 1) && mouseX >= left && mouseX < left + GUIWidth && mouseY >= top && mouseY < top + GUIHeight) {
				if (this.scrolling == 0) {
					this.scrolling = 1;
				} else {
					xScroll += (double) ((float) (mouseX - pMouseX));
					yScroll += (double) ((float) (mouseY - pMouseY));
				}
				this.pMouseX = mouseX;
				this.pMouseY = mouseY;
			}
		} else {
			this.scrolling = 0;
		}

		// rendering
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		drawTexturedModalRect(left, top, 0, 0, GUIWidth, GUIHeight);

		drawString(fontRendererObj, page, left + 10, top + 10, 0x00FFAA);

		super.drawScreen(mouseX, mouseY, partialTicks);

		// flying symbols
		for (int i = 0; i < particles.size(); i++) {
			BookSymbol s = particles.get(i);
			if (s.age == 0) particles.remove(i);
			else {
				GlStateManager.pushMatrix();
				{
					GlStateManager.enableAlpha();
					GlStateManager.enableBlend();
					Minecraft.getMinecraft().renderEngine.bindTexture(texture);
					if (s.age < 50&&!(s.noFadeIn&&!s.disappearing)) GlStateManager.color(s.r, s.g, s.b, (float) s.age / 100);
					else GlStateManager.color(s.r, s.g, s.b, 0.5F);
					drawTexturedModalRect(s.x, s.y, s.u, s.v, 16, 16);
				}
				GlStateManager.popMatrix();
				if (s.x < left || s.x > left + GUIWidth) {
					if (s.age > 50) {
						s.age = 50;
						s.disappearing = true;
					}

					if (s.age > 50) s.age = 50;
				}
				if (s.y < top || s.y > top + GUIHeight) {

					if (s.age > 50) {
						s.age = 50;
						s.disappearing = true;
					}
				}
				s.update();
			}
		}

		// spawn symbols
		if (random.nextInt(50) == 1) {
			BookSymbol s = new BookSymbol();
			s.x = random.nextInt(GUIWidth) + left;
			s.y = random.nextInt(GUIHeight) + top;
			s.r = 0;
			s.g = 0.5f;
			s.b = 1;
			s.u = (random.nextInt(5) * 16) + 170;
			s.v = random.nextInt(3) * 16;
			s.xv = random.nextInt(100) - 50;
			s.yv = random.nextInt(100) - 50;
			s.age = 1;
			particles.add(s);
		}

		// Page links/items
		for (int i = 0; i < bItems.size(); i++) {
			BookItem b = bItems.get(i);
			GlStateManager.pushMatrix();
			/*
			 * GlStateManager.translate(b.x - scrollX, b.y - scrollY, 0);
			 * GlStateManager.scale(b.scale, b.scale, b.scale);
			 * mc.getRenderItem().renderItemIntoGUI(new ItemStack(b.item), 0,
			 * 0); GlStateManager.popMatrix();
			 */

			int Tx = (int) (b.x) + xScroll;
			int Ty = (int) (b.y) + yScroll;
			
			//draw
			if (Tx >= left && Ty >= top && Tx <= left + GUIWidth && (float) Ty <= top + GUIHeight) {

				this.mc.getTextureManager().bindTexture(texture);

				GlStateManager.enableBlend();
				GlStateManager.translate(Tx, Ty, 0);
				GlStateManager.color(b.r, b.g, b.b, 1.0F);
				float borderSize=1f;
				switch(b.bgType){
				case 0:
					borderSize=2f;
					break;
				case 1:
					borderSize=1.3f;
					break;
				case 2:
					borderSize=1f;
					break;
				case 3:
					borderSize=1.5f;
					break;
				}
				
				GlStateManager.scale(b.scale, b.scale, b.scale);
				this.drawTexturedModalRect(0, 0, 36 * b.bgType, GUIHeight, 36, 36);

				GlStateManager.disableLighting();
				GlStateManager.enableCull();
				
				GlStateManager.translate(36 / 2, 36 / 2, 0);
				GlStateManager.scale(borderSize, borderSize, borderSize);
				GlStateManager.translate(-16 / 2, -16 / 2, 0);
				
				this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(b.item), 0, 0);
				GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
				GlStateManager.disableLighting();

			} else {
				//explode
				int Px = (int) (b.x) + pxScroll;
				int Py = (int) (b.y) + pyScroll;

				if (Px >= left && Py >= top && Px <= left + GUIWidth && (float) Py <= top + GUIHeight) {
					for (int j = 0; j < random.nextInt(50) + 5; j++) {
						BookSymbol s = new BookSymbol();
						s.x = Px;
						s.y = Py;
						s.u = (random.nextInt(5) * 16) + 170;
						s.v = random.nextInt(3) * 16;
						if (Px < left + 5) s.xv = -random.nextInt(100);
						if (Px > left + GUIWidth - 5) s.xv = random.nextInt(100);
						if (Py < top + 5) s.yv = -random.nextInt(100);
						if (Py > top + GUIHeight - 5) s.yv = random.nextInt(100);
						s.r = 0;
						s.g = 1;
						s.b = 0.5f;
						s.age = 1;
						s.noFadeIn=true;
						particles.add(s);
					}
				}
			}
			GlStateManager.popMatrix();

			this.pxScroll = xScroll;
			this.pyScroll = yScroll;

		}

	}

	public void initGui() {
		// this.buttonList.add(this.home = new GuiButton(0, this.width / 2 -
		// 100, this.height / 2 - 24, "home"));
		this.buttonList.add(this.home = new GuiButton(0, 0, 0, 40, 20, "home"));
		// this.buttonList.add(this.b = new GuiButton(1, this.width / 2 - 100,
		// this.height / 2 + 4, "This is button b"));
		left = (width / 2) - (GUIWidth / 2);
		top = (height / 2) - (GUIHeight / 2);

		BookItem b = new BookItem();
		// b.x = random.nextInt(GUIWidth) + left;
		// b.y = random.nextInt(GUIHeight) + top;
		b.x = left;
		b.y = top;
		b.item = ModItems.essence;
		b.scale = 2f;
		b.link = "Getting_started";
		b.bgType =3;
		b.r=0;
		b.g=1;
		b.b=0.5f;
		bItems.add(b);

	}

	void refresh() {
		// place new page
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button == this.home) {
			pageID = "home";
			refresh();
			// Main.packetHandler.sendToServer(...);
			// this.mc.displayGuiScreen(null);
			// if (this.mc.currentScreen == null) this.mc.setIngameFocus();
		}
		/*
		 * if (button == this.b) { // Main.packetHandler.sendToServer(...);
		 * this.mc.displayGuiScreen(null); if (this.mc.currentScreen == null)
		 * this.mc.setIngameFocus(); }
		 */
	}
}
