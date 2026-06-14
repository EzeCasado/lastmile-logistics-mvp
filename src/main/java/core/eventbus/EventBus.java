package core.eventbus;

import java.util.ArrayList;
import java.util.List;

public class EventBus {

    private List<EventListener> oyentes;

    public EventBus(){
        oyentes = new ArrayList<>();
    }

    public void addEventListener(EventListener listener){
        oyentes.add(listener);
    }

    public void notificar(Event event){

        for(EventListener listener : oyentes){


            listener.onEvent(event);

        }

    }

}
