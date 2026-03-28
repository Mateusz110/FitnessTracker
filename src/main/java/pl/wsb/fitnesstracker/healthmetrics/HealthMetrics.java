package pl.wsb.fitnesstracker.healthmetrics.api;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
import pl.wsb.fitnesstracker.user.api.User;

@Entity
@Table(name = "health_metrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Relacja ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "metric_date", nullable = false) // 'date' to słowo zastrzeżone w wielu bazach, lepiej uważać
    private LocalDate date;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private int height;

    @Column(name = "heart_rate")
    private int heartRate;

    public HealthMetrics(User user, LocalDate date, double weight, int height, int heartRate) {
        this.user = user;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
    }
}