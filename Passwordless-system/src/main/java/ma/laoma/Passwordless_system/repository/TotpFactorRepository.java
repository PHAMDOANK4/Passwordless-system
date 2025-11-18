package ma.laoma.Passwordless_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.laoma.Passwordless_system.entity.TotpFactor;
@Repository
public interface TotpFactorRepository extends JpaRepository<TotpFactor, Long> {
    
}