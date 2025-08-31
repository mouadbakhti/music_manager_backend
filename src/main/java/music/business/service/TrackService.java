package music.business.service;

import music.business.entity.Track;
import org.springframework.stereotype.Service;
import music.business.repository.TrackRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
//    private Track testTrack2;
//    private Track testTrack3;
//    private Track testTrack1;
//    private List<Track> tracks;
//
//    public TrackService() {
//        this.testTrack1 = new Track(1, "Stairway to Heaven", "Led Zeppelin", 480, "https://cdn-images.dzcdn.net/images/cover/9e663c64680899afd85f72af607d549e/0x1900-000000-80-0-0.jpg");
//        this.testTrack2 = new Track(2, "Highway To Hell", "AC/DC", 250, "https://storage.highresaudio.com/web/imgcache/27b2a553da34ef3aa22aee94b4a38670/zii3x4-highwaytoh-master_500x500.jpg");
//        this.testTrack3 = new Track(3, "Comfortably Numb", "Pink Floyd", 360, "https://miro.medium.com/v2/resize:fit:1100/format:webp/1*8FkvzbSdSJ4HNxtuZo5kLg.jpeg");
//
//        this.tracks = new ArrayList<>();
//        tracks.add(testTrack1);
//        tracks.add(testTrack2);
//        tracks.add(testTrack3);
    }

    public Track getTrackDetails(Long trackId) {
        return trackRepository.findById(trackId).orElse(null);
    }

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public void addTrack(Track track) {
        trackRepository.save(track);
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
            return trackRepository.save(track);
        }).orElse(null);
    }
}
