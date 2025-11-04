package ma.laoma.Passwordless_system.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "webauthn_credentials")
public class WebAuthnCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factor_id", nullable = false)
    private AuthFactor authFactor;

    @Column(name = "credential_id", nullable = false, unique = true, columnDefinition = "VARBINARY(255)")
    private byte[] credentialId;

    @Lob
    @Column(name = "public_key", nullable = false, columnDefinition = "BLOB")
    private byte[] publicKey;

    @Column(name = "sign_count")
    private Long signCount = 0L;

    @Column(name = "clone_warning")
    private Boolean cloneWarning = false;

    @Column(name = "backup_eligible")
    private Boolean backupEligible = false;

    @Column(name = "backup_state")
    private Boolean backupState = false;

    @Column(name = "aaguid", columnDefinition = "VARBINARY(16)")
    private byte[] aaguid;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "webAuthnCredential", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WebAuthnTransport> transports = new ArrayList<>();

    // Constructors
    public WebAuthnCredential() {}

    public WebAuthnCredential(AuthFactor authFactor, byte[] credentialId, byte[] publicKey) {
        this.authFactor = authFactor;
        this.credentialId = credentialId;
        this.publicKey = publicKey;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AuthFactor getAuthFactor() { return authFactor; }
    public void setAuthFactor(AuthFactor authFactor) { this.authFactor = authFactor; }

    public byte[] getCredentialId() { return credentialId; }
    public void setCredentialId(byte[] credentialId) { this.credentialId = credentialId; }

    public byte[] getPublicKey() { return publicKey; }
    public void setPublicKey(byte[] publicKey) { this.publicKey = publicKey; }

    public Long getSignCount() { return signCount; }
    public void setSignCount(Long signCount) { this.signCount = signCount; }

    public Boolean getCloneWarning() { return cloneWarning; }
    public void setCloneWarning(Boolean cloneWarning) { this.cloneWarning = cloneWarning; }

    public Boolean getBackupEligible() { return backupEligible; }
    public void setBackupEligible(Boolean backupEligible) { this.backupEligible = backupEligible; }

    public Boolean getBackupState() { return backupState; }
    public void setBackupState(Boolean backupState) { this.backupState = backupState; }

    public byte[] getAaguid() { return aaguid; }
    public void setAaguid(byte[] aaguid) { this.aaguid = aaguid; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<WebAuthnTransport> getTransports() { return transports; }
    public void setTransports(List<WebAuthnTransport> transports) { this.transports = transports; }
}