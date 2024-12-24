// Extended Actor Class: July 2015
// With Trigonometry
// Mr. Michaud
// www.nebomusic.net

class Actor {
  float x;
  float y;
  int fillRed = 0;
  int fillGreen = 0;
  int fillBlue = 0;
  int penRed = 0;
  int penGreen = 0;
  int penBlue = 0;
  int size = 50;
  int wid = 50;
  int hei = 50;
  float lineWidth = 1;
  float dx = 0;
  float dy = 0;
  float velocity = 0;
  float direction = 0;
  float course = 0;
  
  public Actor() {
  }
  
  public Actor(float newX, float newY) {
    x = newX;
    y = newY;
  }
  
  public void setColor(int r, int g, int b) {
    fillRed = r;
    fillGreen = g;
    fillBlue = b;
  }
  
  public void setPenColor(int r, int g, int b) {
    penRed = r;
    penGreen = g;
    penBlue = b;
  }
  
  public void setPenWidth(float w) {
    lineWidth = w;
  }
  
  public void move() {
    computeVector();
    x += dx;
    y += dy;
  }
  
  public void forward() {
    dx = velocity*cos(radians(direction));
    dy = velocity*sin(radians(direction));
    x += dx;
    y += dy;
  }
  
  public void goTo(float xPos, float yPos) {
    x = xPos;
    y = yPos;
  }
  
  public void bounceEdge() {
    if (x < 0 || x > width) {
      course = course + (90-course)*2;
    }
    if (y < 0 || y > height) {
      course = course + (0-course)*2;
    }
  }
  
  public float distanceTo(Actor a) {
    float xDistance = x-a.x;
    float yDistance = y-a.y;
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
  
  public void bounceActor(Actor a) {
    if (isTouching(a)) {
      course = course + (a.course - course)*2;
    }

  }
  
  public void setDX(float xVel) {
    dx = xVel;
  }
  
  public void setDY(float yVel) {
    dy = yVel;
  }
  
  public void computeVector() {
    dx = velocity * cos(radians(course));
    dy = velocity * sin(radians(course));
  }
  
  public void turn(float t) {
    direction += t;
  }
  
  public void left(float t) {
    turn(t*-1);
  }
  
  public void right(float t) {
    turn(t);
  }
  
  public void drawRect() {
    fill(fillRed, fillGreen, fillBlue);
    stroke(penRed, penGreen, penBlue);
    strokeWeight(lineWidth);
    rect(x, y, wid, hei);
  }
  
  public void drawEllipse() {
    fill(fillRed, fillGreen, fillBlue);
    stroke(penRed, penGreen, penBlue);
    strokeWeight(lineWidth);
    ellipse(x, y, wid, hei);
  }
  
  public void drawSquare() {
    drawPolygon(4);
  }
  
  public void drawPolygon(int sides) {
    // Calculate the vertices
    float points [][] = new float[sides][2];
    float a = 360/sides;
    for (int p = 0; p < sides; p++) {
      float angle = direction + (p*a);
      points[p][0] = x + size*cos(radians(angle));
      points[p][1] = y + size*sin(radians(angle));
    }
    
    // Draw Shape
    fill(fillRed, fillGreen, fillBlue);
    stroke(penRed, penGreen, penBlue);
    strokeWeight(lineWidth);
    beginShape();
    for (int v = 0; v < sides; v++) {
      vertex(points[v][0], points[v][1]);
    }
    endShape(CLOSE);
  } // end drawPolygon
  
  
  public void drawLine() {
    float x2 = x + size*cos(radians(direction));
    float y2 = y + size*sin(radians(direction));
    stroke(penRed, penGreen, penBlue);
    strokeWeight(lineWidth);
    line(x, y, x2, y2);
  } // end drawLine

   public void passRight() {
    if (x > width) {
      x = 0;
    } // end if
  
} // end passRight

  public void passLeft() {
    if (x < 0) {
      x = width ;
    } // end if
} // end passLeft

  public void passTop() {
    // Add code here to complete passTop

  } // end passtop

  public void passBottom() {
    // Add code here to complete passBottom    

  } // end passBottom
  
}
