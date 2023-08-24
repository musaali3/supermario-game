// Created By: Musa Ali
// Created On: June 12, 2023
// Last Modified: June 21, 2023

// DISCLAIMER: the code might not work when you are trying to run it because the image is not downloaded on your laptop. If required, please send me an email so I can send you a video of my code running. 
// Here are all of the different variables that were used in my code. 

import processing.sound.*;
boolean reset = true; // I used boolean in order to create different screens of my game.
boolean win = false;
boolean gameover = false;
boolean message = true;  
boolean screen1 = true;  
boolean screen2 = false;
boolean screen3 = false;
boolean Start = true; 
boolean Next = false;
boolean Back = false;
String name;
PFont Font1;
PFont Font2;  // This variable is used to introduce a new font. 
PFont Font3;
PFont Font4;
PImage character;
boolean jumping = false;
float cy, vy, by;
int amount = 8;           // This part of the code is for the amount of obstacles in each level. 
int[] ex = new int[amount];
int[] sx = new int[amount];
int amount2 = 8;
int[] ex2 = new int[amount];
int[] sx2 = new int[amount];
int timer = 0;
int off;
int mill;
int minutes;
int seconds;
boolean stop = false;
boolean continued = false;
int[] ex3 = new int[amount];
int[] sx3 = new int[amount];  // this is used to create an array of boxes that move horizontally in the game. 
int characterSize = 200;
boolean pressed = false;
float imagey;
int x;
int sximage;
int amount3 = 10;
int[] boxx = new int[amount3];
int[] boxy = new int[amount3];
int[] sy = new int[amount3];
int z = 20;
int level = 1; 
SoundFile music;
SoundFile sound; // I also imported a sound file in my code that runs when the player jumps. 

// In my code I used multiple functions, loops, and arrays. For example, I used a function for each screen so my void draw is as short as possible. I also did not include a point system because it did not make sense with my game. Since the goal of my game
// is to complete it, the point system did not make sense. Although, I did create different levels. 

void setup() {
  size(1800, 1000);
  name = "";
  Font1 = loadFont("MicrosoftYaHeiUI-Bold-150.vlw");
  Font2 = loadFont("ComicSansMS-Bold-80.vlw");
  Font3 = createFont("Arial", 50);
  Font4 = loadFont("ComicSansMS-Bold-200.vlw");
  character = loadImage("character (2).png");
  character.resize(700, 700);
  music = new SoundFile(this, "jump.wav");
  sound = new SoundFile(this, "sound2.mp3");
  cy = 100;
  vy = 0;
  by = 0.20;
  x = 200;
  sximage = 10;
  
  for(int a = 0; a < boxx.length; a++) {
    boxx[a] = floor(random(width));
    boxy[a] = floor(random(height));
    sy[a] = 2;
  }
  
  for(int i = 0; i < ex.length; i++) {  // This is a for loop written to create the obstacles. 
    ex[0] = 1800;
    ex[1] = 2500;
    ex[2] = 3200;
    ex[3] = 3900;
    ex[4] = 4600;
    ex[5] = 5300;
    ex[6] = 6000;
    ex[7] = 6700;   // I have create different ex's because I wanted to add a distance between each of them. 
    sx[i] = 5;
  }
  
  for(int i = 0; i < ex.length; i++) {  
    ex2[0] = 1800;
    ex2[1] = 2500;
    ex2[2] = 3200;
    ex2[3] = 3900;
    ex2[4] = 4600;
    ex2[5] = 5300;
    ex2[6] = 6000;
    ex2[7] = 6700;
    sx2[i] = 5;
  }
  
  for(int i = 0; i < ex.length; i++) {  
    ex3[0] = 1800;
    ex3[1] = 2500;
    ex3[2] = 3200;
    ex3[3] = 3900;
    ex3[4] = 4600;
    ex3[5] = 5300;
    ex3[6] = 6000;
    ex3[7] = 6700;
    sx3[i] = 5;
  }
}

