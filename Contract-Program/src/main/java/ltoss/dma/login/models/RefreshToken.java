package ltoss.dma.login.models;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "refresh_token")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false, name = "expiry_date")
    private Instant expiryDate;
}