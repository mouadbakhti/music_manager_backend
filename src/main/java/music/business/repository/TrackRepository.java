package music.business.repository;

import music.business.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si besoin
}

