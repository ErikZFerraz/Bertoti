public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver("Observer 1", subject);
        Observer observer2 = new ConcreteObserver("Observer 2", subject);

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        System.out.println("Mudando o estado para true...");
        subject.setState(true);

        System.out.println("Mudando o estado para false...");
        subject.setState(false);
    }
}
