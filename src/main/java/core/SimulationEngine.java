package core;

import optimizer.OptimizerService;
import warehouse.WarehouseService;
import warehouse.domain.TipoUrgencia;

public class SimulationEngine {

    private final WarehouseService warehouseService;
    private final OptimizerService optimizerService;

    public SimulationEngine(WarehouseService warehouseService, OptimizerService optimizerService) {
        this.warehouseService = warehouseService;
        this.optimizerService = optimizerService;

    }

    public void arrancarSimulacion(){

        System.out.println("Arrancando simulacion...");

        for(int tick=0;tick<=1440;tick++){

            // 1. Simulamos la llegada de pedidos en minutos específicos
            if (tick == 15) {
                warehouseService.registrarPedido(101, -34.60, -58.38, TipoUrgencia.URGENTE, tick);
            }


            if (tick == 45) {
                warehouseService.registrarPedido(102, -34.62, -58.40, TipoUrgencia.ESTANDAR, tick);
            }


            if (tick == 120) {
                warehouseService.registrarPedido(103, -34.65, -58.42, TipoUrgencia.URGENTE, tick);
            }

            if(tick % 30 ==0){

                optimizerService.optimizarRutas(tick);

            }

        }

        System.out.println("Arrancando simulacion final...");
    }

}
