package ma.laoma.Passwordless_system.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import ma.laoma.Passwordless_system.enumeration.AuthFactorStatusEnum;
import ma.laoma.Passwordless_system.enumeration.AuthFactorTypeEnum;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auth_factors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private Boolean isPrimary;
    private LocalDateTime lastUsedAt;

    @Column(columnDefinition = "json")
    private String metadata;

    private String name;

    @Enumerated(EnumType.STRING)
    private AuthFactorStatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthFactorTypeEnum type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Children
    @OneToOne(mappedBy = "factor")
    private TotpFactor totpFactor;

    @OneToOne(mappedBy = "factor")
    private WebauthnCredential webauthnCredential;

    @OneToMany(mappedBy = "factor")
    private List<OtpRequest> otpRequests;

    @OneToMany(mappedBy = "factor")
    private List<AuthAuditLog> logs;
}
