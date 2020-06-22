package hgu.csee.oodp.gps.memento;

import java.util.Stack;

public class CareTaker {
    
    Stack<Memento> mementos = new Stack<>();    //Memento 관리를 위한 Stack
    
    public void push(Memento memento)            //특정 시점에 생성된 Memento를 Push
    {
        mementos.push(memento);
    }
    public Memento pop()                        //복원을 위한 Memento 객체 반환
    {
            return mementos.pop();
    }
}
