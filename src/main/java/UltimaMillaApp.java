import billing.BillingService;
import core.SimulationEngine;
import core.eventbus.EventBus;
import optimizer.OptimizerService;
import warehouse.WarehouseService;
import warehouse.domain.TipoUrgencia;

public class UltimaMillaApp {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus();

        WarehouseService warehouseService = new WarehouseService(eventBus);

        OptimizerService optimizerService = new OptimizerService(eventBus);

        SimulationEngine engine = new SimulationEngine(warehouseService, optimizerService);
        BillingService billingService = new BillingService(eventBus);

        engine.arrancarSimulacion();


    }


}
