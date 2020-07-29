# Riso for Processing

Riso is a Processing library for generating files suitable for Risograph printing. It helps turn your sketches into multi-color prints.

A Risograph is sort of like a photocopier combined with a screen printer. Just like in screen printing, it prints one color at a time, each as a separate layer. To prepare digital files for riso printing, images need to be separated into individual colors, each saved out as a file. The Riso library helps automate color separation and lets you preview of how your prints will look. It makes it possible to turn your Processing sketches into print art!

If you prefer JavaScript, please see [p5.Riso](https://antiboredom.github.io/p5.riso/).

## Getting started

Set up a base Riso object for each color you want to print with. It's constructor takes 4 parameters: the parent applet ("this"), the color, width and height. If you skip widhth and height, it will default to the canvas width and height.

The color parameter can be a string that is the name of the riso ink color you want to print with.

This example prepares an image with black and yellow layers.

```java
Riso black;
Riso yellow;

void setup() {
  size(600, 600);
  black = new Riso(this, 'black');
  yellow = new Riso(this, 'yellow');
}
```

Now that we have Riso objects our black and yellow layers, we can draw graphic elements to each, similar to how you would use a PGraphics object. Place the following in setup() to draw an ellipse on the black and an overlapping ellipse on the yellow layer:

```java
background(255); //set the on screen background to be white

black.fill(255); // set fill on the black layer to be fully opaque
black.ellipse(200, height / 2, 300, 300); // draw ellipse on black layer

yellow.fill(255);
yellow.ellipse(400, height / 2, 300, 300);
```

The two ellipses will overlap, which might not be desirable when printing. To fix this, you can use the `cutout()` function:

```java
black.cutout(yellow); // remove pixels from the black layer if they overlap with the yellow layer
```

You can preview your print on the screen with the preview function:

```java
Riso.preview()
```

Finally, to export the layers for printing, use the print function. They will be saved in the same folder as your sketch as png files, named after the colors you selected.

```java
Riso.print()
```

## Examples

Cutout:


