public class Main {
    public static void main(String[] args) {
        //Criando Leafs
        Graphic circle1 = new Circle();
        Graphic circle2 = new Circle();
        Graphic square = new Square();

        CompositeGraphic composite = new CompositeGraphic();
        composite.add(circle1);
        composite.add(circle2);
        composite.add(square);
        composite.remove(circle2);

        CompositeGraphic anotherComposite = new CompositeGraphic();
        anotherComposite.add(composite);
        anotherComposite.add(new Square());

        System.out.println("Composite 1:");
        composite.print();

        System.out.println("\nComposite 2:");
        anotherComposite.print();
    }
}