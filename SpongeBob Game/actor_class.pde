// Setup for Spongebob Game
// Caitlyn Jones

// Instances
SpongeBob mySpongebob = new SpongeBob(100, 700);

// Rain Loop Sample
// Array for rain
KrabbyPatties rain [] = new KrabbyPatties [5];



void setup() {
  size(1000, 1000);
   // Initialize the RainDrop objects
  for (int i = 0; i < rain.length; i++) {
    rain [i] = new KrabbyPatties();
  
  }
} 
void draw() {
  background(146, 242, 245); // Blue
  // Ground
  fill(4, 4, 72);
  rect(0, 800, 1000, 200);
  // Bikini Bottom
  stroke(207, 101, 250);
  fill(207, 101, 250); 
  rect(0, 300, 150, 500);
  arc(75, 300, 150, 150, PI, TWO_PI);
  rect(250, 500, 150, 300);
  arc(325, 500, 150, 150, PI, TWO_PI);
  rect(575, 400, 150, 400);
  arc(650, 400, 150, 150, PI, TWO_PI);
  rect(825, 100, 150, 700);
  arc(900, 100, 150, 150, PI, TWO_PI);
  stroke(0, 0, 0);
  for (int i = 0; i < rain.length; i++) {
    rain[i].act();
  } // end for

  mySpongebob.act();
  
  
    // Display Score
  textSize(20); // Set Text Size
  fill(0, 0, 0); // Text color black 
  text("Score: ", 20, 20); // Print "Score" on canvas
  text(mySpongebob.score, 100, 20); // Print player's score
  text("Level: ", 900, 20);
  text(mySpongebob.level, 1000, 20);
 
} // end draw
