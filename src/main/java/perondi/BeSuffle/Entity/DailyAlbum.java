package perondi.BeSuffle.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "daily_album")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DailyAlbum {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private LocalDate date;

    @Column(nullable = false)
    private String spotifyId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String artist;

    @Column(length = 1000)
    private String imageUrl;

    @Column(length = 500)
    private String externalUrl;

    @Column(length = 100)
    private String releaseDate;

    @Column(length = 500)
    private String href;

    @Column(length = 200)
    private String uri;

    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }
}
