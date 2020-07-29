import riso.*;

Riso cyan;
Riso magenta;
Riso yellow;
Riso black;

PImage img;

void setup() {
  size(800, 800);
  background(255);

  img = loadImage("van.jpg");

  // create riso layers, setting their dimensions to match our image
  black = new Riso(this, "black", img.width, img.height);
  cyan = new Riso(this, "blue", img.width, img.height);
  magenta = new Riso(this, "fluorescentpink", img.width, img.height);
  yellow = new Riso(this, "yellow", img.width, img.height);

  // extract the colors from the image
  // set useICC to be true to to use adobe's UncoatedFOGRA29 ICC color profile for the cmyk conversion
  // useICC is slower but more accurate
  boolean useICC = true;
  PImage blackPixels = Riso.extractCMYKChannel(img, "k", useICC);
  PImage cyanPixels = Riso.extractCMYKChannel(img, "c", useICC);
  PImage magentaPixels = Riso.extractCMYKChannel(img, "m", useICC);
  PImage yellowPixels = Riso.extractCMYKChannel(img, "y", useICC);

  String pattern = "circle"; // can also be set to "square" or "line"
  float angle = 0.2; // in radians
  int frequency = 3; // frequency of pattern in pixels

  // create a halftone pattern for each color, incrementing the angle as we go
  PImage halftoneBlack = Riso.halftone(blackPixels, pattern, frequency, angle);
  PImage halftoneCyan = Riso.halftone(cyanPixels, pattern, frequency, angle + 0.1);
  PImage halftoneMagenta = Riso.halftone(magentaPixels, pattern, frequency, angle + 0.2);
  PImage halftoneYellow = Riso.halftone(yellowPixels, pattern, frequency, angle + 0.3);

  black.image(halftoneBlack, 0, 0);
  cyan.image(halftoneCyan, 0, 0);
  magenta.image(halftoneMagenta, 0, 0);
  yellow.image(halftoneYellow, 0, 0);

  // draw the riso layers on the screen
  // use "true" to scale the preview to fit the sketch size
  Riso.preview();

  // export the layers for printing
  // Riso.print();
}
