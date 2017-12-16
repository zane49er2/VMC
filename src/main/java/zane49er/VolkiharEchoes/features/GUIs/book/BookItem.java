package zane49er.VolkiharEchoes.features.GUIs.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.item.Item;

public class BookItem {

	int x;
	int y;
	Item item;
	float scale;
	String link;
	int bgType;
	float rc;
	float gc;
	float bc;
	float rn;
	float gn;
	float bn;
	float rs;
	float gs;
	float bs;
	List<String> text = new ArrayList<String>();
	
	boolean hovering;
	boolean enabled;
	String parent;

	// 0:feature (small segment of magic)
	// 1:detail (further explaining of feature)
	// 2:branch (main segment of magic)
	// 3:requirement (in dead ends)
	// 4:none (tooltip, structure, etc.)

	
}
