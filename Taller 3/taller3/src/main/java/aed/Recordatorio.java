package aed;

public class Recordatorio {
    String mensaje;
    Fecha fecha; 
    Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.horario = horario; 
    }

    public Horario horario() {
       return this.horario;
    }

    public Fecha fecha() {
        return this.fecha;
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje + " @ " + this.fecha.fechaCompleta() + " " + this.horario.horarioCompleto();
    }

    @Override
    public boolean equals(Object otro) {
       if(otro == null || otro.getClass() != this.getClass()) return false;
       Recordatorio otroRecordatorio = (Recordatorio) otro;
       return otroRecordatorio.fecha == this.fecha && otroRecordatorio.horario == this.horario && otroRecordatorio.mensaje == this.mensaje;
    }

}
