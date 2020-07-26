package riso;

import java.util.ArrayList;
import java.util.HashMap;
import processing.core.*;
import processing.awt.PGraphicsJava2D;

/**
 * 
 * Helpful notes about subclassing PGraphics:
 * https://forum.processing.org/two/discussion/16314/pshape-inside-a-class-or-extend-pshape#Item_4
 * 
 * https://discourse.processing.org/t/is-it-possible-to-extend-the-classes-pgraphics-pgraphics3d/1593
 * 
 * (the tag example followed by the name of an example included in folder
 * 'examples' will automatically include the example in the javadoc.)
 *
 * @example Hello
 */

public class Riso extends PGraphicsJava2D {

	public final static String VERSION = "##library.prettyVersion##";

	public static int BLACK = 0x000000;
	public static int BURGUNDY = 0x914e72;
	public static int BLUE = 0x0078bf;
	public static int GREEN = 0x00a95c;
	public static int MEDIUMBLUE = 0x3255a4;
	public static int BRIGHTRED = 0xf15060;
	public static int RISOFEDERALBLUE = 0x3d5588;
	public static int PURPLE = 0x765ba7;
	public static int TEAL = 0x00838a;
	public static int FLATGOLD = 0xbb8b41;
	public static int HUNTERGREEN = 0x407060;
	public static int RED = 0xff665e;
	public static int BROWN = 0x925f52;
	public static int YELLOW = 0xffe800;
	public static int MARINERED = 0xd2515e;
	public static int ORANGE = 0xff6c2f;
	public static int FLUORESCENTPINK = 0xff48b0;
	public static int LIGHTGRAY = 0x88898a;
	public static int METALLICGOLD = 0xac936e;
	public static int CRIMSON = 0xe45d50;
	public static int FLUORESCENTORANGE = 0xff7477;
	public static int CORNFLOWER = 0x62a8e5;
	public static int SKYBLUE = 0x4982cf;
	public static int SEABLUE = 0x0074a2;
	public static int LAKE = 0x235ba8;
	public static int INDIGO = 0x484d7a;
	public static int MIDNIGHT = 0x435060;
	public static int MIST = 0xd5e4c0;
	public static int GRANITE = 0xa5aaa8;
	public static int CHARCOAL = 0x70747c;
	public static int SMOKYTEAL = 0x5f8289;
	public static int STEEL = 0x375e77;
	public static int SLATE = 0x5e695e;
	public static int TURQUOISE = 0x00aa93;
	public static int EMERALD = 0x19975d;
	public static int GRASS = 0x397e58;
	public static int FOREST = 0x516e5a;
	public static int SPRUCE = 0x4a635d;
	public static int MOSS = 0x68724d;
	public static int SEAFOAM = 0x62c2b1;
	public static int KELLYGREEN = 0x67b346;
	public static int LIGHTTEAL = 0x009da5;
	public static int IVY = 0x169b62;
	public static int PINE = 0x237e74;
	public static int LAGOON = 0x2f6165;
	public static int VIOLET = 0x9d7ad2;
	public static int ORCHID = 0xaa60bf;
	public static int PLUM = 0x845991;
	public static int RAISIN = 0x775d7a;
	public static int GRAPE = 0x6c5d80;
	public static int SCARLET = 0xf65058;
	public static int TOMATO = 0xd2515e;
	public static int CRANBERRY = 0xd1517a;
	public static int MAROON = 0x9e4c6e;
	public static int RASPBERRYRED = 0xd1517a;
	public static int BRICK = 0xa75154;
	public static int LIGHTLIME = 0xe3ed55;
	public static int SUNFLOWER = 0xffb511;
	public static int MELON = 0xffae3b;
	public static int APRICOT = 0xf6a04d;
	public static int PAPRIKA = 0xee7f4b;
	public static int PUMPKIN = 0xff6f4c;
	public static int BRIGHTOLIVEGREEN = 0xb49f29;
	public static int BRIGHTGOLD = 0xba8032;
	public static int COPPER = 0xbd6439;
	public static int MAHOGANY = 0x8e595a;
	public static int BISQUE = 0xf2cdcf;
	public static int BUBBLEGUM = 0xf984ca;
	public static int LIGHTMAUVE = 0xe6b5c9;
	public static int DARKMAUVE = 0xbd8ca6;
	public static int WINE = 0x914e72;
	public static int GRAY = 0x928d88;
	public static int CORAL = 0xff8e91;
	public static int WHITE = 0xffffff;
	public static int AQUA = 0x5ec8e5;
	public static int MINT = 0x82d8d5;
	public static int CLEARMEDIUM = 0xf2f2f2;
	public static int FLUORESCENTYELLOW = 0xffe916;
	public static int FLUORESCENTRED = 0xff4c65;
	public static int FLUORESCENTGREEN = 0x44d62c;

