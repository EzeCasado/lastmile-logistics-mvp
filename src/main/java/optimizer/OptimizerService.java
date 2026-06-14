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

    public void optimizarRutas(int tick){

        if(this.pedidosPendientes.isEmpty()){

            return;

        }

        System.out.println("\n--- [Optimizer] VOLCANDO VENTANA DE RUTEO - TICK: " + tick + " ---");
        System.out.println("-> Procesando un lote de " + pedidosPendientes.size() + " pedidos pendientes.");

        // Acá en el futuro buscaremos un Vehiculo de la lista y le asignaremos el viaje.
        // Por ahora, simulamos que el lote ya fue despachado:

        this.pedidosPendientes.clear(); // Vaciamos la lista para la próxima tanda
        System.out.println("-> Lote despachado con éxito. Lista de espera reseteada.\n");

    }

}
