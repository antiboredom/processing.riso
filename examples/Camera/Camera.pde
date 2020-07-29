import processing.video.*;
import riso.*;

Riso redChannel;
Riso blueChannel;

Capture video;

void setup() {

  // please note this sketch is untested because of a processing video issue on macs
  // it will be updated in the future!

  size(640, 480);
  background(220);

  redChannel = new Riso(this, "red");
  blueChannel = new Riso(this, "blue");

  video = new Capture(this, width, height);

  // Start capturing the images from the camera
  video.start();
}

void draw() {
  background(255);
  Riso.clearAll();

  PImage reds = Riso.extractRGBChannel(video, "r");
  PImage blues = Riso.extractRGBChannel(video, "b");

  redChannel.image(reds, 0, 0);
  blueChannel.image(blues, 0, 0);

  Riso.preview();
}
