import riso.*;

Riso pinkLayer;
Riso blueLayer;

PImage img;

void setup() {
  size(1100, 850);
  background(255);

  // load our image
  img = loadImage("van.jpg");

  // create a pink and blue layer, setting their dimensions to match our image
  blueLayer = new Riso(this, "blue");
  pinkLayer = new Riso(this, "fluorescentpink");
  
  blueLayer.imageMode(CENTER);
  blueLayer.image(img, width/2, height/2, img.width*1.7, img.height*1.7);

  // extract the red pixels from the image and place on the pink layer
  PImage reds = Riso.extractRGBChannel(img, "r");
  pinkLayer.fill(240);
  pinkLayer.imageMode(CENTER);
  pinkLayer.image(reds, width/2, height/2, img.width*1.68, img.height*1.68);
  
  // draw some text
  PFont font = createFont("Times", 100);
  pinkLayer.fill(255);
  pinkLayer.textFont(font);
  pinkLayer.textAlign(CENTER, CENTER);
  pinkLayer.text("RIOTS WORK", width/2, height/2);

  // cut the pink layer pixels from the blue layer
  blueLayer.cutout(pinkLayer, true);

  Riso.preview();

  // export the layers for printing
  //Riso.print();
}
