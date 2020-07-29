import riso.*;

Riso redChannel;

void setup() {
  size(500, 500);
  background(255);
  
  // list all available riso colors
  Riso.listColors();
  
  // create new riso color layer, either using a Riso color name or a color variable
  // you can then draw on the layer like a PGraphics object
  redChannel = new Riso(this, "red");

  // fill at half opacity
  redChannel.fill(128);
  
  // stroke at full opacity
  redChannel.stroke(255);
  redChannel.strokeWeight(5);
  
  // draw an ellipse
  redChannel.ellipse(width/2, height/2, 200, 200);
  
  // draw the riso layers on the screen
  Riso.preview();
  
  // save each layer as a file for printing
  Riso.print();
}
