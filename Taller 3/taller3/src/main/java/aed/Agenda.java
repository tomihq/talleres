package aed;

public class Agenda {

    Recordatorio[] recordatorios;
    Fecha fechaActual;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios[this.recordatorios.length] = recordatorio;

    }

    @Override
    public String toString() {
        String mensaje = this.fechaActual.fechaCompleta() + "\n" + "=====" + "\n";
        for(int i = 0; i<this.recordatorios.length; i++){
            if(this.recordatorios[i].fecha.dia == fechaActual.dia && this.recordatorios[i].fecha.mes == fechaActual.mes){
                mensaje.concat(this.recordatorios[i].mensaje() + "\n");
            }
        }
        return mensaje;
    }

    public void incrementarDia() {
       this.fechaActual.incrementarDia();

    }

    public Fecha fechaActual() {
        return this.fechaActual;
    }

}
