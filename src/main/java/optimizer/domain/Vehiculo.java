package optimizer.domain;

public class Vehiculo {

    private int idVehiculo;
    private int capacidadMaxima;
    private int bultosActuales;
    private double costoPorkm;
    private TipoVehiculo tipoVehiculo;


    public Vehiculo(int idVehiculo, TipoVehiculo tipoVehiculo) {
        this.bultosActuales = 0;
        this.idVehiculo = idVehiculo;
        this.tipoVehiculo = tipoVehiculo;

        if(tipoVehiculo == TipoVehiculo.FURGON){

            this.capacidadMaxima = 50;
            this.costoPorkm = 5.5; //$5.5  dolares

        }else{

            this.capacidadMaxima = 8;
            this.costoPorkm = 1.2;

        }

    }

    public boolean tieneEspacioDisponible(){

        return this.bultosActuales < this.capacidadMaxima;

    }

    public void cargarBulto(){

        if(tieneEspacioDisponible()){

            this.bultosActuales++;

        }else{

            throw new IllegalStateException("El vehiculo " + idVehiculo + " esta lleno");

        }

    }


    public int getBultosActuales() {
        return bultosActuales;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getCostoPorkm() {
        return costoPorkm;
    }

    public void setCostoPorkm(double costoPorkm) {
        this.costoPorkm = costoPorkm;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }



    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }


}
