package pe.edu.upeu.sysalmacenfx.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Usuario;
import pe.edu.upeu.sysalmacenfx.repositorio.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    public Usuario save(Usuario to) {
        return repo.save(to);


    }

    public List<Usuario> List() {
        return repo.findAll();

    }
    //U
    public Usuario update(Usuario to, Long id) {
        try {
            Usuario toe = repo.findById(id).get();
            toe.setIdUsuario(to.getIdUsuario());
            if (toe!=null){
                toe.setIdUsuario(to.getIdUsuario());

            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());

        }
        return null;


    }
    public Usuario update(Usuario to){
        return  repo.save(to);
    }
    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    public  Usuario buscarId(Long id){
        return  repo.findById(id).get();
    }
    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar =new ArrayList<>();
        for (Usuario cate : repo.findAll()) {
            listar.add(new ComboBoxOption(String
                    .valueOf(cate.getIdUsuario()),
                    cate.getClave()
            ));

        }
        return listar
                ;

    }
}


