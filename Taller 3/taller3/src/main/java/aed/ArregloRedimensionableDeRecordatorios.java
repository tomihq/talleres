package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    Recordatorio[] recordatorios;
    int elementos = 0;
    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorios = new Recordatorio[0];
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        vector.copiar();
    }

    public int longitud() {
        return this.recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        if(this.recordatorios.length == elementos){
            this.crearNuevoArreglo();
        }
        this.recordatorios[this.longitud()] = i;
        this.elementos +=1;
    }

    public Recordatorio obtener(int i) {
        return this.obtener(i);
    }

    public void crearNuevoArreglo(){
        int cap = this.recordatorios.length == 0 ? 1 : this.recordatorios.length * 4  ;
        Recordatorio[] recordatoriosRedimensionado = new Recordatorio[cap];
        for(int i = 0; i<this.recordatorios.length; i++){
            recordatoriosRedimensionado[i] = this.recordatorios[i];
        }
        this.elementos = cap;
        this.recordatorios = recordatoriosRedimensionado;

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
