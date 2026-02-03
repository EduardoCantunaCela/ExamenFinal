package ec.edu.espe.andesfin.andesfin.repository;

import ec.edu.espe.andesfin.andesfin.entity.Simulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SimulacionRepository extends JpaRepository<Simulacion, UUID> {
    List<Simulacion> findByUsuarioId(UUID usuarioId);
}