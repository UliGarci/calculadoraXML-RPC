package controller;

public class BeanCalcu {
    private int id;
    private String operacion;
    private int num1;
    private int num2;
    private int resultado;
    private String fecha;

    public BeanCalcu() {
    }

    public BeanCalcu(int id, String operacion, int num1, int num2, int resultado, String fecha) {
        this.id = id;
        this.operacion = operacion;
        this.num1 = num1;
        this.num2 = num2;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
