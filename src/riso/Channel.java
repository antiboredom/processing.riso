package riso;

import processing.awt.PGraphicsJava2D;
import processing.core.PApplet;
import processing.core.PImage;

public class Channel extends PGraphicsJava2D {
	public int channelColor;
	public int channelIndex;
	public String channelName;

	public Channel(PApplet p, int _channelColor) {
		initialize(_channelColor, p.width, p.height, p, p.dataPath(""));
	}

	public Channel(PApplet p, int _channelColor, int w, int h) {
		this(p, _channelColor, w, h, p.dataPath(""));
	}

	public Channel(PApplet p, int _channelColor, int w, int h, String s) {
		initialize(_channelColor, w, h, p, s);
	}

	public void initialize(int _channelColor, int w, int h, PApplet p, String s) {
		setParent(p);
		setPrimary(false);
		setPath(s);
		setSize(w, h);

		channelColor = _channelColor;
	}

	public void draw() {
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
		// TODO: Add anti-aliasing;

		loadPixels();

		// don't execute if mask image is different size
		if (maskArray.length != pixels.length) {
			throw new IllegalArgumentException("cutout() can only be used with an image that's the same size.");
		}

		for (int i = 0; i < pixels.length; i++) {
			// if the maskarray's alpha is larger than 0, set the layers alpha to be 0
			// otherwise keep the layers current alpha
			int originalA = (pixels[i] >> 24) & 0xFF;
			int maskA = (maskArray[i] >> 24) & 0xFF;
			int newA = originalA;
			if (maskA > 0) {
				if (antialias) {
					newA = Math.min(255 - maskA, originalA);
				} else {
					newA = 0;
				}
			}
			pixels[i] = newA << 24 | (pixels[i] & 0xffffff);
		}

		updatePixels();
	}

}
