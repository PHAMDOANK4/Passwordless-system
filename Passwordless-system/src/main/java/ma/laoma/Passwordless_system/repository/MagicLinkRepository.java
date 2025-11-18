package ma.laoma.Passwordless_system.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.laoma.Passwordless_system.entity.MagicLink;
@Repository
public interface MagicLinkRepository extends JpaRepository<MagicLink, Long> {
    
}
