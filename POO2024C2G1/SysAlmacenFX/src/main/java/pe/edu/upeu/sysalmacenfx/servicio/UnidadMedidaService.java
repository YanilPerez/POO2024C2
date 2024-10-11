package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.Producto;
import pe.edu.upeu.sysalmacenfx.modelo.UnidadMedida;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.repositorio.UnidadMedidaRepository;

@Service
public class UnidadMedidaService {
    @Autowired
    UnidadMedidaRepository repo;
    //c
    public UnidadMedida save(UnidadMedida to) {
        return repo.save(to);
    }
    //R
    public List<UnidadMedida> list(){
        return repo.findAll();
    }

    //U
    public UnidadMedida uptade(UnidadMedida to, Long id) {
        try {
            UnidadMedida toe = repo.findById(id).get();
            if (toe != null) {
                toe.setNombreMedida(to.getNombreMedida());
            }
            return repo.save(toe);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    public UnidadMedida uptade(UnidadMedida to){
        return repo.save(to);
    }

    //D
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public UnidadMedida buscar(Long id) {
        return repo.findById(id).get();
    }
    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar =new ArrayList<>();

        for (UnidadMedida cate : repo.findAll()) {
            listar.add(new ComboBoxOption(
                    String.valueOf(cate.getIdUnidad()),
                    cate.getNombreMedida()));
        }
        return listar;

    }
}
