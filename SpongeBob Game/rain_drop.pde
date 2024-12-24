// KrabbyPatties Class

class KrabbyPatties extends Actor {
  public KrabbyPatties() {
    super();
    x = random(0, width);        // start at random x
    y = random(0, height);       // start at random y
    //size = (int)random(10, 10);    // random size
    velocity = 20;    // Random Speed for y
    course = 90;
  }
  public float distanceTo(Actor a) {
    float xDistance = x-a.x-153;
    float yDistance = y-a.y-75;
    float sum = pow(xDistance, 2) + pow(yDistance, 2);
    float distance = pow(sum, 0.5);
    return distance;
  }
  
  public boolean isTouching(Actor a) {
    float distance = distanceTo(a);
    if (distance < abs(size + a.size)) {
      return true;
    }
    else {
      return false;
    }
  }

  

void drawKrabbyPatties () {
    fill(222, 155, 74); // Light Brown 
    rect(x, y, 50, 10); // top bun
    fill(11, 126, 10); // Green
    rect(x, y+10, 50, 5); // lettuce
    fill(224, 18, 22); // Red
    rect(x, y+15, 50, 5); // tomato
    fill(255, 200, 80); // Orange
    rect(x, y+20, 50, 5); // cheese
    fill(100, 70, 4); // Dark Brown
    rect(x, y+25, 50, 7); // meat
    fill(222, 155, 74); // Light Brown
    rect(x, y+32, 50, 10); // bottom bun
    arc(x+25, y, 50, 30, PI, TWO_PI);
  }   // Actions for each KrabbyPatties
  
public void levelUp(){
  mySpongebob.score = mySpongebob.score + 1; // increase score
  if(mySpongebob.score == 15){
    mySpongebob.level = 2;
  }
  }
  void act() {
    drawKrabbyPatties();
    if (isTouching(mySpongebob)) {
      y = -20;
      velocity = (int)random(6, 6);
      x = (int)random(0, width);
      size = (int)random(6, 6);
      levelUp();
    } // end if
    move();
    if (y > height) {
      y = -20;
      velocity = (int)random(6, 6);
      x = (int)random(0, width);
      size = (int)random(6, 6);
    }
  }
}   // Draw the KrabbyPatties
