package pe.edu.upeu.sysalmacenfx.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysalmacenfx.modelo.Marca;

public interface MarcaRepository extends JpaRepository<Marca,Long> {
}
