package music.business.controller;

import music.business.entity.Track;
import music.business.service.TrackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
public class TrackController {
    private TrackService trackService;

    public TrackController(TrackService ts) {
        this.trackService = ts;
    }

    @GetMapping("/api/track/{id}")
    public Track getTrackDetails(@PathVariable Long id) {
        return trackService.getTrackDetails(id);
    }

    @GetMapping("/api/tracks")
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }

    @PostMapping("/api/track")
    public Track addTrack(@RequestBody Track track) {
        trackService.addTrack(track);
        return track;
    }

    @DeleteMapping("/api/track/{id}")
    public void deleteTrack(@PathVariable Long id) {
        trackService.deleteTrack(id);
    }

    @PutMapping("/api/track/{id}")
    public Track updateTrack(@PathVariable Long id, @RequestBody Track updatedTrack) {
        return this.trackService.updateTrack(id, updatedTrack);
    }
}
