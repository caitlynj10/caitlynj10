// Spongebob Function
// Caitlyn Jones

class SpongeBob extends Actor {
  int score = 0;
  int level = 1;
  public SpongeBob(float x, float y) {
    super(x, y);
  }

  void drawSpongebob() {
    stroke(79, 175, 53);
    fill(238, 242, 34); // Yellow
    quad(x, y, x+120, y, x+105, y+100, x+15, y+100); // head
    stroke(0, 0, 0);
    fill(250, 250, 250); // White
    ellipse(x+42.5, y+37.5, 40, 40); 
    ellipse(x+82, y+37.5, 40, 40); // outer layer eye
    fill(29, 240, 234); // Blue
    ellipse(x+46, y+37.5, 20, 20);
    ellipse(x+80, y+37.5, 20, 20); // middle layer eye
    fill(0, 0, 0); // Black
    ellipse(x+46, y+37.5, 10, 10);
    ellipse(x+80, y+37.5, 10, 10); // inner layer eye
    strokeWeight(2);
    line(x+32, y+7, x+36, y+17);
    line(x+42.5, y+6, x+42.5, y+17);
    line(x+53, y+7, x+49, y+17);
    line(x+71.5, y+7, x+75.5, y+17);
    line(x+82, y+6, x+82, y+17);
    line(x+92.5, y+7, x+88.5, y+17); // eyelashes
    fill(250, 250, 250); // White
    rect(x+18, y+100, 85, 12.5);
    triangle(x+8, y+60, x-5, y+85, x+13, y+90);
    triangle(x+112.5, y+60, x+125, y+85, x+107, y+90); 
    triangle(x+30, y+100, x+55, y+100, x+50, y+110.5); 
    triangle(x+65, y+100, x+90, y+100, x+73, y+110.5); // shirt
    fill(185, 102, 51); // Brown
    rect(x+18, y+112.5, 85, 15);
    rect(x+30, y+127, 21.25, 10);
    rect(x+70, y+127, 21.25, 10); // shorts
    strokeWeight(5);
    stroke(238, 242, 34); // Yellow
    line(x+6, y+90, x-2, y+120); // arm
    strokeWeight(20);
    point(x-2, y+120); // hand
    strokeWeight(2);
    stroke(250, 0, 0);
    fill(250, 250, 250); // White
    ellipse(x+62.5, y-25, 20, 50);
    noStroke();
    fill(8, 110, 118); // Blue
    ellipse(x+75, y-12.5, 50, 25);
    fill(250, 0, 0); // Red
    quad(x+55, y+100, x+67, y+100, x+64, y+108, x+58, y+108); 
    rect(x+58, y+108, 6, 6);
    triangle(x+58, y+114, x+64, y+114, x+61, y+120); // tie
    strokeWeight(5);
    stroke(0, 0, 0); // Black
    line(x, y+120, x-22, y+100);
    fill(126, 126, 126);
    quad(x-62, y+80, x-42, y+60, x-12, y+90, x-32, y+110); // spatula 
    stroke(238, 242, 34); // Yellow
    line(x+114, y+90, x+118, y+110);
    line(x+118, y+110, x+143, y+85); // arm
    strokeWeight(20);
    point(x+143, y+85); // hand
    strokeWeight(3);
    stroke(0, 0, 0);
    fill(250, 250, 250); // White
    ellipse(x+153, y+75, 60, 30); 
    ellipse(x+153, y+75, 30, 15); // plate
    strokeWeight(0);
    fill(238, 242, 34); // Yellow
    rect(x+37, y+138.5, 6.5, 15);
    rect(x+77, y+138.5, 6.5, 15); // legs
    fill(250, 250, 250); // White
    rect(x+37, y+152, 6.5, 22); 
    rect(x+77, y+152, 6.5, 22); 
    stroke(110, 170, 252); // Blue
    strokeWeight(3);
    line(x+38, y+156, x+42, y+156);
    line(x+78, y+156, x+82, y+156);
    stroke(237, 77, 77); // Red
    line(x+38, y+161, x+42, y+161);
    line(x+78, y+161, x+82, y+161); // socks
    stroke(0, 0, 0); // Black
    fill(0, 0, 0); // Black
    ellipse(x+37, y+174, 13, 7);
    ellipse(x+77, y+174, 13, 7); // shoes
    strokeWeight(2);
    fill(238, 242, 34);
    ellipse(x+78, y+55, 45, 12); // nose
    fill(95, 26, 26); // Red
    arc(x+62.5, y+68, 58, 50, 0, PI);
    line(x+33.5, y+68, x+91.5, y+68); // mouth
    fill(250, 250, 250); // White
    rect(x+45.5, y+68, 15, 12); 
    rect(x+64.5, y+68, 15, 12); // teeth
    fill(250, 103, 218); // Pink
    arc(x+62.5, y+91, 25, 15, PI, TWO_PI);
    fill(0, 0, 0);
      
  }// end drawspongebob

  void keyListener() {
    if (keyPressed) {
      if (key == CODED) {
        if (keyCode == RIGHT) {
          course = 0;
          velocity = 10;
          move();
        }
        if (keyCode == LEFT) {
          course = 180;
          velocity = 10;
          move();
        }
      }
    }
  }

  void act() {
    drawSpongebob();  
    keyListener();
  }
}
