package CosasMias;

import Basico.Leer;
/**
 * usuario
 */
class usuario {
    int id;
    String nombre;
    double dinero;
    String password;
    void meter(int x){
        dinero = dinero + x;
    }
    void sacar(int x){
        boolean y = false;
        do {
            if (dinero<x) {
                System.out.print("No tienes suficiente dinero: ");
                x = Leer.datoInt();
                y = true;
            }else{
                dinero = dinero - x;
                y = false;
            }
        } while (y);
    }
    void mostrar(){
        System.out.println("id: "+id +", nombre: "+nombre+", cuenta con: "+dinero);
    }
    void transferir(int x, usuario[] banco, int id1){
        if (x>dinero) {
            System.out.println("No tiene sufiencte dinero");
        } else {
            banco[id1].dinero = banco[id1].dinero + x;
            dinero = dinero - x;
            banco[id].mostrar();
        }
    }
    void borrar(){
        nombre = "";
        password = "";
        System.out.println("se ha retirado "+dinero+" pesos");
        dinero = 0;
    }
}
public class banco {
    public static void main(String[] args) {
         
        System.out.print("Cuantos Usuarios puede tener el banco?: ");
        int n = Leer.datoInt();
        usuario[] banco = new usuario[n];
        for (int i = 0; i < banco.length; i++) {
            banco[i] = new usuario();
        }
        funcionamiento(banco, n);
       
    }

    private static void funcionamiento(usuario[] banco, int n) {
        int num = 1;
        do {
        int x = opciones();
        switch (x) {
            case 1:
                 num = crearCuenta(num, banco, n);
                break;
            case 2:
                meterDinero(num, banco);
                break;
            case 3:
                sacarDinero(num, banco);
                break;
            case 4:
                mostrarDinero(num, banco);
                break;
            case 5:
                transferencia(banco, num);
                break;
            default:
                break;
            }
        } while (true);
    }

    private static void transferencia(usuario[] banco, int num) {
        System.out.print("Escribe tu id: ");
        int id = Leer.datoInt();
        if (id > num) {
            System.out.println("No existe la cuenta");
        }else{
            System.out.print("Ingrese la contraseña de la cuenta: ");
            String contraseña = Leer.dato();
            if (contraseña.equalsIgnoreCase(banco[id].password)) {
                System.out.print("Escriba el id del remitente");
                int id2 = Leer.datoInt();
                System.out.println("Escriba cuanto dinero quiere mandar: ");
                int x2 = Leer.datoInt();
                banco[id].transferir(x2, banco, id2);
            }else{
                System.out.println("contraseña incorrecta");
            }
        }
    }

    private static void mostrarDinero(int num, usuario[] banco) {
        
            System.out.println("Ingrese el id: ");
            int id = Leer.datoInt();
            if (id > num) {
                System.out.println("No existe la cuenta");
            }else{
                banco[id].mostrar();
            }
            
    }

    private static void sacarDinero(int num, usuario[] banco) { 

            System.out.print("Ingrese el id: ");
            int id  = Leer.datoInt();
            if (id > num) {
                System.out.println("No existe la cuenta");
            } else {
                System.out.print("Ingrese la contraseña de la cuenta: ");
                String contraseña = Leer.dato();
                if (contraseña.equalsIgnoreCase(banco[id].password)) {
                    System.out.print("Cuanto dinero quiere sacar?: ");
                    int x3 = Leer.datoInt();
                    if (x3>banco[id].dinero) {
                        System.out.println("No cuenta con suficiente saldo");
                    }else{
                        banco[id].sacar(x3);
                        System.out.println("Su nuevo saldo es de: "+banco[id].dinero);
                    }
                } else {
                    System.out.println("Nombre equivocado intente todo de nuevo");
                }
            }
    }

    private static void meterDinero(int num, usuario[] banco) {
        
            System.out.print("Ingrese el id: ");
            int id = Leer.datoInt();
            if (id > num) {
                System.out.println("No existe la cuenta");
            }else{
                System.out.print("Cuanto dinero quiere ingresar?: ");
                int x2 = Leer.datoInt();
                banco[id].meter(x2);
                System.out.println("Su nuevo saldo es de: "+banco[id].dinero);
            }
    }
    
    private static int crearCuenta(int num, usuario[] banco, int n) {
        if (num>n){
            System.out.println("Ya no se pueden crear cuentas");
        }else{
            banco[num].id = num;
            System.out.println("Su id sera: "+banco[num].id);
            System.out.println("Escriba su contraseña");
            banco[num].password = Leer.dato();
            System.out.print("Ingrese Nombre: ");
            banco[num].nombre = Leer.dato();
            System.out.print("Cuanto sera su primer monto?: ");
            banco[num].dinero = Leer.datoDouble();
            num = num + 1;
        }
        return num;
    }

    private static int opciones() {
        System.out.println("Que desea hacer?");
        System.out.println("1 crear cuenta 2 ingresar dinero 3 sacar dinero 4 mostrar 5 transferencia");
        return Leer.datoInt();
    }
}