package riso;

import java.util.ArrayList;
import java.util.HashMap;
import processing.awt.PGraphicsJava2D;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PGraphics;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.io.IOException;

/**
 * 
 * 
 *
 */

public class Riso extends PGraphicsJava2D {

	public final static String VERSION = "##library.prettyVersion##";

	public final static HashMap<String, Integer> RISOCOLORS;

	static {
		RISOCOLORS = new HashMap<String, Integer>();

		RISOCOLORS.put("BLACK", 0x000000);
		RISOCOLORS.put("BURGUNDY", 0x914e72);
		RISOCOLORS.put("BLUE", 0x0078bf);
		RISOCOLORS.put("GREEN", 0x00a95c);
		RISOCOLORS.put("MEDIUMBLUE", 0x3255a4);
		RISOCOLORS.put("BRIGHTRED", 0xf15060);
		RISOCOLORS.put("RISOFEDERALBLUE", 0x3d5588);
		RISOCOLORS.put("PURPLE", 0x765ba7);
		RISOCOLORS.put("TEAL", 0x00838a);
		RISOCOLORS.put("FLATGOLD", 0xbb8b41);
		RISOCOLORS.put("HUNTERGREEN", 0x407060);
		RISOCOLORS.put("RED", 0xff665e);
		RISOCOLORS.put("BROWN", 0x925f52);
		RISOCOLORS.put("YELLOW", 0xffe800);
		RISOCOLORS.put("MARINERED", 0xd2515e);
		RISOCOLORS.put("ORANGE", 0xff6c2f);
		RISOCOLORS.put("FLUORESCENTPINK", 0xff48b0);
		RISOCOLORS.put("LIGHTGRAY", 0x88898a);
		RISOCOLORS.put("METALLICGOLD", 0xac936e);
		RISOCOLORS.put("CRIMSON", 0xe45d50);
		RISOCOLORS.put("FLUORESCENTORANGE", 0xff7477);
		RISOCOLORS.put("CORNFLOWER", 0x62a8e5);
		RISOCOLORS.put("SKYBLUE", 0x4982cf);
		RISOCOLORS.put("SEABLUE", 0x0074a2);
		RISOCOLORS.put("LAKE", 0x235ba8);
		RISOCOLORS.put("INDIGO", 0x484d7a);
		RISOCOLORS.put("MIDNIGHT", 0x435060);
		RISOCOLORS.put("MIST", 0xd5e4c0);
		RISOCOLORS.put("GRANITE", 0xa5aaa8);
		RISOCOLORS.put("CHARCOAL", 0x70747c);
		RISOCOLORS.put("SMOKYTEAL", 0x5f8289);
		RISOCOLORS.put("STEEL", 0x375e77);
		RISOCOLORS.put("SLATE", 0x5e695e);
		RISOCOLORS.put("TURQUOISE", 0x00aa93);
		RISOCOLORS.put("EMERALD", 0x19975d);
		RISOCOLORS.put("GRASS", 0x397e58);
		RISOCOLORS.put("FOREST", 0x516e5a);
		RISOCOLORS.put("SPRUCE", 0x4a635d);
		RISOCOLORS.put("MOSS", 0x68724d);
		RISOCOLORS.put("SEAFOAM", 0x62c2b1);
		RISOCOLORS.put("KELLYGREEN", 0x67b346);
		RISOCOLORS.put("LIGHTTEAL", 0x009da5);
		RISOCOLORS.put("IVY", 0x169b62);
		RISOCOLORS.put("PINE", 0x237e74);
		RISOCOLORS.put("LAGOON", 0x2f6165);
		RISOCOLORS.put("VIOLET", 0x9d7ad2);
		RISOCOLORS.put("ORCHID", 0xaa60bf);
		RISOCOLORS.put("PLUM", 0x845991);
		RISOCOLORS.put("RAISIN", 0x775d7a);
		RISOCOLORS.put("GRAPE", 0x6c5d80);
		RISOCOLORS.put("SCARLET", 0xf65058);
		RISOCOLORS.put("TOMATO", 0xd2515e);
		RISOCOLORS.put("CRANBERRY", 0xd1517a);
		RISOCOLORS.put("MAROON", 0x9e4c6e);
		RISOCOLORS.put("RASPBERRYRED", 0xd1517a);
		RISOCOLORS.put("BRICK", 0xa75154);
		RISOCOLORS.put("LIGHTLIME", 0xe3ed55);
		RISOCOLORS.put("SUNFLOWER", 0xffb511);
		RISOCOLORS.put("MELON", 0xffae3b);
		RISOCOLORS.put("APRICOT", 0xf6a04d);
		RISOCOLORS.put("PAPRIKA", 0xee7f4b);
		RISOCOLORS.put("PUMPKIN", 0xff6f4c);
		RISOCOLORS.put("BRIGHTOLIVEGREEN", 0xb49f29);
		RISOCOLORS.put("BRIGHTGOLD", 0xba8032);
		RISOCOLORS.put("COPPER", 0xbd6439);
		RISOCOLORS.put("MAHOGANY", 0x8e595a);
		RISOCOLORS.put("BISQUE", 0xf2cdcf);
		RISOCOLORS.put("BUBBLEGUM", 0xf984ca);
		RISOCOLORS.put("LIGHTMAUVE", 0xe6b5c9);
		RISOCOLORS.put("DARKMAUVE", 0xbd8ca6);
		RISOCOLORS.put("WINE", 0x914e72);
		RISOCOLORS.put("GRAY", 0x928d88);
		RISOCOLORS.put("CORAL", 0xff8e91);
		RISOCOLORS.put("WHITE", 0xffffff);
		RISOCOLORS.put("AQUA", 0x5ec8e5);
		RISOCOLORS.put("MINT", 0x82d8d5);
		RISOCOLORS.put("CLEARMEDIUM", 0xf2f2f2);
		RISOCOLORS.put("FLUORESCENTYELLOW", 0xffe916);
		RISOCOLORS.put("FLUORESCENTRED", 0xff4c65);
		RISOCOLORS.put("FLUORESCENTGREEN", 0x44d62c);

	};