	public final static HashMap<Integer, String> RISOCOLORS;

	static {
		RISOCOLORS = new HashMap<Integer, String>();

		RISOCOLORS.put(0x000000, "BLACK");
		RISOCOLORS.put(0x914e72, "BURGUNDY");
		RISOCOLORS.put(0x0078bf, "BLUE");
		RISOCOLORS.put(0x00a95c, "GREEN");
		RISOCOLORS.put(0x3255a4, "MEDIUMBLUE");
		RISOCOLORS.put(0xf15060, "BRIGHTRED");
		RISOCOLORS.put(0x3d5588, "RISOFEDERALBLUE");
		RISOCOLORS.put(0x765ba7, "PURPLE");
		RISOCOLORS.put(0x00838a, "TEAL");
		RISOCOLORS.put(0xbb8b41, "FLATGOLD");
		RISOCOLORS.put(0x407060, "HUNTERGREEN");
		RISOCOLORS.put(0xff665e, "RED");
		RISOCOLORS.put(0x925f52, "BROWN");
		RISOCOLORS.put(0xffe800, "YELLOW");
		RISOCOLORS.put(0xd2515e, "MARINERED");
		RISOCOLORS.put(0xff6c2f, "ORANGE");
		RISOCOLORS.put(0xff48b0, "FLUORESCENTPINK");
		RISOCOLORS.put(0x88898a, "LIGHTGRAY");
		RISOCOLORS.put(0xac936e, "METALLICGOLD");
		RISOCOLORS.put(0xe45d50, "CRIMSON");
		RISOCOLORS.put(0xff7477, "FLUORESCENTORANGE");
		RISOCOLORS.put(0x62a8e5, "CORNFLOWER");
		RISOCOLORS.put(0x4982cf, "SKYBLUE");
		RISOCOLORS.put(0x0074a2, "SEABLUE");
		RISOCOLORS.put(0x235ba8, "LAKE");
		RISOCOLORS.put(0x484d7a, "INDIGO");
		RISOCOLORS.put(0x435060, "MIDNIGHT");
		RISOCOLORS.put(0xd5e4c0, "MIST");
		RISOCOLORS.put(0xa5aaa8, "GRANITE");
		RISOCOLORS.put(0x70747c, "CHARCOAL");
		RISOCOLORS.put(0x5f8289, "SMOKYTEAL");
		RISOCOLORS.put(0x375e77, "STEEL");
		RISOCOLORS.put(0x5e695e, "SLATE");
		RISOCOLORS.put(0x00aa93, "TURQUOISE");
		RISOCOLORS.put(0x19975d, "EMERALD");
		RISOCOLORS.put(0x397e58, "GRASS");
		RISOCOLORS.put(0x516e5a, "FOREST");
		RISOCOLORS.put(0x4a635d, "SPRUCE");
		RISOCOLORS.put(0x68724d, "MOSS");
		RISOCOLORS.put(0x62c2b1, "SEAFOAM");
		RISOCOLORS.put(0x67b346, "KELLYGREEN");
		RISOCOLORS.put(0x009da5, "LIGHTTEAL");
		RISOCOLORS.put(0x169b62, "IVY");
		RISOCOLORS.put(0x237e74, "PINE");
		RISOCOLORS.put(0x2f6165, "LAGOON");
		RISOCOLORS.put(0x9d7ad2, "VIOLET");
		RISOCOLORS.put(0xaa60bf, "ORCHID");
		RISOCOLORS.put(0x845991, "PLUM");
		RISOCOLORS.put(0x775d7a, "RAISIN");
		RISOCOLORS.put(0x6c5d80, "GRAPE");
		RISOCOLORS.put(0xf65058, "SCARLET");
		RISOCOLORS.put(0xd2515e, "TOMATO");
		RISOCOLORS.put(0xd1517a, "CRANBERRY");
		RISOCOLORS.put(0x9e4c6e, "MAROON");
		RISOCOLORS.put(0xd1517a, "RASPBERRYRED");
		RISOCOLORS.put(0xa75154, "BRICK");
		RISOCOLORS.put(0xe3ed55, "LIGHTLIME");
		RISOCOLORS.put(0xffb511, "SUNFLOWER");
		RISOCOLORS.put(0xffae3b, "MELON");
		RISOCOLORS.put(0xf6a04d, "APRICOT");
		RISOCOLORS.put(0xee7f4b, "PAPRIKA");
		RISOCOLORS.put(0xff6f4c, "PUMPKIN");
		RISOCOLORS.put(0xb49f29, "BRIGHTOLIVEGREEN");
		RISOCOLORS.put(0xba8032, "BRIGHTGOLD");
		RISOCOLORS.put(0xbd6439, "COPPER");
		RISOCOLORS.put(0x8e595a, "MAHOGANY");
		RISOCOLORS.put(0xf2cdcf, "BISQUE");
		RISOCOLORS.put(0xf984ca, "BUBBLEGUM");
		RISOCOLORS.put(0xe6b5c9, "LIGHTMAUVE");
		RISOCOLORS.put(0xbd8ca6, "DARKMAUVE");
		RISOCOLORS.put(0x914e72, "WINE");
		RISOCOLORS.put(0x928d88, "GRAY");
		RISOCOLORS.put(0xff8e91, "CORAL");
		RISOCOLORS.put(0xffffff, "WHITE");
		RISOCOLORS.put(0x5ec8e5, "AQUA");
		RISOCOLORS.put(0x82d8d5, "MINT");
		RISOCOLORS.put(0xf2f2f2, "CLEARMEDIUM");
		RISOCOLORS.put(0xffe916, "FLUORESCENTYELLOW");
		RISOCOLORS.put(0xff4c65, "FLUORESCENTRED");
		RISOCOLORS.put(0x44d62c, "FLUORESCENTGREEN");
	};
	
