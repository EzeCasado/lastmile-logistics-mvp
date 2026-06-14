package warehouse;

import core.eventbus.EventBus;
import warehouse.domain.Pedido;
import warehouse.domain.TipoUrgencia;
import warehouse.event.PedidoCreadoEvent;

import java.util.ArrayList;
import java.util.List;

public class WarehouseService {

    private List<Pedido> pedidos;
    private EventBus eventBus;

    public WarehouseService(EventBus eventBus) {
        this.eventBus = eventBus;
        this.pedidos = new ArrayList<>();
    }

    public void registrarPedido(int idPedido, double ubiX, double ubiY, TipoUrgencia urgencia, int horaCreacion) {


        Pedido pedido = new Pedido(horaCreacion,idPedido,ubiX,ubiY,urgencia);

        pedidos.add(pedido);

        PedidoCreadoEvent creadoEvent = new PedidoCreadoEvent(horaCreacion,pedido);

        this.eventBus.notificar(creadoEvent);

    }



}
