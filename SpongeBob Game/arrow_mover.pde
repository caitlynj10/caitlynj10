// Move with Arrows
// Depends on Actor Class
// http://nebomusic.net/processinglessons/Actor.txt
// Mr. Michaud
// www.nebomusic.net

class ArrowMover extends Actor {

  public ArrowMover(float x, float y) {
    super(x, y);
  }

  void keyListener() {
    if (keyPressed) {
      if (key == CODED) {
        if (keyCode == RIGHT) {
          course = 0;
          velocity = 5;
          move();
        }
        if (keyCode == LEFT) {
          course = 180;
          velocity = 5;
          move();
        }
        if (keyCode == UP) {
          course = 270;
          velocity = 5;
          move();
        }
        if (keyCode == DOWN) {
          course = 90;
          velocity = 5;
          move();
        }
      }
    }
  }

  void act() {
    drawRect();
    keyListener();
  }
}
