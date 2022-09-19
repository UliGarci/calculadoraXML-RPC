package server;

public class Methods {
    //ULISES DANIEL GARCÍA MÉNDEZ
    public int suma(int num1, int num2){
        return num1+num2;
    }

    public int resta(int num1, int num2){
        return num1-num2;
    }

    public int multi(int num1, int num2){
        return num1*num2;
    }

    public int divi(int num1, int num2){
        return num1/num2;
    }

    public int expo(int num1, int num2){
        if(num2==0){
            return 1;
        }else{
            return num1*expo(num1,num2-1);
        }
    }

    public int raiz(int num1){
        return (int) Math.sqrt(num1);
    }
}
