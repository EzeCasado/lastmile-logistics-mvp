package warehouse.event;

import core.eventbus.Event;
import warehouse.domain.Pedido;

public class PedidoCreadoEvent extends Event {

    private final Pedido pedido;

    public PedidoCreadoEvent(int tick, Pedido pedido) {
        super(tick);
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }


}
