package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;
    //c
    public Categoria save(Categoria to) {
        return repo.save(to);
    }
    //R
    public List<Categoria> list(){
        return repo.findAll();
    }

    //U
    public Categoria uptade(Categoria to, Long id) {
        try {
            Categoria toe = repo.findById(id).get();
            if (toe != null) {
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    public Categoria uptade(Categoria to){
        return repo.save(to);
    }

    //D
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Categoria buscar(Long id) {
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar =new ArrayList<>();

        for (Categoria cate : repo.findAll()) {
            listar.add(new ComboBoxOption(
                    String.valueOf(cate.getIdCategoria()),
                    cate.getNombre()));
        }
        return listar;

    }
}
