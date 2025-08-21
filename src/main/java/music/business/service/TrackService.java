package music.business.service;

import music.business.entity.Track;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TrackService {
    private Track testTrack2;
    private Track testTrack3;
    private Track testTrack1;

    public TrackService() {
        this.testTrack1 = new Track(1L, "Stairway to Heaven", "Led Zeppelin", 480);
        this.testTrack2 = new Track(2L, "Highway To Hell", "AC/DC", 250);
        this.testTrack3 = new Track(3L, "Comfortably Numb", "Pink Floyd", 360);
    }

    public Track getTrackDetails(Long trackId) {
        return testTrack1;
    }
}
