import javax.swing.*;

public class Pila {
    private Nodo UltimoValorIngresado;
    int tamano = 0;
    String Lista = "";

    public  Pila(){
        UltimoValorIngresado = null;// existe el valor pero es nulo
        tamano = 0;//es un contaor que inicializa en 0
    }
    //Metodo para saber cuando la pila esta vacia
    public  boolean PilaVacia(){
        return UltimoValorIngresado == null; //Devuelve true si el uttimo valore ingresado es null (pila vacia)


    }
    //Metodo para insertar un nodo en la pila
    public void InsertarNodo(int nodo){
        Nodo nuevo_nodo = new Nodo(nodo);//creamso un nuevo objeto llamado nuevo_nodo
        nuevo_nodo.siguiente = UltimoValorIngresado;//el
        UltimoValorIngresado = nuevo_nodo;
        tamano++;//el tamaño incrementa
    }
    //metodo para eliminar un nodo de la pila
    public int EliminarNodo(){
        int auxiliar = UltimoValorIngresado.informacion;
        UltimoValorIngresado = UltimoValorIngresado.siguiente;
        tamano--;
        return auxiliar;
    }
    public int MostrarUltimoValorIngresado(){
        return UltimoValorIngresado.informacion;
    }

    public int TamanoPila (){
        return  tamano;
    }

    //metodo para vaciar la pila
    public void VaciarPila(){
        while (!PilaVacia()){
            EliminarNodo();
        }
    }
    //metodo para mostrar el contenido de la pila
    public void MostrarValores(){
        Nodo recorrido = UltimoValorIngresado;

        while (recorrido != null){
            Lista += recorrido.informacion + "\n";
            recorrido=recorrido.siguiente;

         }
        JOptionPane.showConfirmDialog(null, Lista);
        Lista = "";

    }

}
