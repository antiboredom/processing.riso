import riso.*;

Riso layer1;
Riso layer2;
Riso layer3;

void setup() {
  size(600, 600);
  background(255);
  
  // previews different color combinations at different fill levels

  layer1 = new Riso(this, "fluorescentpink");
  layer2 = new Riso(this, "blue");
  layer3 = new Riso(this, "yellow");

  colorGrid(layer1, 0);
  colorGrid(layer2, 90);
  colorGrid(layer3, 270);

  Riso.preview();
  // Riso.print();
}


void colorGrid(Riso layer, float angle) {
  float gridItems = 20;
  float padding = 50;
  float innerPadding = 2;
  float gridSize = (width - padding*2)/gridItems;
  float w = gridSize - innerPadding;
  float h = w;

  layer.pushMatrix();
  layer.translate(width/2, height/2);
  layer.rotate(radians(angle));
  layer.translate(-width/2, -height/2);
  layer.noStroke();

  // draw the grid
  for (float x = padding; x < width-padding; x+=gridSize) {
    for (float y = padding; y < height-padding; y+=gridSize) {
      float intensity = map(y, 0, height, 255, 0);
      layer.fill(intensity);
      layer.rect(x + innerPadding/2, y + innerPadding/2, w, h);
    }
  }

  // draw individual color bands
  for (float y = padding; y < height-padding; y+=gridSize) {
    float intensity = map(y, 0, height, 255, 0);
    float x = width - gridSize;
    layer.fill(intensity);
    layer.rect(x, y + innerPadding/2, w, h);
  }

  layer.popMatrix();
}
