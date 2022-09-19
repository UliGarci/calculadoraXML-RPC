package client;

import MySQLConnection.MySQLConnection;
import controller.BeanCalcu;
import controller.DaoCalcu;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import server.Methods;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Scanner;

public class RPCClient {

    public static void main(String[] args) throws XmlRpcException, IOException {
        //ULISES DANIEL GARCÍA MÉNDEZ
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        PropertyHandlerMapping mapping = new PropertyHandlerMapping();
        mapping.addHandler("Methods", Methods.class);

        DaoCalcu daoCalcu = new DaoCalcu();
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        String num1 = "";
        String num2 = "";
        int id = 0;
        String f= String.valueOf(LocalDateTime.now());
        do {
            System.out.println("CALCULADORA\n1.-Suma\n2.-Resta\n3.-Multiplicacion\n4.-Division\n5.-Expente\n6.-Raiz\n7.-Historial\n8.-Salir");
            opcion = sc.next();
            if (isNumber(opcion)){
                switch (Integer.parseInt(opcion)){
                    case 1:
                        do {
                            System.out.println("Ingresar el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num1));
                        do {
                            System.out.println("Ingresar el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num2));

                        Object[] numbersE1 = {Integer.parseInt(num1),Integer.parseInt(num2)};
                        int responseE1 = (int) client.execute("Methods.suma",numbersE1);
                        System.out.println("La suma de "+num1+" + "+num2+" es: "+responseE1);
                        //LLAMAR AL SERVICIO WEB
                        int numero1E1 = Integer.parseInt(num1);
                        int numero2E1 = Integer.parseInt(num2);
                        daoCalcu.insertarCalculo(id,"suma",numero1E1,numero2E1,responseE1,f);
                        break;

                    case 2:
                        do {
                            System.out.println("Ingresar el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num1));
                        do {
                            System.out.println("Ingresar el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num2));
                        int numero1E2 = Integer.parseInt(num1);
                        int numero2E2 = Integer.parseInt(num2);
                        Object[] numbersE2 = { numero1E2,numero2E2};
                        int responseE2 = (int) client.execute("Methods.resta",numbersE2);
                        System.out.println("La resta de "+num1+" - "+num2+": "+responseE2);
                        //GUARDAR EN BASE DE DATOS
                        daoCalcu.insertarCalculo(id,"resta",numero1E2,numero2E2,responseE2,f);
                        break;

                    case 3:
                        do {
                            System.out.println("Ingresar el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num1));
                        do {
                            System.out.println("Ingresar el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num2));
                        int numero1E3 = Integer.parseInt(num1);
                        int numero2E3 = Integer.parseInt(num2);
                        Object[] numbersE3 = {numero1E3,numero2E3};
                        int responseE3 = (int) client.execute("Methods.multi",numbersE3);
                        System.out.println("La multiplicacion de "+num1+" * "+num2+"= "+responseE3);
                        daoCalcu.insertarCalculo(id,"multiplicacion",numero1E3,numero2E3,responseE3,f);
                        break;

                    case 4:
                        do {
                            System.out.println("Ingresar el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num1));
                        do {
                            System.out.println("Ingresar el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num2));
                        int numero1E4 = Integer.parseInt(num1);
                        int numero2E4 = Integer.parseInt(num2);
                        Object[] numbersE4 = {numero1E4,numero2E4};
                        int responseE4 = (int) client.execute("Methods.divi",numbersE4);
                        System.out.println("La division de "+num1+" / "+num2+"= "+responseE4);
                        //GUARDADO DE BASE DE DATOS
                        daoCalcu.insertarCalculo(id,"division",numero1E4,numero2E4,responseE4,f);
                        break;

                    case 5:
                        do {
                            System.out.println("Ingresar el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num1));
                        do {
                            System.out.println("Ingresar el segundo valor");
                            num2 = sc.next();
                            if (!isNumber(num2)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num2));
                        int numero1E5 = Integer.parseInt(num1);
                        int numero2E5 = Integer.parseInt(num2);
                        Object[] numbersE5 = {numero1E5,numero2E5};
                        int responseE5 = (int) client.execute("Methods.expo",numbersE5);
                        System.out.println("El resultado de "+num1+" ^ "+num2+"= "+responseE5);
                        daoCalcu.insertarCalculo(id,"exponente",numero1E5,numero2E5,responseE5,f);
                        break;

                    case 6:
                        do {
                            System.out.println("Ingresar el primer valor");
                            num1 = sc.next();
                            if (!isNumber(num1)){
                                System.out.println("Error.. Ingresar valor numerico");
                            }
                        }while (!isNumber(num1));
                        Methods m = new Methods();
                        System.out.println("La raiz de "+num1+" es: "+m.raiz(Integer.parseInt(num1)));
                        //GUARDADO EN BASE DE DATOS
                        int numero1E6 = Integer.parseInt(num1);
                        daoCalcu.insertarCalculo(id,"raiz",numero1E6,0,m.raiz(Integer.parseInt(num1)),f);
                        break;

                    case 7:
                        System.out.println(daoCalcu.findAll());
                        break;
                    case 8:
                        System.out.println("CHAO :)");
                        break;
                    default:
                        System.out.println("Ingresar una opcion valida");
                }
            }else{
                System.out.println("Ingresar un valor valido");
            }
        }while (!opcion.equals("7"));


    }

    public static boolean isNumber(String number){
        try {
            int num = Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}
