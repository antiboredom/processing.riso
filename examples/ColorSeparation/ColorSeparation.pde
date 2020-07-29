import riso.*;

Riso cyan;
Riso magenta;
Riso yellow;
Riso black;

PImage img;

void setup() {
  size(800, 610);
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
  
  // draw each color separation on the appropriate layer
  // try commenting some of these out or switching them around
  // for different effects
  black.image(blackPixels, 0, 0);
  cyan.image(cyanPixels, 0, 0);
  magenta.image(magentaPixels, 0, 0);
  yellow.image(yellowPixels, 0, 0);

  // draw the riso layers on the screen
  // use "true" to scale the preview to fit the sketch size
  Riso.preview(true);

  // export the layers for printing
  // Riso.print();
}
