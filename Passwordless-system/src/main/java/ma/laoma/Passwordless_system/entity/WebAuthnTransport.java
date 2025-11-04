package ma.laoma.Passwordless_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "webauthn_transports")
public class WebAuthnTransport {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credential_id", nullable = false)
    private WebAuthnCredential webAuthnCredential;

    @Enumerated(EnumType.STRING)
    @Column(name = "transport", nullable = false, columnDefinition = "ENUM('usb', 'nfc', 'ble', 'internal', 'smartcard')")
    private TransportType transport;

    // Enums
    public enum TransportType {
        USB, NFC, BLE, INTERNAL, SMARTCARD
    }

    // Constructors
    public WebAuthnTransport() {}

    public WebAuthnTransport(WebAuthnCredential webAuthnCredential, TransportType transport) {
        this.webAuthnCredential = webAuthnCredential;
        this.transport = transport;
    }

    // Getters and Setters
    public WebAuthnCredential getWebAuthnCredential() { return webAuthnCredential; }
    public void setWebAuthnCredential(WebAuthnCredential webAuthnCredential) { this.webAuthnCredential = webAuthnCredential; }

    public TransportType getTransport() { return transport; }
    public void setTransport(TransportType transport) { this.transport = transport; }

    // Override equals and hashCode for composite key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebAuthnTransport)) return false;
        WebAuthnTransport that = (WebAuthnTransport) o;
        return webAuthnCredential.getId().equals(that.webAuthnCredential.getId()) &&
                transport == that.transport;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(webAuthnCredential.getId(), transport);
    }
}