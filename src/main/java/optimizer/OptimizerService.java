package optimizer;

import core.eventbus.Event;
import core.eventbus.EventBus;
import core.eventbus.EventListener;
import optimizer.domain.Vehiculo;
import warehouse.domain.Pedido;
import warehouse.event.PedidoCreadoEvent;

import java.util.ArrayList;
import java.util.List;

public class OptimizerService implements EventListener {


    private List<Pedido> pedidosPendientes;
    private List<Vehiculo> vehiculos;
    private EventBus eventBus;

    public OptimizerService(EventBus eventBus) {

        this.eventBus = eventBus;
        this.pedidosPendientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();

        eventBus.addEventListener(this);

    }

    @Override
    public void onEvent(Event event) {


        if(event instanceof PedidoCreadoEvent){

            PedidoCreadoEvent creadoEvent = (PedidoCreadoEvent) event;

            this.pedidosPendientes.add(creadoEvent.getPedido());

            System.out.println("[Optimizer] Pedido clonado en la lista de ruteo. ID: " + creadoEvent.getPedido().getIdPedido());

        }

    }
}
