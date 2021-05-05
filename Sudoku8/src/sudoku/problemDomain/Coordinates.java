package sudoku.problemDomain;


public class Coordinates {

    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Co-ordinates stored in hashmap
     * Keys to keep track of different u.i elements
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinates that = (Coordinates) o;
            return x == that.x &&
                    y == that.y;
        }

    /**Implements hashcode function
     * Acts as a unique identifier generated from given data
     *
     * @return
     */
    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }


}
