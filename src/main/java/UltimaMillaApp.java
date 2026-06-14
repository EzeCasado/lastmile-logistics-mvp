import core.eventbus.EventBus;
import optimizer.OptimizerService;
import warehouse.WarehouseService;
import warehouse.domain.TipoUrgencia;

public class UltimaMillaApp {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus();

        WarehouseService warehouseService = new WarehouseService(eventBus);

        OptimizerService optimizerService = new OptimizerService(eventBus);


        warehouseService.registrarPedido(101, -34.60, -58.38, TipoUrgencia.URGENTE, 10);

    }


}
