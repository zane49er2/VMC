package zane49er.VolkiharEchoes.features.GUIs.book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;

import zane49er.VolkiharEchoes.init.ModItems;
import zane49er.VolkiharEchoes.main.References;

public class GUIBookLvl1 extends GuiScreen {

	// global
	private Random random = new Random();
	private GuiButton home;// return to top page
	private GuiButton bookmark;// set start page (when book is next opened)
	private GuiButton settings;
	// private GuiButton b;
	private int xScroll = width / 2;
	private int yScroll = height / 2;
	private int pMouseX = 0;
	private int pMouseY = 0;
	private int pxScroll = 0;
	private int pyScroll = 0;
	private String pageID = "home";
	private String pageName;
	private int scrolling;

	private ArrayList<BookSymbol> particles = new ArrayList<BookSymbol>();

	ResourceLocation texture = new ResourceLocation(References.MODID, "textures/gui/RiftTomeGui.png");
	int GUIWidth = 170;
	int GUIHeight = 220;
	int left;
	int top;

	// page info
	private ArrayList<BookItem> bItems = new ArrayList<BookItem>();
	BufferedReader pageData;

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

		drawString(fontRendererObj, pageName, left + 10, top + 10, 0x00FFAA);

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
					if (s.age < 50 && !(s.noFadeIn && !s.disappearing)) GlStateManager.color(s.r, s.g, s.b, (float) s.age / 100);
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
			int Tx = (int) (b.x) + xScroll;
			int Ty = (int) (b.y) + yScroll;
			float selSpeed = 0.05f;

			// draw
			GlStateManager.pushMatrix();
			if (Tx >= left && Ty >= top && Tx <= left + GUIWidth - 36 * b.scale && (float) Ty <= top + GUIHeight - 36 * b.scale) {
				// selection detection
				if (mouseX > Tx && mouseY > Ty && mouseX < Tx + 36 * b.scale && mouseY < Ty + 36 * b.scale) {
					b.hovering = true;
					b.r += selSpeed * (b.rSel - b.r);
					b.g += selSpeed * (b.gSel - b.g);
					b.b += selSpeed * (b.bSel - b.b);
				} else {
					b.hovering = false;
					b.r += selSpeed * (b.rn - b.r);
					b.g += selSpeed * (b.gn - b.g);
					b.b += selSpeed * (b.bn - b.b);
				}

				this.mc.getTextureManager().bindTexture(texture);

				GlStateManager.enableBlend();
				GlStateManager.translate(Tx, Ty, 0);
				GlStateManager.color(b.r, b.g, b.b, 1.0F);
				float borderSize = 1f;
				switch (b.bgType) {
				case 0:
					borderSize = 2f;
					break;
				case 1:
					borderSize = 1.3f;
					break;
				case 2:
					borderSize = 1f;
					break;
				case 3:
					borderSize = 1.5f;
					break;
				}
				GlStateManager.disableLighting();
				GlStateManager.enableCull();
				GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

				GlStateManager.scale(b.scale, b.scale, b.scale);
				this.drawTexturedModalRect(0, 0, 36 * b.bgType, GUIHeight, 36, 36);


				GlStateManager.translate(36 / 2, 36 / 2, 0);
				GlStateManager.scale(borderSize, borderSize, borderSize);
				GlStateManager.translate(-16 / 2, -16 / 2, 0);

				this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(b.item), 0, 0);


			} else {
				b.hovering = false;
				// explode		
				int Px = (int) (b.x) + pxScroll;
				int Py = (int) (b.y) + pyScroll;

				if (Px >= left && Py >= top && Px <= left + GUIWidth - 36 * b.scale && (float) Py <= top + GUIHeight - 36 * b.scale) {
					for (int j = 0; j < (random.nextInt(100) + 15) * b.scale; j++) {
						BookSymbol s = new BookSymbol();
						s.u = (random.nextInt(5) * 16) + 170;
						s.v = random.nextInt(3) * 16;
						s.xv = (xScroll - pxScroll) * 10 + random.nextInt(50) - 25;
						s.yv = (yScroll - pyScroll) * 10 + random.nextInt(50) - 25;

						s.x = Px + random.nextInt((int) (36 * b.scale));
						s.y = Py + random.nextInt((int) (36 * b.scale));

						s.r = b.r;
						s.g = b.g;
						s.b = b.b;
						s.age = 1;
						s.noFadeIn = true;
						particles.add(s);
					}
				}
			}
			GlStateManager.popMatrix();
			// tooltip
			if (b.hovering) {
				List<String> j = new ArrayList<String>();
				j.add(b.name);
				GlStateManager.pushMatrix();
				drawHoveringText(j, mouseX, mouseY, fontRendererObj);
				GlStateManager.popMatrix();
			}

			// update previous scroll
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
		try {
			refresh();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void refresh() throws IOException {
		// delete old page
		for (int i = 0; i < bItems.size(); i++) {
			BookItem b = bItems.get(i);
			int Px = (int) (b.x) + pxScroll;
			int Py = (int) (b.y) + pyScroll;
			if (Px >= left && Py >= top && Px <= left + GUIWidth - 36 * b.scale && (float) Py <= top + GUIHeight - 36 * b.scale) {
				for (int j = 0; j < (random.nextInt(100) + 15) * b.scale; j++) {
					BookSymbol s = new BookSymbol();
					s.u = (random.nextInt(5) * 16) + 170;
					s.v = random.nextInt(3) * 16;
					s.xv = (xScroll - pxScroll) * 10 + random.nextInt(50) - 25;
					s.yv = (yScroll - pyScroll) * 10 + random.nextInt(50) - 25;

					s.x = Px + random.nextInt((int) (36 * b.scale));
					s.y = Py + random.nextInt((int) (36 * b.scale));

					s.r = b.r;
					s.g = b.g;
					s.b = b.b;
					s.disappearing = true;
					particles.add(s);
					s.age = 50;
				}
			}
		}
		bItems.clear();

		// load new one
		pageData = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("assets/vmc/BookPages/"+pageID+".txt"), "UTF-8"));

		pageName = pageData.readLine();

		while (pageData.ready()) {
			//pageData.readLine();//skip one
			BookItem b = new BookItem();
			b.x = Integer.parseInt(pageData.readLine());
			b.y = Integer.parseInt(pageData.readLine());
			b.item = Item.getByNameOrId(pageData.readLine());
			b.scale = Float.parseFloat(pageData.readLine());
			b.link = pageData.readLine();
			b.bgType = Integer.parseInt(pageData.readLine());
			b.r = Float.parseFloat(pageData.readLine());
			b.g = Float.parseFloat(pageData.readLine());
			b.b = Float.parseFloat(pageData.readLine());
			b.rn = Float.parseFloat(pageData.readLine());
			b.gn = Float.parseFloat(pageData.readLine());
			b.bn = Float.parseFloat(pageData.readLine());
			b.rSel = Float.parseFloat(pageData.readLine());
			b.gSel = Float.parseFloat(pageData.readLine());
			b.bSel = Float.parseFloat(pageData.readLine());
			b.name = pageData.readLine();
			bItems.add(b);
		}
		
		//reset cam
		xScroll = width / 2;
		yScroll = height / 2;

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
