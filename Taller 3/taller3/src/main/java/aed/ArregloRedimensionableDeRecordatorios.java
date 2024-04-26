package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    Recordatorio[] recordatorios;
    public ArregloRedimensionableDeRecordatorios() {
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        vector.copiar();
    }

    public int longitud() {
        return this.recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        this.recordatorios[this.longitud()] = i;
    }

    public Recordatorio obtener(int i) {
        return this.obtener(i);
    }

    public void quitarAtras() {
        System.arraycopy(this.recordatorios, 0, this.recordatorios, this.recordatorios.length-1, this.recordatorios.length-1);
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.recordatorios[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios arregloRecordatorioNuevo = new ArregloRedimensionableDeRecordatorios();
        for(int i=0; i<recordatorios.length; i++){
            arregloRecordatorioNuevo.agregarAtras(new Recordatorio(this.recordatorios[i].mensaje, this.recordatorios[i].fecha, this.recordatorios[i].horario));
            
        }

        return arregloRecordatorioNuevo;
    }

}
