package music.business.controller;

import music.business.entity.Track;
import music.business.service.CampaignService;
import music.business.service.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/api")
public class TrackController {
    private final TrackService trackService;
    private final CampaignService campaignService;

    public TrackController(TrackService ts, CampaignService cs) {
        this.trackService = ts;
        this.campaignService = cs;
    }

    @GetMapping("/track/{id}")
    public Track getTrackDetails(@PathVariable Long id) {
        return trackService.getTrackDetails(id);
    }

    @GetMapping("/tracks")
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }

    @PostMapping("/track")
    public ResponseEntity<Track> addTrack(@RequestBody Track track, @RequestParam(required = false) Long campaignId) {
        if (campaignId != null) {
            return this.campaignService.getCampaignById(campaignId)
                    .map(campaign -> {
                        track.setCampaign(campaign);
                        Track savedTrack = this.trackService.addTrack(track);
                        return ResponseEntity.ok(savedTrack);
                    })
                    .orElse(ResponseEntity.badRequest().build());
        }
        Track savedTrack = this.trackService.addTrack(track);
        return ResponseEntity.ok(savedTrack);
    }

    @DeleteMapping("/track/{id}")
    public void deleteTrack(@PathVariable Long id) {
        trackService.deleteTrack(id);
    }

    @PutMapping("/track/{id}")
    public Track updateTrack(@PathVariable Long id, @RequestBody Track updatedTrack) {
        return this.trackService.updateTrack(id, updatedTrack);
    }

    @GetMapping("/campaigns/{campaignId}/tracks")
            public List<Track> getTracksByCampaign(@PathVariable Long campaignId) {
        return this.trackService.findByCampaign(campaignId);
    }
}
