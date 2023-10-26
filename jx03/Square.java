package jx03;

public class Square extends Shape {

    // attribute
    private int side;

    // method
    public void setSide(int l) {
        side = l;
    }

    public int getSide() {
        return side;
    }

    @Override
    public float calcArea() {
        float l;

        l = getSide();
        return (float)(l * l);
    }

}