	private static final float LUMR = 0.299f;
	private static final float LUMG = 0.587f;
	private static final float LUMB = 0.144f;

	// https://stackoverflow.com/questions/4858131/rgb-to-cmyk-and-back-algorithm

	private static ColorSpace COLORSPACE;
	static {
		try {
			ClassLoader classLoader = Riso.class.getClassLoader();
			COLORSPACE = new ICC_ColorSpace(
					ICC_Profile.getInstance(classLoader.getResourceAsStream("data/UncoatedFOGRA29.icc")));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private PApplet applet;

	public static ArrayList<Riso> channels = new ArrayList<Riso>();

	public int channelColor;
	public int channelIndex;
	public String channelName;

	public Riso(PApplet p, String _channelColor) {
		_channelColor = _channelColor.toUpperCase();
		if (!RISOCOLORS.containsKey(_channelColor)) {
			throw new IllegalArgumentException("Color not found.");
		}
		channelName = _channelColor;
		int c = RISOCOLORS.get(_channelColor);
		initialize(p, c, p.width, p.height);
	}

	public Riso(PApplet p, String _channelColor, int w, int h) {
		_channelColor = _channelColor.toUpperCase();
		if (!RISOCOLORS.containsKey(_channelColor)) {
			throw new IllegalArgumentException("Color not found.");
		}
		channelName = _channelColor;
		int c = RISOCOLORS.get(_channelColor);
		initialize(p, c, w, h);
	}

	public Riso(PApplet p, int _channelColor) {
		initialize(p, _channelColor, p.width, p.height);
	}

	public Riso(PApplet p, int _channelColor, int w, int h) {
		initialize(p, _channelColor, w, h);
	}

	public void initialize(PApplet p, int _channelColor, int w, int h) {
		setParent(p);
		setPrimary(false);
		setPath(p.dataPath(""));
		setSize(w, h);

		channelColor = _channelColor;

		applet = p;

		channelIndex = channels.size();

		if (channelName == null)
			channelName = String.valueOf(channelIndex);

		channels.add(this);

		applet.registerMethod("pre", this);
		applet.registerMethod("draw", this);

		beginDraw();
	}

	public void pre() {
		beginDraw();
	}

	public void draw() {
		endDraw();
	}

	public void display() {
		endDraw();
		this.parent.image(this, 0, 0);
	}

	public void export() {
		String filename = channelName + ".png";
		export(filename);
	}

	public void export(String filename) {
		PImage buffer = parent.createImage(width, height, ARGB);
		buffer.loadPixels();
		loadPixels();
		for (int i = 0; i < pixels.length; i++) {
			buffer.pixels[i] = color(0, 0, 0, alpha(pixels[i]));
		}
		buffer.updatePixels();
		buffer.save(filename);
	}

	/*
	 * Fill methods. Fill methods taking more than one parameter should throw an
	 * error.
	 */

	@Override
	public void fill(float intensity) {
		super.fill(red(channelColor), green(channelColor), blue(channelColor), intensity);
	}

	@Override
	public void fill(int intensity) {
		super.fill(red(channelColor), green(channelColor), blue(channelColor), intensity);
	}

	@Override
	public void fill(float v1, float v2, float v3) {
		throw new java.lang.Error("Please use fill() with a single argument.");
	}

	@Override
	public void fill(float v1, float v2, float v3, float alpha) {
		throw new java.lang.Error("Please use fill() with a single argument.");
	}

	@Override
	public void fill(float gray, float alpha) {
		throw new java.lang.Error("Please use fill() with a single argument.");
	}

	@Override
	public void fill(int rgb, float alpha) {
		throw new java.lang.Error("Please use fill() with a single argument.");
	}

	/*
	 * Stroke methods. Stroke methods taking more than one parameter should throw an
	 * error.
	 */

	@Override
	public void stroke(float intensity) {
		super.stroke(red(channelColor), green(channelColor), blue(channelColor), intensity);
	}

	@Override
	public void stroke(float v1, float v2, float v3) {
		throw new java.lang.Error("Please use stroke() with a single argument.");
	}

	@Override
	public void stroke(float v1, float v2, float v3, float alpha) {
		throw new java.lang.Error("Please use stroke() with a single argument.");
	}

	@Override
	public void stroke(float gray, float alpha) {
		throw new java.lang.Error("Please use stroke() with a single argument.");
	}

	@Override
	public void stroke(int rgb, float alpha) {
		throw new java.lang.Error("Please use stroke() with a single argument.");
	}

	@Override
	public void stroke(int intensity) {
		super.stroke(red(channelColor), green(channelColor), blue(channelColor), intensity);
	}

	/*
	 * 
	 * Image
	 * 
	 */

	@Override
	public void image(PImage img, float x, float y) {
		image(img, x, y, img.width, img.height);
	}

	@Override
	public void image(PImage img, float x, float y, float w, float h) {
		float alphaValue = alpha(fillColor) / 255.0f;

		PImage newImage = parent.createImage(img.width, img.height, ARGB);
		img.loadPixels();
		newImage.loadPixels();

		int channelR = (int) red(channelColor) << 16;
		int channelG = (int) green(channelColor) << 8;
		int channelB = (int) blue(channelColor);

		for (int i = 0; i < img.pixels.length; i++) {
			int argb = img.pixels[i];

			int a = (argb >> 24) & 0xFF;
			int r = (argb >> 16) & 0xFF;
			int g = (argb >> 8) & 0xFF;
			int b = argb & 0xFF;

			int finalA = a < 255 ? (int) (a * alphaValue) : (int) ((255f - ((r + g + b) / 3f)) * alphaValue);

			finalA = finalA << 24;

			newImage.pixels[i] = finalA | channelR | channelG | channelB;
		}
		newImage.updatePixels();
		super.image(newImage, x, y, w, h);
	}

	public void cutout(PImage img) {
		cutout(img, false);
	}

	public void cutout(PImage img, boolean antialias) {
		img.loadPixels();
		cutout(img.pixels, antialias);
	}

	public void cutout(int[] maskArray, boolean antialias) {
		loadPixels();

		// don't execute if mask image is different size
		if (maskArray.length != pixels.length) {
			throw new IllegalArgumentException("cutout() can only be used with an image that's the same size.");
		}

		for (int i = 0; i < pixels.length; i++) {
			// if the maskarray's alpha is larger than 0, set the layers alpha to be 0
			// otherwise keep the layers current alpha
			int maskA = (maskArray[i] >> 24) & 0xFF;
			if (maskA > 0) {
				int originalA = (pixels[i] >> 24) & 0xFF;
				int newA = antialias ? Math.min(255 - maskA, originalA) : 0;
				pixels[i] = newA << 24 | (pixels[i] & 0xffffff);
			}

		}

		updatePixels();
	}

	public static void listColors() {
		for (String key : Riso.RISOCOLORS.keySet()) {
			System.out.println(key);
		}
	}

	public static void clearAll() {
		for (Riso r : channels) {
			r.clear();
		}
	}

	public static void preview() {
		preview(false);
	}

	public static void preview(boolean shrink) {
		if (channels.size() > 0) {
			float ratio = 1f;
			PApplet main = channels.get(0).parent;
			if (shrink) {
				float widthRatio = (float) main.width / (float) channels.get(0).width;
				float heightRatio = (float) main.height / (float) channels.get(0).height;
				ratio = Math.min(widthRatio, heightRatio);

			}
			main.pushMatrix();
			main.scale(ratio);
			main.blendMode(MULTIPLY);
			for (Riso r : channels) {
				r.display();
			}
			main.blendMode(BLEND);
			main.popMatrix();
		}
	}

	public static void print() {
		for (Riso r : channels) {
			r.export();
		}
	}

	public static float[] rgb2cmyk(int r, int g, int b) {
		return rgb2cmyk(r, g, b, false);

	}

	public static float[] rgb2cmyk(int r, int g, int b, boolean useICC) {

		if (useICC) {
			float[] rgb = { r / 255.0f, g / 255.0f, b / 255.0f };
			float[] fromRGB = COLORSPACE.fromRGB(rgb);

			return fromRGB;
		} else {
			// adapted from https://mrtan.me/post/java-rgb-to-cmyk-converter.html
			// or https://www.rapidtables.com/convert/color/rgb-to-cmyk.html
			// https://stackoverflow.com/questions/4858131/rgb-to-cmyk-and-back-algorithm

			float _r = r / 255.0f;
			float _g = g / 255.0f;
			float _b = b / 255.0f;

			float k = 1.0f - Math.max(Math.max(_r, _g), _b);
			float c = (1.0f - _r - k) / (1.0f - k);
			float m = (1.0f - _g - k) / (1.0f - k);
			float y = (1.0f - _b - k) / (1.0f - k);

			return new float[] { c, m, y, k };
		}
	}

	public static PImage extractCMYKChannel(PImage img, String c) {
		return extractCMYKChannel(img, c, false);
	}

	public static PImage extractCMYKChannel(PImage img, String c, boolean useICC) {
		// multichannel extraction courtesy of Robin Sloan

		c = c.toLowerCase();

		PImage out = img.parent.createImage(img.width, img.height, ARGB);
		out.loadPixels();

		img.loadPixels();

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
			float[] cmyk = rgb2cmyk((img.pixels[i] >> 16) & 0xFF, (img.pixels[i] >> 8) & 0xFF, img.pixels[i] & 0xFF, useICC);
			float val = 0;
			for (int desiredChannel : desiredChannels) {
				val += cmyk[desiredChannel];
			}
			val = (val / desiredChannels.size()) * 255;
			out.pixels[i] = a << 24 | 255 - (int) val << 16 | 255 - (int) val << 8 | 255 - (int) val;
		}

		out.updatePixels();

		return out;
	}

	public static PImage extractRGBChannel(PImage img, String c) {
		c = c.toLowerCase();

		PImage out = img.parent.createImage(img.width, img.height, ARGB);
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

	public static PImage threshold(PImage img, int thresh) {
		PImage out = img.parent.createImage(img.width, img.height, ARGB);
		out.loadPixels();

		img.loadPixels();

		for (int i = 0; i < out.pixels.length; i++) {
			float avg = img.parent.brightness(img.pixels[i]);
			out.pixels[i] = img.parent.color(avg < thresh ? 0 : 255);
		}

		out.updatePixels();
		return out;
	}

	public static PImage halftone(PImage img, String shape) {
		return halftone(img, shape, 5, 0, 128);
	}

	public static PImage halftone(PImage img, String shape, int frequency) {
		return halftone(img, shape, frequency, 0, 128);
	}

	public static PImage halftone(PImage img, String shape, int frequency, float angle) {
		return halftone(img, shape, frequency, angle, 128);
	}

	public static PImage halftone(PImage img, String shape, int frequency, float angle, int thresh) {

		img.loadPixels();

		int w = img.width;
		int h = img.height;

		PGraphics rotatedCanvas = img.parent.createGraphics(w * 2, h * 2, JAVA2D);
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

		PGraphics out = img.parent.createGraphics(w * 2, h * 2, JAVA2D);
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
				float avg = img.parent.brightness(pxl);
//				float avg = luminance(pxl);
//				float avg = average(pxl);

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

		PImage result = threshold(rotatedCanvas.get(w / 2, h / 2, w, h), thresh);
		result.parent = img.parent;
		return result;
	}

	public static PImage dither(PImage img) {
		return dither(img, "bayer", 128);
	}

	public static PImage dither(PImage img, int threshold) {
		return dither(img, "bayer", threshold);
	}

	public static PImage dither(PImage img, String type) {
		return dither(img, type, 128);
	}

	public static PImage dither(PImage img, String type, int threshold) {
		// TODO: add floydsteinberg and Bill Atkinson
		// source adapted from:
		// https://github.com/meemoo/meemooapp/blob/44236a29574812026407c0288ab15390e88b556a/src/nodes/image-monochrome-worker.js

		PImage out = img.get();
		out.parent = img.parent;

		int w = out.width;
		// int newPixel, err;

		int[][] bayerThresholdMap = { { 15, 135, 45, 165 }, { 195, 75, 225, 105 }, { 60, 180, 30, 150 },
				{ 240, 120, 210, 90 } };

		for (int i = 0; i < out.pixels.length; i++) {
			int lum = luminance(out.pixels[i]);

			if (type == "bayer") {
				// 4x4 Bayer ordered dithering algorithm
				int x = i % w;
				int y = i / w;
				int map = (lum + bayerThresholdMap[x % 4][y % 4]) / 2;
				out.pixels[i] = map < threshold ? img.parent.color(0) : img.parent.color(255);
			}
		}
		out.updatePixels();
		return out;
	}

	/**
	 * returns the luminance value of an RGB color integer.
	 * 
	 * @return Integer
	 */
	public static int luminance(int c) {
		return (int) ((c >> 16 & 0xFF) * LUMR + (c >> 8 & 0xFF) * LUMG + (c & 0xFF) * LUMB);
	}

	/**
	 * returns the average value of an RGB color integer.
	 * 
	 * @return Integer
	 */
	public static float average(int c) {
		return ((c >> 16 & 0xFF) + (c >> 8 & 0xFF) + (c & 0xFF)) / 3f;
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
