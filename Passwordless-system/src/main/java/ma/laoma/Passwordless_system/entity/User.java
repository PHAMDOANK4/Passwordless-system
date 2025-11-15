package ma.laoma.Passwordless_system.entity;



import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String displayName;
    private String email;
    private Boolean emailVerified;
    private byte[] handle;
    private Boolean mfaEnabled;

    private String phone;
    private Boolean phoneVerified;

    private Long primaryMethodId;

    @Column(nullable = false)
    private String username;

    // Relations
    @OneToMany(mappedBy = "user")
    private List<AuthFactor> factors;

    @OneToMany(mappedBy = "user")
    private List<MagicLink> magicLinks;

    @OneToMany(mappedBy = "user")
    private List<SocialAccount> socialAccounts;

    @OneToMany(mappedBy = "user")
    private List<OtpRequest> otpRequests;

    @OneToMany(mappedBy = "user")
    private List<RecoveryCode> recoveryCodes;

    @OneToMany(mappedBy = "user")
    private List<UserDevice> devices;

    @OneToMany(mappedBy = "user")
    private List<UserSession> sessions;

    @OneToMany(mappedBy = "user")
    private List<AuthAuditLog> auditLogs;
}