	private PApplet applet;

	public ArrayList<Channel> channels = new ArrayList<Channel>();
	
	public Channel add(int channelColor) {
		Channel c = add(channelColor, applet.width, applet.height);
		return c;
	}

	public Channel add(int channelColor, int w, int h) {
		int channelIndex = channels.size();
		String channelName = RISOCOLORS.get(channelColor);

		if (channelName == null)
			channelName = String.valueOf(channelIndex);

		Channel c = new Channel(applet, channelColor, w, h);
		
		c.channelIndex = channelIndex;
		c.channelName = channelName;
		
		channels.add(c);
		
		return c;
	}

	public void preview() {
		applet.blendMode(MULTIPLY);
		for (Channel r : channels) {
			r.draw();
		}
		applet.blendMode(BLEND);
	}

	public void print() {
		for (Channel r : channels) {
			r.export();
		}
	}

	

	public int[] rgb2cmyk(int r, int g, int b) {
		// adapted from https://mrtan.me/post/java-rgb-to-cmyk-converter.html
		// or https://www.rapidtables.com/convert/color/rgb-to-cmyk.html

		double _r = r / 255.0d;
		double _g = g / 255.0d;
		double _b = b / 255.0d;

		double k = Math.min(Math.min(1d - _r, 1d - _g), 1d - _b);

		double c = 1.0d - (1.0d - _r - k) / (1.0d - k);
		double m = 1.0d - (1.0d - _g - k) / (1.0d - k);
		double y = 1.0d - (1.0d - _b - k) / (1.0d - k);

		k = 1.0d - k;

		return new int[] { (int) (c * 255), (int) (m * 255), (int) (y * 255), (int) (k * 255) };
	}

