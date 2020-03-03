import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class main_pde extends PApplet {

PImage img;
PFont light, medium, regular;

String oName = "20191218_final.png";

public void showText(PFont f, String s, int x, int y, int alignX, int alignY)
{
    textFont(f);
    textAlign(alignX, alignY);
    text(s, x, y);
}
class Block
{
    int x, y;
    float wid;
    boolean selected;
    String s;
    PFont font;
    int alignX, alignY;
    Block(String s, PFont f, int x, int y, int alignX, int alignY)
    {
        this.x = x;
        this.y = y;
        this.s = s;
        this.alignX = alignX;
        this.alignY = alignY;
        font = f;
        selected = false; // debug point
        wid = textWidth(s);
    }
    public void update()
    {

    }
    public void draw()
    {
        showText(font, s, x, y, alignX, alignY);

        if(selected)
        {
            fill(255, 0, 0);
            circle(x, y, 10);
            // maybe preserve the color
            fill(255, 255, 255);
        }
    }
}
public PFont f_regular(int size)
{
    return createFont("NotoSansCJKtc-Regular", size);
}
public PFont f_medium(int size)
{
    return createFont("NotoSansCJKtc-Medium", size);
}
public PFont f_light(int size)
{
    return createFont("NotoSansCJKtc-Light", size);
}

Block title, date, time, name;

public void setup() {
    
    img = loadImage("bg.png");

    title = new Block("   Final CTF", f_regular(100), 555, 431, CENTER, CENTER);
    int rBorder = 1135;
    name = new Block("Roy", f_light(85), rBorder, 370, LEFT, CENTER);
    date = new Block("12/18 星期三", f_light(55), rBorder, 484-5, LEFT, CENTER);
    time = new Block("19:00 SF645", f_light(55), rBorder, 550-5, LEFT, CENTER);
    //String[] fontList = PFont.list();
    //printArray(fontList);
}

public void draw() {
    image(img, 0, 0, 1920, 1080);

    // showText(f_regular(16), String.format("%d %d", mouseX, mouseY), 50, 50, LEFT, CENTER);
    title.draw();
    date.draw();
    name.draw();
    time.draw();

    // showText(f_light(55), String.format("%f", title.wid), 10, 10);

    save(oName);
    exit();
}
    public void settings() {  size(1920, 1080); }
    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "main_pde" };
        if (passedArgs != null) {
          PApplet.main(concat(appletArgs, passedArgs));
        } else {
          PApplet.main(appletArgs);
        }
    }
}
