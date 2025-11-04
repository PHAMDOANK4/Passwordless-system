package ma.laoma.Passwordless_system.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "handle", nullable = false, columnDefinition = "VARBINARY(255)")
    private byte[] handle;

    @Column(name = "email_verified")
    private Boolean emailVerified = false;

    @Column(name = "phone_verified")
    private Boolean phoneVerified = false;

    @Column(name = "mfa_enabled")
    private Boolean mfaEnabled = false;

    @Column(name = "primary_method_id")
    private Long primaryMethodId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relationships
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AuthFactor> authFactors = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OtpRequest> otpRequests = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserSession> userSessions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AuthAuditLog> authAuditLogs = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecoveryCode> recoveryCodes = new ArrayList<>();

    // Constructors
    public User() {}

    public User(String username, byte[] handle) {
        this.username = username;
        this.handle = handle;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public byte[] getHandle() { return handle; }
    public void setHandle(byte[] handle) { this.handle = handle; }

    public Boolean getEmailVerified() { return emailVerified; }
    public void setEmailVerified(Boolean emailVerified) { this.emailVerified = emailVerified; }

    public Boolean getPhoneVerified() { return phoneVerified; }
    public void setPhoneVerified(Boolean phoneVerified) { this.phoneVerified = phoneVerified; }

    public Boolean getMfaEnabled() { return mfaEnabled; }
    public void setMfaEnabled(Boolean mfaEnabled) { this.mfaEnabled = mfaEnabled; }

    public Long getPrimaryMethodId() { return primaryMethodId; }
    public void setPrimaryMethodId(Long primaryMethodId) { this.primaryMethodId = primaryMethodId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public List<AuthFactor> getAuthFactors() { return authFactors; }
    public void setAuthFactors(List<AuthFactor> authFactors) { this.authFactors = authFactors; }

    public List<OtpRequest> getOtpRequests() { return otpRequests; }
    public void setOtpRequests(List<OtpRequest> otpRequests) { this.otpRequests = otpRequests; }

    public List<UserSession> getUserSessions() { return userSessions; }
    public void setUserSessions(List<UserSession> userSessions) { this.userSessions = userSessions; }

    public List<AuthAuditLog> getAuthAuditLogs() { return authAuditLogs; }
    public void setAuthAuditLogs(List<AuthAuditLog> authAuditLogs) { this.authAuditLogs = authAuditLogs; }

    public List<RecoveryCode> getRecoveryCodes() { return recoveryCodes; }
    public void setRecoveryCodes(List<RecoveryCode> recoveryCodes) { this.recoveryCodes = recoveryCodes; }
}