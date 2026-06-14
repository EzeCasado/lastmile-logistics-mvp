package billing;

import core.eventbus.Event;
import core.eventbus.EventBus;
import core.eventbus.EventListener;
import warehouse.domain.TipoUrgencia;
import warehouse.event.PedidoCreadoEvent;

public class BillingService implements EventListener {

    public BillingService(EventBus eventBus) {

        eventBus.addEventListener(this);

    }

    @Override
    public void onEvent(Event event) {

        if(event instanceof PedidoCreadoEvent){

            PedidoCreadoEvent creadoEvent = (PedidoCreadoEvent) event;

            TipoUrgencia urgencia = creadoEvent.getPedido().getUrgencia();
            int id = creadoEvent.getPedido().getIdPedido();


            if (urgencia == TipoUrgencia.URGENTE) {
                System.out.println("[Billing] -> ¡Pedido #" + id + " detectado! Facturado con Tarifa Express ($500).");
            } else {
                System.out.println("[Billing] -> ¡Pedido #" + id + " detectado! Facturado con Tarifa Normal ($200).");
            }

        }

    }
}
