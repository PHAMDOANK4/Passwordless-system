package ma.laoma.Passwordless_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "user_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSession {

    @Id
    private String id;

    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    private String ipAddress;

    @Column(nullable = false)
    private String token;

    private String userAgent;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
