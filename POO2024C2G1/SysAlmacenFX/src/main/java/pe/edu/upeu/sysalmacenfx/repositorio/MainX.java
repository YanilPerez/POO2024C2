package pe.edu.upeu.sysalmacenfx.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.sysalmacenfx.SysAlmacenFxApplication;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;

import java.util.List;
import java.util.Scanner;

@Component
public class MainX {
    @Autowired
    CategoriaRepository repository;
    Scanner scanner = new Scanner(System.in);

    public void registro() {

        System.out.println("Ingrese el nombre de la nueva categoría:");
        String nombre = scanner.nextLine();
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        Categoria savedCategoria = repository.save(categoria);
        System.out.println("Categoría creada: " + savedCategoria.getIdCategoria() + " " + savedCategoria.getNombre());
    }

    public void listar() {
        List<Categoria> datos = repository.findAll();
        System.out.println("ID\tNombre");
        for (Categoria ca : datos) {
            System.out.println(ca.getIdCategoria() + "\t" + ca.getNombre());
        }
    }

    public void salir() {
        scanner.close();
    }

    private void actualizar() {
        System.out.println("Ingrese el ID de la categoría a actualizar:");
        Long id = Long.valueOf(scanner.nextLine());
        Categoria categoria = repository.findById(id).orElse(null);
        if (categoria != null) {
            System.out.println("Ingrese el nuevo nombre:");
            String nuevoNombre = scanner.nextLine();
            categoria.setNombre(nuevoNombre);
            repository.save(categoria);
            System.out.println("Categoría actualizada: " + categoria.getIdCategoria() + " " + categoria.getNombre());
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }
    private void borrar() {
        System.out.println("Ingrese el ID de la categoría a borrar:");
        Long id = Long.valueOf(scanner.nextLine());
        if (repository.existsById(id)) {
            repository.deleteById(id);
            System.out.println("Categoría borrada: " + id);
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    public void menu(){
        int opc=0;
        Scanner cs=new Scanner(System.in);
        String mensaje="Seleccione una opcion: \n1.Crear\n2.Listar\n3.Actualizar\n4.borrar\n0.Salir";
        System.out.println(mensaje);
        opc=Integer.parseInt(cs.next());
        do {
            switch (opc){
                case 1:{registro();}
                case 2:{listar();}
                case 3:{actualizar();}
                case 4:{borrar();}
                case 0:{salir();}
            }
            System.out.println(mensaje);
            opc=Integer.parseInt(cs.next());
        }while(opc!=0);
    }


}



