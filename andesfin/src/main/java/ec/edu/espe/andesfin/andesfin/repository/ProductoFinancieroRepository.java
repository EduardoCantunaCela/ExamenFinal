package ec.edu.espe.andesfin.andesfin.repository;

import ec.edu.espe.andesfin.andesfin.entity.ProductoFinanciero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductoFinancieroRepository extends JpaRepository<ProductoFinanciero, UUID> {
    List<ProductoFinanciero> findByActivoTrue();
    List<ProductoFinanciero> findByCostoLessThanEqualAndActivoTrue(BigDecimal maxCosto);
}