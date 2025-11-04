package ma.laoma.Passwordless_system.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "totp_factors")
public class TotpFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factor_id", nullable = false, unique = true)
    private AuthFactor authFactor;

    @Column(name = "secret", nullable = false, columnDefinition = "VARBINARY(255)")
    private byte[] secret;

    @Column(name = "algorithm")
    private String algorithm = "SHA1";

    @Column(name = "digits")
    private Integer digits = 6;

    @Column(name = "period")
    private Integer period = 30;

    @Column(name = "counter")
    private Long counter = 0L;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Constructors
    public TotpFactor() {}

    public TotpFactor(AuthFactor authFactor, byte[] secret) {
        this.authFactor = authFactor;
        this.secret = secret;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AuthFactor getAuthFactor() { return authFactor; }
    public void setAuthFactor(AuthFactor authFactor) { this.authFactor = authFactor; }

    public byte[] getSecret() { return secret; }
    public void setSecret(byte[] secret) { this.secret = secret; }

    public String getAlgorithm() { return algorithm; }
    public void setAlgorithm(String algorithm) { this.algorithm = algorithm; }

    public Integer getDigits() { return digits; }
    public void setDigits(Integer digits) { this.digits = digits; }

    public Integer getPeriod() { return period; }
    public void setPeriod(Integer period) { this.period = period; }

    public Long getCounter() { return counter; }
    public void setCounter(Long counter) { this.counter = counter; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}