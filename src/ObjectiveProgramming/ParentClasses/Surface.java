package ObjectiveProgramming.ParentClasses;
public class Surface {

    private int x;
    private int y;

    public Surface() {
        this.x = 10;
        this.y = 10;
    }

    public Surface(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
