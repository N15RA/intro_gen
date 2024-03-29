PImage img;
PFont light, medium, regular;

String oName = "20210525_White_box.png";

void showText(PFont f, String s, int x, int y, int alignX, int alignY)
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
    void update()
    {

    }
    void draw()
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
PFont f_regular(int size)
{
    return createFont("NotoSansCJKtc-Regular.otf", size);
}
PFont f_medium(int size)
{
    return createFont("NotoSansCJKtc-Medium.otf", size);
}
PFont f_light(int size)
{
    return createFont("NotoSansCJKtc-Light.otf", size);
}

Block title, date, time, name;

void setup() {
    size(1920, 1080);
    img = loadImage("bg.png");

    title = new Block("    aaaaaaa", f_regular(100), 555, 431, CENTER, CENTER);
    int rBorder = 1135;
    name = new Block("Halloworld", f_light(85), rBorder, 370, LEFT, CENTER);
    date = new Block("05/25 星期二", f_light(55), rBorder, 484-5, LEFT, CENTER);
    time = new Block("19:00 Discord", f_light(55), rBorder, 550-5, LEFT, CENTER);
    //String[] fontList = PFont.list();
    //printArray(fontList);
}

void draw() {
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
