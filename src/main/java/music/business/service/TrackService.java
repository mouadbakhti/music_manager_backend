package music.business.service;

import music.business.entity.Track;
import music.business.repository.CampaignRepository;
import org.springframework.stereotype.Service;
import music.business.repository.TrackRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {
    private final TrackRepository trackRepository;
    private final CampaignRepository campaignRepository;

    public TrackService(TrackRepository ts, CampaignRepository cs) {
        this.trackRepository = ts;
        this.campaignRepository = cs;
    }

    public Track getTrackDetails(Long trackId) {
        return trackRepository.findById(trackId).orElse(null);
    }

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Track addTrack(Track track) {
        trackRepository.save(track);
        return track;
    }

    public void deleteTrack(Long id) {
        trackRepository.deleteById(id);
    }

    public Track updateTrack(@PathVariable Long id, Track updatedTrack) {
        return trackRepository.findById(id).map(track -> {
            track.setTitle(updatedTrack.getTitle());
            track.setArtist(updatedTrack.getArtist());
            track.setAlbum(updatedTrack.getAlbum());
            track.setDuration(updatedTrack.getDuration());
            track.setGenre(updatedTrack.getGenre());
            track.setReleaseDate(updatedTrack.getReleaseDate());
            track.setCoverUrl(updatedTrack.getCoverUrl());
            // Ajout pour la campagne
            if (updatedTrack.getCampaign() != null && updatedTrack.getCampaign().getId() != null) {
                campaignRepository.findById(updatedTrack.getCampaign().getId())
                        .ifPresent(track::setCampaign);
            } else {
                track.setCampaign(null);
            }
            return trackRepository.save(track);
        }).orElse(null);
    }

    public List<Track> findByCampaign(Long campaignId) {
        return trackRepository.findByCampaign_Id(campaignId);
    }
}