	public PImage extractCMYKChannel(PImage img, String c) {
		// multichannel extraction courtesy of Robin Sloan

		c = c.toLowerCase();

		PImage out = applet.createImage(img.width, img.height, ARGB);
		img.loadPixels();

		out.loadPixels();

		ArrayList<Integer> desiredChannels = new ArrayList<Integer>();

		if (c == "cyan" || c.contains("c"))
			desiredChannels.add(0);
		if (c == "magenta" || c.contains("m"))
			desiredChannels.add(1);
		if (c == "yellow" || c.contains("y"))
			desiredChannels.add(2);
		if (c == "black" || c.contains("k"))
			desiredChannels.add(3);

		for (int i = 0; i < img.pixels.length; i++) {
			int a = (img.pixels[i] >> 24) & 0xFF;
			int[] cmyk = rgb2cmyk((img.pixels[i] >> 16) & 0xFF, (img.pixels[i] >> 8) & 0xFF, img.pixels[i] & 0xFF);
			int val = 0;
			for (int desiredChannel : desiredChannels) {
				val += cmyk[desiredChannel];
			}
			val /= desiredChannels.size();
			out.pixels[i] = a << 24 | val << 16 | val << 8 | val;
		}

		out.updatePixels();

		return out;
	}

	public PImage threshold(PImage img, int thresh) {
		PImage out = applet.createImage(img.width, img.height, ARGB);
		out.loadPixels();

		img.loadPixels();

		for (int i = 0; i < out.pixels.length; i++) {
			// double avg = (applet.red(img.pixels[i]) + applet.green(img.pixels[i]) +
			// applet.blue(img.pixels[i])) / 3.0;
			float avg = applet.brightness(img.pixels[i]);
			out.pixels[i] = applet.color(avg < thresh ? 0 : 255);
		}

		out.updatePixels();
		return out;
	}

	public PImage halftone(PImage img, String shape, int frequency, float angle, int thresh) {

		img.loadPixels();

		int w = img.width;
		int h = img.height;

		PGraphics rotatedCanvas = applet.createGraphics(w * 2, h * 2, JAVA2D);

		rotatedCanvas.beginDraw();
		rotatedCanvas.background(255);
		rotatedCanvas.imageMode(CENTER);
		rotatedCanvas.pushMatrix();
		rotatedCanvas.translate(w, h);
		rotatedCanvas.rotate(-angle);
		rotatedCanvas.image(img, 0, 0);
		rotatedCanvas.popMatrix();
		rotatedCanvas.endDraw();
		rotatedCanvas.loadPixels();

		PGraphics out = applet.createGraphics(w * 2, h * 2, JAVA2D);
		out.beginDraw();
		out.background(255);
		out.ellipseMode(CORNER);
		out.rectMode(CENTER);
		out.fill(0);
		out.noStroke();

		int gridsize = frequency;

		for (int x = 0; x < rotatedCanvas.width; x += gridsize) {
			for (int y = 0; y < rotatedCanvas.height; y += gridsize) {
				int pxl = rotatedCanvas.pixels[(x + y * rotatedCanvas.width)];
				float avg = applet.brightness(pxl);
				if (avg < 255) {
					float darkness = (255.0f - avg) / 255.0f;

					if (shape == "circle") {
						out.ellipse(x, y, gridsize * darkness, gridsize * darkness);
					} else if (shape == "line") {
						out.rect(x, y, gridsize, gridsize * darkness);
					} else if (shape == "square") {
						out.rect(x, y, gridsize * darkness, gridsize * darkness);
					}
				}
			}
		}

		out.endDraw();

		rotatedCanvas.beginDraw();
		rotatedCanvas.background(255);
		rotatedCanvas.push();
		rotatedCanvas.translate(w, h);
		rotatedCanvas.rotate(angle);
		rotatedCanvas.image(out, 0, 0);
		rotatedCanvas.pop();
		rotatedCanvas.endDraw();

		PImage result = rotatedCanvas.get(w / 2, h / 2, w, h);
		return threshold(result, thresh);
	}

