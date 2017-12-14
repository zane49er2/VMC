package zane49er.VolkiharEchoes.features.GUIs.book;

import java.util.Random;

public class BookSymbol {

	Random random = new Random();
	float x;
	float y;
	float xv;
	float yv;
	int u;
	int v;
	int age;
	boolean disappearing;
	boolean noFadeIn;
	float r;
	float g;
	float b;

	void update() {
		//move
		x += xv/100;
		y += yv/100;
		xv+= (random.nextInt(600)-300)/100;
		yv+= (random.nextInt(600)-300)/100;
		
		//age
		if (disappearing) {
			age--;
		} else {
			age++;
			if (age > 600){
				disappearing = true;
				age = 50;
			}
		}
	}
}
