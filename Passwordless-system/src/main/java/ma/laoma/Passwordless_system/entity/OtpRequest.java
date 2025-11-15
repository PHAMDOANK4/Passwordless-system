package ma.laoma.Passwordless_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import ma.laoma.Passwordless_system.enumeration.OtpChannelEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otp_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OtpRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OtpChannelEnum channel;

    private String code;
    private LocalDateTime createdAt;

    private String destination;
    private LocalDateTime expiresAt;
    private Boolean used;

    @ManyToOne
    @JoinColumn(name = "factor_id", nullable = false)
    private AuthFactor factor;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
