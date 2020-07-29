import riso.*;

Riso redChannel;
Riso blueChannel;

void setup() {
  size(500, 500);
  background(220);
   
  redChannel = new Riso(this, "red");
  blueChannel = new Riso(this, "blue");
  
  blueChannel.ellipse(width/2-100, height/2, 250, 250);
  redChannel.ellipse(width/2+100, height/2, 250, 250);
  
  // create a graphics object and draw some text on it
  PGraphics textLayer = createGraphics(width, height);
  textLayer.beginDraw();
  textLayer.textSize(100);
  textLayer.textAlign(CENTER, CENTER);
  textLayer.text("ABOLISH", width/2, height/2);
  textLayer.endDraw();
  
  // cut out the text from the riso layers
  // the second argument determines if the cutout should be antialiased
  blueChannel.cutout(textLayer, true);
  redChannel.cutout(textLayer, true);
  
  // cut out the red from the blue
  // comment out this line to have the two colors overlap
  blueChannel.cutout(redChannel, true);
  
  // draw the riso layers on the screen
  Riso.preview();
  
  // save each layer as a file for printing
  Riso.print();
}
