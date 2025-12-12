package memento;

public class Client {
    static void main(String[] args) {
        Caretaker taker = new Caretaker();

        MaskMan maskMan = new MaskMan();
        maskMan.setState("茫然无知");
        taker.addMemento(12, maskMan.createMemento());

        maskMan.setState("被抢包");
        taker.addMemento(13, maskMan.createMemento());

        maskMan.setState("哮喘发作");
        taker.addMemento(14, maskMan.createMemento());

        Memento memento = taker.getMemento(13);
        maskMan.restoreMemento(memento);
    }

}