	public PImage dither(PImage img, String type, int threshold) {
		PImage out = applet.createImage(img.width, img.height, ARGB);
		out.loadPixels();

		img.loadPixels();

		// source adapted from:
		// https://github.com/meemoo/meemooapp/blob/44236a29574812026407c0288ab15390e88b556a/src/nodes/image-monochrome-worker.js

		int w = out.width;
		int newPixel, err;

		int[][] bayerThresholdMap = { { 15, 135, 45, 165 }, { 195, 75, 225, 105 }, { 60, 180, 30, 150 },
				{ 240, 120, 210, 90 } };

		double lumR[] = new double[256];
		double lumG[] = new double[256];
		double lumB[] = new double[256];

		for (int i = 0; i < 256; i++) {
			lumR[i] = (double) i * 0.299;
			lumG[i] = (double) i * 0.587;
			lumB[i] = (double) i * 0.114;
		}

		for (int i = 0; i < out.pixels.length; i++) {
			int r = (int) applet.red(out.pixels[i]);
			int g = (int) applet.blue(out.pixels[i]);
			int b = (int) applet.green(out.pixels[i]);
			int sum = (int) (lumR[r] + lumG[g] + lumB[b]);
			out.pixels[i] = applet.color(sum);
		}

		for (int i = 0; i < out.pixels.length; i++) {

			if (type == "none") {
				// No dithering
				out.pixels[i] = applet.red(out.pixels[i]) < threshold ? applet.color(0) : applet.color(255);
			} else if (type == "bayer") {
				// 4x4 Bayer ordered dithering algorithm
				int x = i / 4 % w;
				int y = (int) (i / w);
				int map = (int) ((out.pixels[i] + bayerThresholdMap[x % 4][y % 4]) / 2);
				out.pixels[i] = map < threshold ? applet.color(0) : applet.color(255);
			} else if (type == "floydsteinberg") {
				// Floyd–Steinberg dithering algorithm
				newPixel = out.pixels[i] < 129 ? 0 : 255;
				err = (int) ((out.pixels[i] - newPixel) / 16);
				out.pixels[i] = applet.color(newPixel);
				out.pixels[i + 1] += err * 7;
				out.pixels[i + 1 * w - 1] += err * 3;
				out.pixels[i + 1 * w] += err * 5;
				out.pixels[i + 1 * w + 1] += err * 1;
			} else {
				// Bill Atkinson's dithering algorithm
				newPixel = out.pixels[i] < 129 ? 0 : 255;
				err = (int) ((out.pixels[i] - newPixel) / 8);
				out.pixels[i] = newPixel;

				out.pixels[i + 1] += err;
				out.pixels[i + 2] += err;
				out.pixels[i + 1 * w - 1] += err;
				out.pixels[i + 1 * w] += err;
				out.pixels[i + 1 * w + 1] += err;
				out.pixels[i + 2 * w] += err;
			}

			// Set g and b pixels equal to r
			// out.pixels[i + 1] = out.pixels[i + 2] = out.pixels[i];
		}
		out.updatePixels();
		return out;
	}
	
	public PImage extractRGBChannel(PImage img, String c) {
		c = c.toLowerCase();

		PImage out = applet.createImage(img.width, img.height, ARGB);
		img.loadPixels();

		out.loadPixels();

		int v = 0;

		for (int i = 0; i < img.pixels.length; i++) {
			int a = img.pixels[i] >> 24 & 0xFF;

			if (c == "r" || c == "red") {
				v = img.pixels[i] >> 16 & 0xFF;
			} else if (c == "g" || c == "green") {
				v = img.pixels[i] >> 8 & 0xFF;
			} else if (c == "b" || c == "blue") {
				v = img.pixels[i] & 0xFF;
			}

			out.pixels[i] = a << 24 | v << 16 | v << 8 | v;
		}

		out.updatePixels();

		return out;
	}

	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

}