void draw() {            // In order to keep the void draw as short as possible, different functions of each screen are created. 
  background(0);
  println("Made from Scratch by Musa Ali");
 if(screen1) {
  firstscreen();
 } else if(screen2) {
   secondscreen();
   Next = true;
   Back = true;
} else if(screen3) {
  thirdscreen();
} else if (gameover) {
  gameover();
  reset = true;
} else if(win) {
  winscreen();
} 

if(minutes >= 2 && seconds >= 1) {
    win = true;
    screen2 = false;
    screen1 = false;
    screen3 = false;
    gameover = false;
  }
}

void resetGame() {    // A reset function is created to restart the game when someone loses. All the variables and loops are reset. 
  level = 1;
  reset = false;
  gameover = false;
  screen1 = true;
  screen2 = false;
  screen3 = false;
  Start = true;              // As you can see all the variables are set to reset to their original number so the game resets when the restart button is pressed. 
  Next = false;
  Back = false;
  name = "";
  cy = 100;
  vy = 0;
  by = 0.20;
  x = 200;
  sximage = 10;
  
  for (int a = 0; a < boxx.length; a++) {
    boxx[a] = floor(random(width));
    boxy[a] = floor(random(height));
    sy[a] = 2;
  }
  
  for (int i = 0; i < ex.length; i++) {  // Before I was using a longer method when adding new boxes after another, but I watched a video that helped me control the arrays using "*" and "+". For example, every 700 a new box is added. 
    ex[i] = 1800 + i * 700;
    sx[i] = 5;
  }
  
  for (int i = 0; i < ex2.length; i++) {
    ex2[i] = 1800 + i * 700;
    sx2[i] = 5;
  }
  
  for (int i = 0; i < ex3.length; i++) {
    ex3[i] = 1800 + i * 700;
    sx3[i] = 5;
  }
  
  timer = millis();
  off = 0;
  mill = 0;
  minutes = 0;
  seconds = 0;
  stop = false;
  continued = false;
  pressed = false;
  imagey = 0;
  z = 20;
}

//Win Screen
void winscreen() {    // Just like the gameover screen, I also create winscreen in order to portray "YOU WIN" once the game ends. 
  noStroke();
  fill(0, 179, 255);
  rect(0, 0, 5000, 5000);
  fill(255, 239, 133);
  rect(0, 200, 2000, 600);
  fill(0);
  textFont(Font4);
  text("YOU WIN!", 350, 550);
}

// Game Over Screen
void gameover() {
  noStroke();
  fill(0, 179, 255);
  rect(0, 0, 5000, 5000);
  fill(255, 239, 133);
  rect(0, 200, 2000, 600);
  fill(0);
  textFont(Font4);
  text("GAME OVER!", 250, 550);
  
  if(reset) {
    stroke(0);
    strokeWeight(5);
    drawButton(0, 100, 1800, 50, "PRESS HERE TO RESTART");  // this is a boolean used to control the reset button.
  }
}

