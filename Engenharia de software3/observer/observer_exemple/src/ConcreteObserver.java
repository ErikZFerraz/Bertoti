public class ConcreteObserver implements Observer {
    private final String name;
    private final Subject subject;

    public ConcreteObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println(name + " foi notificado. Novo estado: " + subject.getState());
    }
}
