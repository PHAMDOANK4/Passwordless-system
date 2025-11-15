package ma.laoma.Passwordless_system.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import ma.laoma.Passwordless_system.enumeration.WebauthnTransportEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "webauthn_credentials")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebauthnCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private byte[] aaguid;
    private Boolean backupEligible;
    private Boolean backupState;
    private Boolean cloneWarning;
    private LocalDateTime createdAt;

    private byte[] credentialId;
    private byte[] publicKey;

    private Long signCount;

    @OneToOne
    @JoinColumn(name = "factor_id", nullable = false)
    private AuthFactor factor;

    @OneToMany(mappedBy = "credential")
    private List<WebauthnTransportEnum> transports;
}