// Third Screen
void thirdscreen() {
  noStroke();
  fill(0, 179, 255);
  rect(0, 0, 5000, 5000);
  fill(#c2b280);
  rect(0, 700, 5000, 5000);
  fill(0, 200, 0);
  rect(0, 700, 5000, 100);
  image(character, x, imagey, characterSize, characterSize);   // to control the x and y of the image, I created separate variables. 
  vy += by;
  cy += vy;
  imagey = cy - 480;
  if(cy > height) {
    cy = height;
    vy = 0;
    jumping = true;
  }
  
  for(int i = 0; i < ex.length; i++) {
    fill(255, 0, 0);
    rect(ex[i], 650, 50, 50);
    ex[i] -= sx[i];          // Codes like this are used to move the obstacles across the screen. 
    
    if(seconds >= 26) {
    rect(ex2[i], 605, 50, 100);
    ex2[i] -= sx2[i];
    level = 2;
    }
    
    if(seconds >= 50 || minutes >= 1) {
    rect(ex3[i], 510, 50, 50);
    ex3[i] -= sx3[i];
    }
    
    if(ex2[7] <= 0) {
      level = 3;
    } if(ex3[7] <= 0) {
      level = 4;
    }
    
    if (dist(x, imagey, ex[i], 510) < 25 || dist(x, imagey, ex2[i], 510) < 25) {  
      gameover = true;
      screen2 = false;
      screen3 = false;
      screen1 = false;
      win = false;
      break;
    }
    if(characterSize == 200 && imagey >= 510 && x == ex3[i]) {
      gameover = true;
      screen2 = false;
      screen3 = false;
      screen1 = false;
      win = false;
      break;
    }
    
    fill(255);
    textFont(Font3);
    text("LEVEL: " + level, 780, 300);
  }
  
  if(!stop) {
    mill=(millis()-timer); // This code creates the timer. When the timer is not stopped, this part of the code is running. 
    if(continued) mill += off;
    
    seconds = mill / 1000;
    minutes = seconds / 60;
    seconds = seconds % 60;
  }
  
  fill(255);
  textFont(Font4);
  text(minutes, 650, 200);
  text(":", 800, 200);
  text(seconds, 950, 200);
  
  if(pressed) {
    characterSize = 100;
    imagey = 610;
  } else {
    characterSize = 200;
    imagey = cy - 480;
  }
  
  if(minutes == 1 && seconds >= 10) {      // For different parts of my code, I used time in order to control the game. For example, when the timer hits 1:10, the next part of the game will start.
  for (int a = 0; a < boxx.length; a++) {
      fill(255, 0, 0);
      ellipse(boxx[a], boxy[a], z, z);
      boxy[a] = boxy[a] + sy[a];
      
      if(boxy[a] >= 1000) {
        boxy[a] = 0;
        boxx[a] = floor(random(width));
      }
      
     if(dist(boxx[a], boxy[a], x, imagey) <= 20) {    // This code is to check for collision between the red ellipses in level 4 and the player. When they collide the gameover screen appears. 
        gameover = true;
        screen2 = false;
        screen3 = false;
        screen1 = false;
        break;
     }
  }
  }
}


// Second Screen
void secondscreen() {
  fill(0, 179, 255);
  rect(0, 0, 5000, 5000);
  fill(255, 239, 133);
  rect(200, 200, 1370, 600);
  fill(0);
  textFont(Font2);
  text("INSTRUCTIONS", 550, 300);
  textFont(Font3);
  text("Welcome, SUPER " + name, 585, 400); // To make the game more fun, I created a way to add your own name in front of SUPER. This will allow you to play a game with your own name, for example, SUPER MUSA. 
  text("Use the arrow keys to control your player. Move the player", 250, 490); 
  text("and AVOID the boxes. To win the game complete all levels", 250, 550);
  text("without DYING! REMEMBER IF YOU DIE: GAME OVER!", 250, 605);
  
  if(Next) {
    stroke(0);
    strokeWeight(5);
    drawButton(1372, 850, 200, 50, "NEXT");
  }
  
  if(Back) {
    stroke(0);
    strokeWeight(5);
    drawButton(200, 850, 200, 50, "BACK");
}
}


// First Screen
void firstscreen() {
  noStroke();
  fill(0, 179, 255);
  rect(0, 0, 5000, 5000);
  fill(255);
  textFont(Font1);
  text("SUPER " + name, 500, 400);
 if(message) {
  push();
  textSize(50);
  text("YOUR NAME", 1150, 350);
  pop();
  
  stroke(255);
  strokeWeight(5);
  line(500 + textWidth("SUPER "), 400, width - 200, 400);
 }
  noStroke();
  fill(#c2b280);
  rect(0, 700, 5000, 5000);
  fill(0, 200, 0);
  rect(0, 700, 5000, 100);
  image(character, -100, 100);
  
  if(Start) {
    stroke(0);
    strokeWeight(5);
    drawButton(700, 500, 700, 50, "START");
  }
  
  if(!sound.isPlaying()) {          // This code runs the background music. I created an if statement because the sound kept running over itself, therefore, by creating this if statement I was able to run it smoothly. 
    sound.play();
    sound.loop();
  }
}

void keyPressed() {                                  // In order to make it possible to type your name, I assignmed a key to each letter. 
  message = false;
  if(key == 'a' || key == 'A') name = name + "A";
  else if(key == 'b' || key == 'B') name = name + "B";
  else if(key == 'c' || key == 'C') name = name + "C";
  else if(key == 'd' || key == 'D') name = name + "D";
  else if(key == 'e' || key == 'E') name = name + "E";
  else if(key == 'f' || key == 'F') name = name + "F";
  else if(key == 'g' || key == 'G') name = name + "G";
  else if(key == 'h' || key == 'H') name = name + "H";
  else if(key == 'i' || key == 'I') name = name + "I";
  else if(key == 'j' || key == 'J') name = name + "J";
  else if(key == 'k' || key == 'K') name = name + "K";
  else if(key == 'l' || key == 'L') name = name + "L";
  else if(key == 'm' || key == 'M') name = name + "M";
  else if(key == 'n' || key == 'N') name = name + "N";
  else if(key == 'o' || key == 'O') name = name + "O";
  else if(key == 'p' || key == 'P') name = name + "P";
  else if(key == 'q' || key == 'Q') name = name + "Q";
  else if(key == 'r' || key == 'R') name = name + "R";
  else if(key == 's' || key == 'S') name = name + "S";
  else if(key == 't' || key == 'T') name = name + "T";
  else if(key == 'u' || key == 'U') name = name + "U";
  else if(key == 'v' || key == 'V') name = name + "V";
  else if(key == 'w' || key == 'W') name = name + "W";
  else if(key == 'x' || key == 'X') name = name + "X";
  else if(key == 'y' || key == 'Y') name = name + "Y";
  else if(key == 'z' || key == 'Z') name = name + "Z";
  else if(key == BACKSPACE && name.length() > 0) {
    name = name.substring(0, name.length() - 1);
  }
  
  if(keyCode == UP) {             // The code here handles the player, for example, when UP is pressed the player jumps. 
    music.play();
    if(jumping) {
      vy = -10;
      jumping = false;
    }
  }
  
   if(keyCode == DOWN) {
    pressed = true;
  }
  
  if(keyCode == RIGHT) {
    x += sximage;
  } else if(keyCode == LEFT) {
    x -= sximage;
  }
}

void keyReleased() {
  if(keyCode == DOWN) {
    pressed = false;
  }
}

void drawButton(int x, int y, int w, int h, String title) {             // A button function is created in order to draw the different buttons. 
  if (mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h) {
    fill(255);
  } else fill(255, 255, 51);
  rect(x, y, w, h);
  textSize(30);
  fill(0);
  text(title, x + w/2 - textWidth(title)/2, y + h - 10);
}

void mousePressed() {
  if(name.length() >= 2 && mouseX < 1400 && mouseX > 700 && mouseY > 500 && mouseY < 550) {  // I used boolean to create my screens. Now in this part of the code, the boolean is set to true or false according to the buttone clicked. For example, when the start button is clicked screen1 = false.
    screen1 = false;
    screen2 = true;
    println("next screen");
  }
  if(mouseX < 400 && mouseX > 200 && mouseY > 850 && mouseY < 900) {
    screen1 = true;
    screen2 = false;
    message = true;
    name = "";
  }
  if(mouseX < 1572 && mouseX > 1372 && mouseY > 850 && mouseY < 900) {
    screen3 = true;
    screen2 = false;
    screen1 = false;
    timer = millis();
  }
  if(reset && mouseX < 1800 && mouseX > 0 && mouseY > 100 && mouseY < 150) {  // I created a separte button for my reset game function. 
    resetGame();
  }
}
