/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicio;

import java.util.Arrays;

public class Inicio {

    String arreglo[];
    int tamano, contador;

    //constructor
    public Inicio(int tamano) {
        this.tamano = tamano;
        arreglo = new String[this.tamano];
        Arrays.fill(arreglo, "-1");
    }

    //arreglo 1 = los llenados por el usuario
    //arreglo 2 = el arreglo llenado con -1
    public void funcionHash(String cadenaArreglo[], String arreglo[]) {
        //el tamaño del primer arreglo
        for (int i = 0; i < cadenaArreglo.length; i++) {
            //se guardara el valor del arreglo 1
            String elemento = cadenaArreglo[i];
            //indiceArreglo se guardara el valor de elemento modulo del tamaño del arreglo
            //ejemplo el primer valor es 10 % 8(tamano) = 2
            //osea que el indice donde se guardara sera el 2
            int indiceArreglo = Integer.parseInt(elemento) % cadenaArreglo.length;
            //aqui me dice en que indice se guardara y que elemento es
            System.out.println("El indice es  " + indiceArreglo + " para el elemento " + elemento);
            //tratando las coliciones
            //se pregunta si en el arreglo[2] es diferente a -1
            //2 porque es la el que vamos trabajando si es igual quiere decir que esta vacio asi que saltara
            //el while
            //si esta ocupado por otro numero
            while (arreglo[indiceArreglo] != "-1") {
                //el indice arreglo parasar a la siguiente posicion
                indiceArreglo++;
                //solo es un mensaje
                System.out.println("Ocurrio una Colision en el indice " + (indiceArreglo - 1) + " cambiar al indice "
                        + indiceArreglo);
                //
                indiceArreglo %= cadenaArreglo.length;
            }
            //si se lo salta en el arreglo 2 guardara el elemento
            arreglo[indiceArreglo] = elemento;
        }
    }

    //Metodo para mostrar la tabla
    public void mostrar() {
        int incremento = 0, i, j;
        for (i = 0; i < 1; i++) {
//            incremento += 8;
            incremento += tamano;
            for (j = 0; j < 71; j++) {
                System.out.print("-");
            }
            System.out.println();
//            for (j = incremento - 8; j < incremento; j++) {
            for (j = incremento - tamano; j < incremento; j++) {
                System.out.format("|%3s" + "", j);
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println();
//            for (j = incremento - 8; j < incremento; j++) {
            for (j = incremento - tamano; j < incremento; j++) {
                if (arreglo[j].equals("-1")) {
                    System.out.print("|");
                } else {
                    System.out.print(String.format("|%3s" + "", arreglo[j]));
                }
            }
            System.out.println("|");
            for (j = 0; j < 71; j++) {
                System.out.print("-");
            }
        }
    }
    
    //Metodo para buscar una clave
    //le paso el elemento
    public String buscarClave(String elemento){
        //indice arreglo == elemento % de tamano
        int indiceArreglo = Integer.parseInt(elemento) % 8;
        System.out.println(indiceArreglo);
        //contador
        contador = 0;
        //arreglo 1 de la posicion indiceArreglo debe ser diferente a -1
        //osea que todos
        while(arreglo[indiceArreglo] != "-1"){
            //arreglo del indice == elemento
            if(arreglo[indiceArreglo] == elemento){
                //pues solo lo imprime y lo devuelve
                System.out.println("El elemento " + elemento + " fue encontrado en el indice " + indiceArreglo);
                return arreglo[indiceArreglo];
            }
            //si no es asi pues le aumento al indiceArreglo
            indiceArreglo++;
            //hago la misma operacion de arriba para resetear cuando llegue al limite
            indiceArreglo %= tamano;
            contador++;
            //si supera el tamaño es que no esta
            if(contador > 8){
                break;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Inicio inicio = new Inicio(8);
        String[] elementos = {"6","33","21","10","12","14","56","100"};
        inicio.funcionHash(elementos, inicio.arreglo);
        inicio.mostrar();
        System.out.println("");
        String buscado = inicio.buscarClave("100");
        if(buscado == null){
            System.out.println("El elemento 12 no se encuentra en la tabla");
        }
    }

}
