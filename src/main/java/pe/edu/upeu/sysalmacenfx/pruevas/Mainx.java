package pe.edu.upeu.sysalmacenfx.pruevas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;

import java.util.List;
import java.util.Scanner;

@Component
public class Mainx {
    @Autowired
    CategoriaRepository repository;

    public void registro() {
        System.out.println("MAIN CATEGORIA");
        Categoria ca= new Categoria();
        ca.setNombre("Fruta");
        Categoria dd=repository.save(ca);
        System.out.println("Reporte.");
        System.out.println(dd.getIdCategoria()+" "+dd.getNombre());
        Scanner scanner = new Scanner(System.in);
        String command;


        while (true) {
            System.out.println("Ingrese un comando (crear, leer, actualizar, borrar, salir):");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "crear":
                    crearCategoria(scanner);
                    break;
                case "leer":
                    leerCategoria(scanner);
                    break;
                case "actualizar":
                   actualizarCategoria(scanner);
                    break;
                case "borrar":
                    borrarCategoria(scanner);
                    break;
                case "salir":
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Comando no reconocido.");
            }
        }
    }

    private void crearCategoria(Scanner scanner) {
        System.out.println("Ingrese el nombre de la nueva categoría:");
        String nombre = scanner.nextLine();
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        Categoria savedCategoria = repository.save(categoria);
        System.out.println("Categoría creada: " + savedCategoria.getIdCategoria() + " " + savedCategoria.getNombre());
    }

    private void leerCategoria(Scanner scanner) {
        int listaID;
        System.out.println("1.Mostrar lista completa 2.Mostrar por ID:");
        listaID = scanner.nextInt();
        switch (listaID){
            case 1:
                List<Categoria> datos=repository.findAll();
                System.out.println("ID\t Nombre");

                break;
            case 2:
                System.out.println("Ingrese el ID de la categoría a leer:");
                Long id = Long.valueOf(scanner.nextLine());
                Categoria categoria = repository.findById(id).orElse(null);
                if (categoria != null) {
                    System.out.println("Categoría encontrada: " + categoria.getIdCategoria() + " " + categoria.getNombre());
                } else {
                    System.out.println("Categoría no encontrada.");
                }
                break;
            default:
                System.out.println("Obcion no disponble");
        }

    }
    private void borrarCategoria(Scanner scanner){
        System.out.println("Ingrese el ID de la categoría a borrar:");
        Long id = Long.valueOf(scanner.nextLine());
        if (repository.existsById(id)) {
            repository.deleteById(id);
            System.out.println("Categoría borrada: " + id);
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }
    private void actualizarCategoria(Scanner scanner){

    }



    public static void main(String[]args){
        Mainx dd=new Mainx();
        dd.registro();
    }
}
