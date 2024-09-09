import java.util.ArrayList;
import java.util.List;

class CompositeGraphic implements Graphic {
    private List<Graphic> childGraphics = new ArrayList<>();

    public void add(Graphic graphic) {
        childGraphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        childGraphics.remove(graphic);
    }


    @Override
    public void print() {
        for (Graphic graphic : childGraphics) {
            graphic.print();
        }
    }
}