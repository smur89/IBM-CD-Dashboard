import processing.core.*;

public class MyProcessingSketch extends PApplet {

//    public void setup() {
//        size(800, 800);
//        smooth();
//        stroke(0);
//        strokeWeight(2);
//        background(255);
//        float r = 100;
//
//        translate(width / 2, height - r);
//        int numSegs = 360;
//
//        //Draw Circle 1
//        for (int i = 0; i < numSegs; i++) {
//            float x = r * cos(360 / numSegs * i);
//            float y = r * sin(360 / numSegs * i);
//            point(x, y);
//        }
//
//        //Middle
//        translate(0, -(r + 70));
//        for (int i = 0; i < numSegs; i++) {
//            float x = (r - 20) * cos(360 / numSegs * i);
//            float y = (r - 20) * sin(360 / numSegs * i);
//            point(x, y);
//        }
//
//        //Head
//        translate(0, -(r + 30));
//        for (int i = 0; i < numSegs; i++) {
//            float x = (r - 40) * cos(360 / numSegs * i);
//            float y = (r - 40) * sin(360 / numSegs * i);
//            point(x, y);
//        }
//
//        //Eyes
//        translate(-20, -15);
//        for (int i = 0; i < numSegs; i++) {
//            float x = (r - 95) * cos(360 / numSegs * i);
//            float y = (r - 95) * sin(360 / numSegs * i);
//            point(x, y);
//        }
//        translate(40, 0);
//        for (int i = 0; i < numSegs; i++) {
//            float x = (r - 95) * cos(360 / numSegs * i);
//            float y = (r - 95) * sin(360 / numSegs * i);
//            point(x, y);
//        }
//
//    }

    int quantity = 300;
    float [] xPosition = new float[quantity];
    float [] yPosition = new float[quantity];
    int [] flakeSize = new int[quantity];
    int [] direction = new int[quantity];
    int minFlakeSize = 1;
    int maxFlakeSize = 5;

    //////////////////

    public void setup(){
        size(400,400);
        smooth();

        frameRate(30);
        noStroke();
        smooth();

        for(int i = 0; i < quantity; i++) {
            flakeSize[i] = round(random(minFlakeSize, maxFlakeSize));
            xPosition[i] = random(0, width);
            yPosition[i] = random(0, height);
            direction[i] = round(random(0, 1));
        }
    }


    public void draw(){
        background(50,50,50);

        //snow
        for(int i = 0; i < xPosition.length; i++) {
            fill(255);
            ellipse(xPosition[i], yPosition[i], flakeSize[i], flakeSize[i]);

            if(direction[i] == 0) {
                xPosition[i] += map(flakeSize[i], minFlakeSize, maxFlakeSize, (float)0.1, (float)0.5);
            } else {
                xPosition[i] -= map(flakeSize[i], minFlakeSize, maxFlakeSize, (float)0.1, (float)0.5);
            }

            yPosition[i] += flakeSize[i] + direction[i];
            if(xPosition[i] > width + flakeSize[i] || xPosition[i] < -flakeSize[i] || yPosition[i] > height + flakeSize[i]) {
                xPosition[i] = random(0, width);
                yPosition[i] = -flakeSize[i];
            }
        }

        //ground
        fill(255);
        rect(0,300,400,100);

        //left hand
        line(80,100,150,150);

        //right hand
        line(320,140,160,150);

        //body
        fill(255);
        ellipseMode(CENTER);
        ellipse(200,300,200,200);

        //body
        fill(255);
        ellipseMode(CENTER);
        ellipse(200,180,140,140);

        //head
        fill(255);
        ellipseMode(CENTER);
        ellipse(200,100,100,100);

        //hat
        fill(0);
        stroke(0);
        rect(140,60,120,10);

        //top hat
        fill(0);
        stroke(0);
        rect(150,10,100,60);

        //left eye
        fill(0);
        ellipseMode(CORNER);
        ellipse(160,80,16,16);

        //right eye
        fill(0);
        ellipseMode(CORNER);
        ellipse(200,80,16,16);

        //nose;
        fill(245,163,10);
        triangle(190,120,140,130,176,106);

        //mouth
        fill(0);
        ellipseMode(CORNER);
        ellipse(166,126,4,4);
        fill(0);
        ellipseMode(CORNER);
        ellipse(172,130,4,4);
        fill(0);
        ellipseMode(CORNER);
        ellipse(180,132,4,4);
        fill(0);
        ellipseMode(CORNER);
        ellipse(188,132,4,4);
        fill(0);
        ellipseMode(CORNER);
        ellipse(196,130,4,4);
        fill(0);
        ellipseMode(CORNER);
        ellipse(204,126,4,4);

        // star


    }
}