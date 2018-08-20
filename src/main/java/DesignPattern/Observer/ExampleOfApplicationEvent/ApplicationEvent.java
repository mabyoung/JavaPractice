package DesignPattern.Observer.ExampleOfApplicationEvent;

import java.util.EventObject;

public abstract class ApplicationEvent extends EventObject {
    private static final long serialVersionUID = -6176906904752989541L;
    private final long timestamp;
    public ApplicationEvent(Object source){
        super(source);
        this.timestamp = System.currentTimeMillis();
    }
    public final long getTimestamp(){
        return this.timestamp;
    }
}
