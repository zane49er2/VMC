package zane49er.VolkiharEchoes.features.GUIs.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;

import zane49er.VolkiharEchoes.main.References;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
	private ArrayList<BookText> bText = new ArrayList<BookText>();
	private ArrayList<BookDetail> bLines = new ArrayList<BookDetail>();

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();

		// scrolling
		if (Mouse.isButtonDown(0)) {
			if (scrolling != 1) {
				for (int i = 0; i < bItems.size(); i++) {
					if (bItems.get(i).hovering) {
						pageID = bItems.get(i).link;
						try {
							refresh();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

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
					b.rc += selSpeed * (b.rs - b.rc);
					b.gc += selSpeed * (b.gs - b.gc);
					b.bc += selSpeed * (b.bs - b.bc);
				} else {
					b.hovering = false;
					b.rc += selSpeed * (b.rn - b.rc);
					b.gc += selSpeed * (b.gn - b.gc);
					b.bc += selSpeed * (b.bn - b.bc);
				}

				this.mc.getTextureManager().bindTexture(texture);

				GlStateManager.enableBlend();
				GlStateManager.translate(Tx, Ty, 0);
				GlStateManager.color(b.rc, b.gc, b.bc, 1.0F);
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
					//System.out.println("BOOM!");
					for (int j = 0; j < (random.nextInt(100) + 15) * b.scale; j++) {
						BookSymbol s = new BookSymbol();
						s.u = (random.nextInt(5) * 16) + 170;
						s.v = random.nextInt(3) * 16;
						s.xv = (xScroll - pxScroll) * 10 + random.nextInt(50) - 25;
						s.yv = (yScroll - pyScroll) * 10 + random.nextInt(50) - 25;

						s.x = Px + random.nextInt((int) (36 * b.scale));
						s.y = Py + random.nextInt((int) (36 * b.scale));

						s.r = b.rc;
						s.g = b.gc;
						s.b = b.bc;
						s.age = 1;
						s.noFadeIn = true;
						particles.add(s);
					}
				}
			}
			GlStateManager.popMatrix();
			// tooltip
			if (b.hovering) {
				// List<String> j = new ArrayList<String>();
				// j.add(b.name);
				GlStateManager.pushMatrix();
				drawHoveringText(b.text, mouseX, mouseY, fontRendererObj);
				GlStateManager.popMatrix();
			}

			// update previous scroll
			this.pxScroll = xScroll;
			this.pyScroll = yScroll;

		}
		// text
		for (int i = 0; i < bText.size(); i++) {
			BookText b = bText.get(i);
			int Tx = (int) (b.x) + xScroll;
			int Ty = (int) (b.y) + yScroll;
			{
				for (int j = 0; j < b.text.size(); j++) {
					for (int k = 0; k < b.text.get(j).length(); k++) {
						int cx = (int) (Tx + (10 * k * b.scale));
						int cy = (int) (Ty + (15 * j * b.scale));
						GlStateManager.pushMatrix();
						GlStateManager.translate(cx, cy, 0);
						GlStateManager.scale(b.scale, b.scale, b.scale);
						if (cx > left && cy > top && cx < left + GUIWidth && cy < top + GUIHeight) drawString(fontRendererObj, String.valueOf(b.text.get(j).charAt(k)), 0, 0, 0xFFFFFF);
						GlStateManager.popMatrix();
					}
				}
			}
		}
		// lines
		for (int i = 0; i < bLines.size(); i++) {
			BookDetail b = bLines.get(i);
			int cx = (int) ((b.x + xScroll) * b.scale);
			int cy = (int) ((b.y + yScroll) * b.scale);
			if (cx > left && cy > top && cx < left + GUIWidth && cy < top + GUIHeight) {
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate((b.x + xScroll), (b.y + yScroll), 0);
					GlStateManager.rotate(b.rot, 1, 0, 0);
					GlStateManager.scale(b.scale, b.scale, b.scale);

					this.mc.getTextureManager().bindTexture(b.texture);
					drawTexturedModalRect(0, 0, b.u, b.v, b.w, b.h);
				}
				GlStateManager.popMatrix();
			}
		}

	}

	public void initGui() {
		// this.buttonList.add(this.home = new GuiButton(0, this.width / 2 -
		// 100, this.height / 2 - 24, "home"));
		// this.buttonList.add(this.home = new GuiButton(0, 0, 0, 40, 20,
		// "home"));
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
		// explode old page
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

					s.r = b.rn;
					s.g = b.gn;
					s.b = b.bn;
					s.disappearing = true;
					particles.add(s);
					s.age = 50;
				}
			}
		}
		bItems.clear();
		bText.clear();
		bLines.clear();

		// load new one
		String resourceName = "assets/vmc/BookPages/" + pageID + ".json";
		BufferedReader pageScan = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(resourceName), "UTF-8"));
		JsonObject pageData = new Gson().fromJson(pageScan, JsonObject.class);

		// name
		pageName = pageData.get("name").getAsString();

		// items
		int i = 0;
		while (pageData.has("item" + i)) {
			JsonObject c = pageData.get("item" + i).getAsJsonObject();
			JsonObject col;
			BookItem b = new BookItem();
			b.x = c.get("x").getAsInt();
			b.y = c.get("y").getAsInt();
			b.item = Item.getByNameOrId(c.get("Image").getAsString());
			b.scale = c.get("scale").getAsFloat();
			b.link = c.get("link").getAsString();
			b.bgType = c.get("bgType").getAsInt();
			// colors
			col = c.get("color").getAsJsonObject();
			b.rc = col.get("r").getAsInt();
			b.gc = col.get("g").getAsInt();
			b.bc = col.get("b").getAsInt();
			col = c.get("returnColor").getAsJsonObject();
			b.rn = col.get("r").getAsInt();
			b.gn = col.get("g").getAsInt();
			b.bn = col.get("b").getAsInt();
			col = c.get("selectorColor").getAsJsonObject();
			b.rs = col.get("r").getAsInt();
			b.gs = col.get("g").getAsInt();
			b.bs = col.get("b").getAsInt();
			// text
			JsonObject t = c.get("text").getAsJsonObject();
			int j = 0;
			while (t.has("line" + j)) {
				b.text.add(t.get("line" + j).getAsString());
				j++;
			}
			bItems.add(b);
			i++;
		}
		// text
		i = 0;
		while (pageData.has("text" + i)) {
			JsonObject c = pageData.get("text" + i).getAsJsonObject();
			JsonObject col = c.get("color").getAsJsonObject();
			BookText b = new BookText();
			b.x = c.get("x").getAsInt();
			b.y = c.get("y").getAsInt();
			b.scale = c.get("scale").getAsFloat();
			// colors
			b.r = col.get("r").getAsFloat();
			b.g = col.get("g").getAsFloat();
			b.b = col.get("b").getAsFloat();
			// contents
			JsonObject t = c.get("text").getAsJsonObject();
			int j = 0;
			// System.out.println(t.has("line1"));
			while (t.has("line" + j)) {
				b.text.add(t.get("line" + j).getAsString());
				j++;
			}
			// System.out.println(b.text);
			bText.add(b);
			i++;
		}
		// lines
		i = 0;
		while (pageData.has("line" + i)) {
			JsonObject c = pageData.get("line" + i).getAsJsonObject();
			JsonObject segs = c.get("segments").getAsJsonObject();
			float scale = c.get("scale").getAsFloat();
			int j = 0;
			boolean first = true;
			int cx = 0;
			int cy = 0;
			while (segs.has("s" + j)) {
				JsonObject dat = segs.get("s" + j).getAsJsonObject();
				for (int k = 0; k < dat.get("len").getAsInt(); k++) {
					BookDetail b = new BookDetail();
					b.scale = scale;
					b.texture = new ResourceLocation(References.MODID, "textures/gui/RiftTomeGui.png");
					b.u = 170;
					switch (dat.get("rot").getAsInt()) {
					case 0:
						// up
						if (!first) {
							cx += 0;
							cy += 12;
						} else first = false;
						b.x = cx;
						b.y = cy;
						b.v = 64;
						b.w = 8;
						b.h = 12;
						b.rot = 0;
						break;
					case 1:
						// up right
						if (!first) {
							cx += 8;
							cy += 8;
						} else first = false;
						b.x = cx;
						b.y = cy;
						b.v = 76;
						b.w = 11;
						b.h = 11;
						b.rot = 0;
						break;
					case 2:
						// right
						if (!first) {
							cx += 12;
							cy += 0;
						} else first = false;
						b.x = cx;
						b.y = cy;
						b.v = 64;
						b.w = 8;
						b.h = 12;
						b.rot = 90;
						break;
					case 3:
						// down right
						if (!first) {
							cx += 8;
							cy -= 8;
						} else first = false;
						b.x = cx;
						b.y = cy;
						b.v = 76;
						b.w = 11;
						b.h = 11;
						b.rot = 90;
						break;
					case 4:
						// down
						if (!first) {
							cx += 0;
							cy -= 12;
						} else first = false;
						b.x = cx;
						b.y = cy;
						b.v = 64;
						b.w = 8;
						b.h = 12;
						b.rot = 180;
						break;
					case 5:
						// down left
						if (!first) {
							cx -= 8;
							cy -= 8;
						} else first = false;
						b.x = cx;
						b.y = cy;
						b.v = 76;
						b.w = 11;
						b.h = 11;
						b.rot = 180;
						break;
					case 6:
						// left
						if (!first) {
							cx -= 12;
							cy += 0;
						} else first = false;
						b.x = cx;
						b.y = cy;
						b.v = 64;
						b.w = 8;
						b.h = 12;
						b.rot = 270;
						break;
					case 7:
						// up left
						if (!first) {
							cx -= 8;
							cy += 8;
						} else first = false;
						b.x = cx;
						b.y = cy;
						b.v = 76;
						b.w = 11;
						b.h = 11;
						b.rot = 270;
						break;
					}

					bLines.add(b);
				}
				j++;
			}
			i++;
		}

		// reset cam
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
