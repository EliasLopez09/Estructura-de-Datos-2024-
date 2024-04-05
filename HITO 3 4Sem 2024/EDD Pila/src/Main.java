import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int opcion = 0;
        int nodo = 0;
        Pila pila = new Pila();

        do {

            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menio de Opciones\n\n"
                + "1. Insertar un nodo\n"
                + "2. Eliminar un nodo\n"
                +"3. ¿La pila esta vacia?\n"
                +"4,  ¿Cual es el ultimo valor ingresado en la pila?\n"
                +"5. ¿Cuantos nodos tiene la pila?\n"
                +"6. Vaciar Pila\n"
                +"7. Mostrar ocntenido de la pila\n"
                +"8. Salir\n\n"));

                switch (opcion){
                    case 1:
                        String input = JOptionPane.showInputDialog(null, "Por favor ingrese un valor");
                        nodo = Integer.parseInt(input);
                        pila.InsertarNodo(nodo);

                        break;
                    case 2:
                        if(!pila.PilaVacia()){
                            JOptionPane.showMessageDialog(null,"Se ha eliminado un nodo con el valor:  "
                            + pila.EliminarNodo());

                        }else{
                            JOptionPane.showMessageDialog(null,"");
                        }
                        break;
                    case 3:
                        if(pila.PilaVacia()){
                            JOptionPane.showMessageDialog(null,"la pila esta vacia");
                        }else{
                            JOptionPane.showMessageDialog(null,"La pila NO vacia");
                        }
                        break;
                    case 4:
                        if(!pila.PilaVacia()){
                            JOptionPane.showMessageDialog(null, "El ultiom valor ingresado en la pila es: "
                            +pila.MostrarUltimoValorIngresado());
                        }else{
                            JOptionPane.showMessageDialog(null, "La pila esta vacia ");
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,"La pila ocntiene"+pila.TamanoPila()+" nodos.");
                        break;
                    case 6:
                        if(!pila.PilaVacia()){
                            pila.VaciarPila();
                            JOptionPane.showMessageDialog(null,"se ha vaciado la pila");
                        }else{
                                JOptionPane.showMessageDialog(null,"La pila esta vacia ");

                            }
                        break;
                    case 7:
                        pila.MostrarValores();
                        break;
                    case 8:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opción incorrecta , vuelva a intentar");
                        break;
                }
            }catch (NumberFormatException e){

            }
        }while (opcion !=8);
    }
}