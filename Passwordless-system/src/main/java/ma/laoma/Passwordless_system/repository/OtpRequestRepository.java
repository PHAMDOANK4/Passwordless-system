package ma.laoma.Passwordless_system.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.laoma.Passwordless_system.entity.OtpRequest;
@Repository
public interface OtpRequestRepository extends JpaRepository<OtpRequest, Long> {
    
}
