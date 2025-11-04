package ma.laoma.Passwordless_system.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "auth_factors",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "type", "name"}))
public class AuthFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, columnDefinition = "ENUM('webauthn', 'totp', 'email_otp', 'sms_otp', 'recovery_code', 'social')")
    private FactorType type;

    @Column(name = "name")
    private String name;

    @Column(name = "is_primary")
    private Boolean isPrimary = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('enabled', 'disabled', 'compromised')")
    private FactorStatus status = FactorStatus.ENABLED;

    @Column(name = "last_used_at")
    private LocalDateTime lastUsedAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata", columnDefinition = "json")
    private String metadata;

    // Relationships
    @OneToOne(mappedBy = "authFactor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private WebAuthnCredential webAuthnCredential;

    @OneToOne(mappedBy = "authFactor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TotpFactor totpFactor;

    // Enums
    public enum FactorType {
        WEBAUTHN, TOTP, EMAIL_OTP, SMS_OTP, RECOVERY_CODE, SOCIAL
    }

    public enum FactorStatus {
        ENABLED, DISABLED, COMPROMISED
    }

    // Constructors
    public AuthFactor() {}

    public AuthFactor(User user, FactorType type, String name) {
        this.user = user;
        this.type = type;
        this.name = name;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public FactorType getType() { return type; }
    public void setType(FactorType type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Boolean getIsPrimary() { return isPrimary; }
    public void setIsPrimary(Boolean isPrimary) { this.isPrimary = isPrimary; }

    public FactorStatus getStatus() { return status; }
    public void setStatus(FactorStatus status) { this.status = status; }

    public LocalDateTime getLastUsedAt() { return lastUsedAt; }
    public void setLastUsedAt(LocalDateTime lastUsedAt) { this.lastUsedAt = lastUsedAt; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getMetadata() { return metadata; }
    public void setMetadata(String metadata) { this.metadata = metadata; }

    public WebAuthnCredential getWebAuthnCredential() { return webAuthnCredential; }
    public void setWebAuthnCredential(WebAuthnCredential webAuthnCredential) { this.webAuthnCredential = webAuthnCredential; }

    public TotpFactor getTotpFactor() { return totpFactor; }
    public void setTotpFactor(TotpFactor totpFactor) { this.totpFactor = totpFactor; }
}
