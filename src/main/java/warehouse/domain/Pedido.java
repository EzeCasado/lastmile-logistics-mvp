package warehouse.domain;

public class Pedido {

    private int idPedido;

    private double ubiX;
    private double ubiY;
    private EstadoPedido estado;
    private TipoUrgencia urgencia;

    private int horaCreacion; //En minutos
    private int horaPromesa; //En minutos

    public Pedido(int horaCreacion, int idPedido, double ubiX, double ubiY, TipoUrgencia urgencia) {

        this.horaCreacion = horaCreacion;
        this.idPedido = idPedido;
        this.ubiX = ubiX;
        this.ubiY = ubiY;
        this.urgencia = urgencia;

        this.estado = EstadoPedido.LISTO_PARA_DESPACHO;

        if(urgencia == TipoUrgencia.ESTANDAR){

            this.horaPromesa = horaCreacion + 240; // 240min = 4 hs

        }else{

            this.horaPromesa = horaCreacion + 120; //120 min = 2 hs

        }
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public int getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(int horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public int getHoraPromesa() {
        return horaPromesa;
    }

    public void setHoraPromesa(int horaPromesa) {
        this.horaPromesa = horaPromesa;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getUbiX() {
        return ubiX;
    }

    public void setUbiX(double ubiX) {
        this.ubiX = ubiX;
    }

    public double getUbiY() {
        return ubiY;
    }

    public void setUbiY(double ubiY) {
        this.ubiY = ubiY;
    }

    public TipoUrgencia getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(TipoUrgencia urgencia) {
        this.urgencia = urgencia;
    }
}
