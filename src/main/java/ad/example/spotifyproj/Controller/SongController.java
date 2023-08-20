package ad.example.spotifyproj.Controller;


import ad.example.spotifyproj.Model.User;
import ad.example.spotifyproj.Service.LocationService;
import ad.example.spotifyproj.Service.PythonService;
import ad.example.spotifyproj.Service.SpotifyService;
import ad.example.spotifyproj.Service.UserService;
import ad.example.spotifyproj.Utility.GeocodingUtility;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class SongController {

    @Autowired
    private PythonService pythonService;
    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;
    @Autowired
    private SpotifyService spotifyService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping( "/location")
    public ResponseEntity<List<SendSong>> generateSongByLocation(@RequestBody ReceivedLocation location) {

        Integer timeType, number,locationId;
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        String address = GeocodingUtility.getAddressFromCoordinates(latitude, longitude);
        System.out.println("address: " + address);
        User user = userService.findUserByUsername(location.getUsername());
        long userId = user.getId();
        //locationId = locationService.findLocationIdByAddress(address);
        locationId = locationService.findLocationIdByAddress(address);

        if (userService.isUserPremium(userId)){
            if(locationId == null) {
                locationId = -1;
            }
            timeType = -1;
            number = 12;
        }
        else{
            if(locationId == null)
            {
                locationId = -1;
            }
            timeType = -1;
            number = 6;
            System.out.println("locationId: " + locationId);
        }
//this will catch data from python

//        List<String> playlist = pythonService.senddatatoPython();
//        List<SendSong> SendSongList = new ArrayList<>();
//        for (String trackId : playlist) {
//            ResponseEntity<String> response = spotifyService.getTrackDetails(trackId);
//            String responseBody = response.getBody();
//            try {
//                JsonNode trackDetails = objectMapper.readTree(responseBody);
//                JsonNode track = trackDetails.get("tracks").get(0);
//
//                String songName = track.get("name").asText();
//
//                String artistName = track.get("artists").get(0).get("name").asText();
//
//                String imageUrl = track.get("album").get("images").get(0).get("url").asText();
//
//                int duration = track.get("duration_ms").asInt();
//                SendSong sendSong = new SendSong(trackId, songName, artistName, duration,imageUrl);
//                SendSongList.add(sendSong);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        List<SendSong> SendSongList = new ArrayList<>();
        SendSong sendSong4 = new SendSong("2QSrwZ7iVknZgkfi4aD6cn", "Saltwater", "Geowulf", 1, "https://i.scdn.co/image/ab67616d0000b273bc284cc356a952a49a388219");
        SendSong sendSong5 = new SendSong("62tGzw9OJOwDcjPBnMPCuj", "No More Lies", "Thundercat", 1, "https://i.scdn.co/image/ab67616d0000b273882c536d8dcfb086bcf9733b");
        SendSong sendSong6 = new SendSong("17fL4slDQP8YopAZHWyiR3", "Only Girl", "Stephen Sanchez", 1, "https://i.scdn.co/image/ab67616d0000b2737b60e8763f80fed587b77800");
        SendSong sendSong1 = new SendSong("3k79jB4aGmMDUQzEwa46Rz", "vampire", "Olivia Rodrigo", 1, "https://i.scdn.co/image/ab67616d0000b2731e5e75dc1d878a0007cb6525");
        SendSong sendSong2 = new SendSong("4P9Q0GojKVXpRTJCaL3kyy", "All Of The Girls You Loved Before", "Taylor Swift", 1, "https://i.scdn.co/image/ab67616d0000b2738481d8f15859aa5bae75ee17");
        SendSong sendSong3 = new SendSong("0ibvUpSyUdMXrmuPIcg1T3", "Settling", "Ripe", 1, "https://i.scdn.co/image/ab67616d0000b27382eee374fc9072b943e7fd35");

        SendSongList.add(sendSong1);
        SendSongList.add(sendSong2);
        SendSongList.add(sendSong3);
        SendSongList.add(sendSong4);
        SendSongList.add(sendSong5);
        SendSongList.add(sendSong6);
        SendSongList.add(sendSong1);
        SendSongList.add(sendSong2);
        SendSongList.add(sendSong3);
        SendSongList.add(sendSong4);
        SendSongList.add(sendSong5);
        SendSongList.add(sendSong6);
        return ResponseEntity.ok(SendSongList);
    }

//    @PostMapping( "/location")
//    public ResponseEntity<List<SendSong>> generateSongByLocation(@RequestBody ReceivedLocation location) {
//
//        Integer timeType, number,locationId;
//        double latitude = location.getLatitude();
//        double longitude = location.getLongitude();
//        String address = GeocodingUtility.getAddressFromCoordinates(latitude, longitude);
//        System.out.println("address: " + address);
//        User user = userService.findUserByUsername(location.getUsername());
//        long userId = user.getId();
//
//        if (userService.isUserPremium(userId)){
//
//            if(address == null)
//            {
//                locationId = -1;
//            }else
//            {
//                locationId = locationService.findLocationIdByAddress(address);
//            }
//            timeType = -1;
//            number = 12;
//        }
//        else{
//            if(address == null)
//            {
//                locationId = -1;
//            }else
//            {
//                locationId = locationService.findLocationIdByAddress(address);
//                System.out.println("locationId: " + locationId);
//            }
//            timeType = -1;
//            number = 6;
//        }
//        //this will catch data from python
////        List<String> playlist = pythonService.senddatatoPython();
////        List<SendSong> SendSongList = new ArrayList<>();
////        for (String trackId : playlist) {
////            ResponseEntity<String> response = spotifyService.getTrackDetails(trackId);
////            String responseBody = response.getBody();
////            try {
////                JsonNode trackDetails = objectMapper.readTree(responseBody);
////                JsonNode track = trackDetails.get("tracks").get(0);
////
////                String songName = track.get("name").asText();
////
////                String artistName = track.get("artists").get(0).get("name").asText();
////
////                String imageUrl = track.get("album").get("images").get(0).get("url").asText();
////
////                int duration = track.get("duration_ms").asInt();
////                SendSong sendSong = new SendSong(trackId, songName, artistName, duration,imageUrl);
////                SendSongList.add(sendSong);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
//        List<SendSong> SendSongList = new ArrayList<>();
//        SendSong sendSong4 = new SendSong("2QSrwZ7iVknZgkfi4aD6cn", "Saltwater", "Geowulf", 1, "https://i.scdn.co/image/ab67616d0000b273bc284cc356a952a49a388219");
//        SendSong sendSong5 = new SendSong("62tGzw9OJOwDcjPBnMPCuj", "No More Lies", "Thundercat", 1, "https://i.scdn.co/image/ab67616d0000b273882c536d8dcfb086bcf9733b");
//        SendSong sendSong6 = new SendSong("17fL4slDQP8YopAZHWyiR3", "Only Girl", "Stephen Sanchez", 1, "https://i.scdn.co/image/ab67616d0000b2737b60e8763f80fed587b77800");
//        SendSong sendSong1 = new SendSong("3k79jB4aGmMDUQzEwa46Rz", "vampire", "Olivia Rodrigo", 1, "https://i.scdn.co/image/ab67616d0000b2731e5e75dc1d878a0007cb6525");
//        SendSong sendSong2 = new SendSong("4P9Q0GojKVXpRTJCaL3kyy", "All Of The Girls You Loved Before", "Taylor Swift", 1, "https://i.scdn.co/image/ab67616d0000b2738481d8f15859aa5bae75ee17");
//        SendSong sendSong3 = new SendSong("0ibvUpSyUdMXrmuPIcg1T3", "Settling", "Ripe", 1, "https://i.scdn.co/image/ab67616d0000b27382eee374fc9072b943e7fd35");
//        SendSongList.add(sendSong1);
//        SendSongList.add(sendSong2);
//        SendSongList.add(sendSong3);
//        SendSongList.add(sendSong4);
//        SendSongList.add(sendSong5);
//        SendSongList.add(sendSong6);
//        return ResponseEntity.ok(SendSongList);
//    }

    @PostMapping( "/time")
    public ResponseEntity<List<SendSong>> generateSongByTime(@RequestBody ReceivedLocation location) {
        Integer locationId, timeType, number;
        User user = userService.findUserByUsername(location.getUsername());
        LocalDateTime currentDateTime = LocalDateTime.now();
        timeType = RecordController.getTimeType(currentDateTime);
        long userId = user.getId();

        if(userService.isUserPremium(userId)){
            //get locationId from database
        locationId = -1;
        number = 12;
        }
        else{
              locationId = -1;
        number = 6;
        }
        System.out.println("time locationId: " + locationId + " time number: " + number);
//        //this will catch data from python
//
//        List<String> playlist = pythonService.senddatatoPython();
//        List<SendSong> SendSongList = new ArrayList<>();
//        for (String trackId : playlist) {
//            ResponseEntity<String> response = spotifyService.getTrackDetails(trackId);
//            String responseBody = response.getBody();
//            try {
//                JsonNode trackDetails = objectMapper.readTree(responseBody);
//                JsonNode track = trackDetails.get("tracks").get(0);
//
//                String songName = track.get("name").asText();
//
//                String artistName = track.get("artists").get(0).get("name").asText();
//
//                int duration = track.get("duration_ms").asInt();
//
//                String imageUrl = track.get("album").get("images").get(0).get("url").asText();
//
//                SendSong sendSong = new SendSong(trackId, songName, artistName, duration,imageUrl);
//                SendSongList.add(sendSong);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        List<SendSong> SendSongList = new ArrayList<>();
        SendSong sendSong4 = new SendSong("2QSrwZ7iVknZgkfi4aD6cn", "Saltwater", "Geowulf", 1, "https://i.scdn.co/image/ab67616d0000b273bc284cc356a952a49a388219");
        SendSong sendSong5 = new SendSong("62tGzw9OJOwDcjPBnMPCuj", "No More Lies", "Thundercat", 1, "https://i.scdn.co/image/ab67616d0000b273882c536d8dcfb086bcf9733b");
        SendSong sendSong6 = new SendSong("17fL4slDQP8YopAZHWyiR3", "Only Girl", "Stephen Sanchez", 1, "https://i.scdn.co/image/ab67616d0000b2737b60e8763f80fed587b77800");
        SendSong sendSong1 = new SendSong("3k79jB4aGmMDUQzEwa46Rz", "vampire", "Olivia Rodrigo", 1, "https://i.scdn.co/image/ab67616d0000b2731e5e75dc1d878a0007cb6525");
        SendSong sendSong2 = new SendSong("4P9Q0GojKVXpRTJCaL3kyy", "All Of The Girls You Loved Before", "Taylor Swift", 1, "https://i.scdn.co/image/ab67616d0000b2738481d8f15859aa5bae75ee17");
        SendSong sendSong3 = new SendSong("0ibvUpSyUdMXrmuPIcg1T3", "Settling", "Ripe", 1, "https://i.scdn.co/image/ab67616d0000b27382eee374fc9072b943e7fd35");
        SendSongList.add(sendSong1);
        SendSongList.add(sendSong2);
        SendSongList.add(sendSong3);
        SendSongList.add(sendSong4);
        SendSongList.add(sendSong5);
        SendSongList.add(sendSong6);
        SendSongList.add(sendSong1);
        SendSongList.add(sendSong2);
        SendSongList.add(sendSong3);
        SendSongList.add(sendSong4);
        SendSongList.add(sendSong5);
        SendSongList.add(sendSong6);
        return ResponseEntity.ok(SendSongList);
    }

    @GetMapping( "/publicForAndroid")
    public ResponseEntity<List<SendSong>> generatePublicSong() {
        Integer locationId, timeType, number;
        long userId = 0;
            locationId = -1;
            timeType = -1;
            number = 18;
//        //this will catch data from python
//
//        List<String> playlist = pythonService.senddatatoPython();
//        List<SendSong> SendSongList = new ArrayList<>();
//        for (String trackId : playlist) {
//            ResponseEntity<String> response = spotifyService.getTrackDetails(trackId);
//            String responseBody = response.getBody();
//            try {
//                JsonNode trackDetails = objectMapper.readTree(responseBody);
//                JsonNode track = trackDetails.get("tracks").get(0);
//
//                String songName = track.get("name").asText();
//
//                String artistName = track.get("artists").get(0).get("name").asText();
//
//                int duration = track.get("duration_ms").asInt();
//
//                String imageUrl = track.get("album").get("images").get(0).get("url").asText();
//
//                SendSong sendSong = new SendSong(trackId, songName, artistName, duration,imageUrl);
//                SendSongList.add(sendSong);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("请求了 18首歌");
        List<SendSong> SendSongList = new ArrayList<>();
        SendSong sendSong4 = new SendSong("2QSrwZ7iVknZgkfi4aD6cn", "Saltwater", "Geowulf", 1, "https://i.scdn.co/image/ab67616d0000b273bc284cc356a952a49a388219");
        SendSong sendSong5 = new SendSong("62tGzw9OJOwDcjPBnMPCuj", "No More Lies", "Thundercat", 1, "https://i.scdn.co/image/ab67616d0000b273882c536d8dcfb086bcf9733b");
        SendSong sendSong6 = new SendSong("17fL4slDQP8YopAZHWyiR3", "Only Girl", "Stephen Sanchez", 1, "https://i.scdn.co/image/ab67616d0000b2737b60e8763f80fed587b77800");
        SendSong sendSong1 = new SendSong("3k79jB4aGmMDUQzEwa46Rz", "vampire", "Olivia Rodrigo", 1, "https://i.scdn.co/image/ab67616d0000b2731e5e75dc1d878a0007cb6525");
        SendSong sendSong2 = new SendSong("4P9Q0GojKVXpRTJCaL3kyy", "All Of The Girls You Loved Before", "Taylor Swift", 1, "https://i.scdn.co/image/ab67616d0000b2738481d8f15859aa5bae75ee17");
        SendSong sendSong3 = new SendSong("0ibvUpSyUdMXrmuPIcg1T3", "Settling", "Ripe", 1, "https://i.scdn.co/image/ab67616d0000b27382eee374fc9072b943e7fd35");
        SendSongList.add(sendSong1);
        SendSongList.add(sendSong2);
        SendSongList.add(sendSong3);
        SendSongList.add(sendSong4);
        SendSongList.add(sendSong5);
        SendSongList.add(sendSong6);
        SendSongList.add(sendSong1);
        SendSongList.add(sendSong2);
        SendSongList.add(sendSong3);
        SendSongList.add(sendSong4);
        SendSongList.add(sendSong5);
        SendSongList.add(sendSong6);
        SendSongList.add(sendSong1);
        SendSongList.add(sendSong2);
        SendSongList.add(sendSong3);
        SendSongList.add(sendSong4);
        SendSongList.add(sendSong5);
        SendSongList.add(sendSong6);
        return ResponseEntity.ok(SendSongList);
    }

    @PostMapping( "/after")
    public ResponseEntity<List<SendSong>> generateSongAfterLogin(@RequestBody ReceivedLocation location) {
        Integer locationId, timeType, number;
        User user = userService.findUserByUsername(location.getUsername());
        long userId = user.getId();

        if(userService.isUserPremium(userId)){
            timeType = -1;
            locationId = -1;
            number = 12;
        }
        else{
            timeType = -1;
            locationId = -1;
            number = 6;
        }
//        //this will catch data from python
//
//        List<String> playlist = pythonService.senddatatoPython();
//        List<SendSong> SendSongList = new ArrayList<>();
//        for (String trackId : playlist) {
//            ResponseEntity<String> response = spotifyService.getTrackDetails(trackId);
//            String responseBody = response.getBody();
//            try {
//                JsonNode trackDetails = objectMapper.readTree(responseBody);
//                JsonNode track = trackDetails.get("tracks").get(0);
//
//                String songName = track.get("name").asText();
//
//                String artistName = track.get("artists").get(0).get("name").asText();
//
//                int duration = track.get("duration_ms").asInt();
//
//                String imageUrl = track.get("album").get("images").get(0).get("url").asText();
//
//                SendSong sendSong = new SendSong(trackId, songName, artistName, duration,imageUrl);
//                SendSongList.add(sendSong);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        List<SendSong> SendSongList = new ArrayList<>();
        SendSong sendSong4 = new SendSong("2QSrwZ7iVknZgkfi4aD6cn", "Saltwater", "Geowulf", 1, "https://i.scdn.co/image/ab67616d0000b273bc284cc356a952a49a388219");
        SendSong sendSong5 = new SendSong("62tGzw9OJOwDcjPBnMPCuj", "No More Lies", "Thundercat", 1, "https://i.scdn.co/image/ab67616d0000b273882c536d8dcfb086bcf9733b");
        SendSong sendSong6 = new SendSong("17fL4slDQP8YopAZHWyiR3", "Only Girl", "Stephen Sanchez", 1, "https://i.scdn.co/image/ab67616d0000b2737b60e8763f80fed587b77800");
        SendSong sendSong1 = new SendSong("3k79jB4aGmMDUQzEwa46Rz", "vampire", "Olivia Rodrigo", 1, "https://i.scdn.co/image/ab67616d0000b2731e5e75dc1d878a0007cb6525");
        SendSong sendSong2 = new SendSong("4P9Q0GojKVXpRTJCaL3kyy", "All Of The Girls You Loved Before", "Taylor Swift", 1, "https://i.scdn.co/image/ab67616d0000b2738481d8f15859aa5bae75ee17");
        SendSong sendSong3 = new SendSong("0ibvUpSyUdMXrmuPIcg1T3", "Settling", "Ripe", 1, "https://i.scdn.co/image/ab67616d0000b27382eee374fc9072b943e7fd35");
        SendSongList.add(sendSong1);
        SendSongList.add(sendSong2);
        SendSongList.add(sendSong3);
        SendSongList.add(sendSong4);
        SendSongList.add(sendSong5);
        SendSongList.add(sendSong6);
        SendSongList.add(sendSong1);
        SendSongList.add(sendSong2);
        SendSongList.add(sendSong3);
        SendSongList.add(sendSong4);
        SendSongList.add(sendSong5);
        SendSongList.add(sendSong6);
        return ResponseEntity.ok(SendSongList);
    }
}
    
class ReceivedLocation{
    private double latitude;
    private double longitude;
    private String username;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

class SendSong{
    private String uri;
    private String name;
    private String artist;
    private Integer duration;
    private String imageUrl;

    public SendSong(String uri, String name, String artist, Integer duration, String imageUrl) {
        this.uri = uri;
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.imageUrl = imageUrl;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}