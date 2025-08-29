package music.business.service;

import music.business.entity.Track;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {
    private Track testTrack2;
    private Track testTrack3;
    private Track testTrack1;
    private List<Track> tracks;

    public TrackService() {
        this.testTrack1 = new Track(1, "Stairway to Heaven", "Led Zeppelin", 480);
        this.testTrack2 = new Track(2, "Highway To Hell", "AC/DC", 250);
        this.testTrack3 = new Track(3, "Comfortably Numb", "Pink Floyd", 360);

        this.tracks = new ArrayList<>();
        tracks.add(testTrack1);
        tracks.add(testTrack2);
        tracks.add(testTrack3);
    }

    public Track getTrackDetails(Long trackId) {
        for (Track track: tracks) {
            if (track.getId() == trackId) {
                return track;
            }
        }
        return null;
    }

    public List<Track> getAllTracks() {
        return tracks;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void deleteTrack(Long id) {
        tracks.removeIf(track -> track.getId() == id);
    }

    public Track updateTrack(@PathVariable Long id, Track updatedTrack) {
        for (Track track : tracks) {
            if (track.getId() == id) {
                track.setTitle(updatedTrack.getTitle());
                track.setArtist(updatedTrack.getArtist());
                track.setAlbum(updatedTrack.getAlbum());
                track.setDuration(updatedTrack.getDuration());
                track.setGenre(updatedTrack.getGenre());
                track.setReleaseDate(updatedTrack.getReleaseDate());
                track.setCoverUrl(updatedTrack.getCoverUrl());
                return track;
            }
        }
        return null;
    }
}
