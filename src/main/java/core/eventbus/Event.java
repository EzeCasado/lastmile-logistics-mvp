package core.eventbus;

public abstract class Event {

    private  final int tick;

    public Event(int tick) {
        this.tick = tick;
    }
    public int getTick() {
        return tick;
    }

}
