package ma.laoma.Passwordless_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auth_audit_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @Column(columnDefinition = "json")
    private String details;

    private String eventType;
    private String ipAddress;
    private Boolean success;
    private String userAgent;

    @ManyToOne
    @JoinColumn(name = "factor_id")
    private AuthFactor factor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
