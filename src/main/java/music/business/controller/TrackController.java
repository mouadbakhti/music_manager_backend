package music.business.controller;

import music.business.entity.Track;
import music.business.service.TrackService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrackController {
    private TrackService trackService;

    public TrackController(TrackService ts) {
        this.trackService = ts;
    }

    @GetMapping("/api/track/{id}")
    public Track getTrackDetails(@PathVariable Long id) {
        return trackService.getTrackDetails(id);
    }
}
