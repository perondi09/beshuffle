package perondi.BeSuffle.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import perondi.BeSuffle.client.Album;
import perondi.BeSuffle.client.AlbumSpotifyClient;
import perondi.BeSuffle.client.AuthSpotifyClient;
import perondi.BeSuffle.client.LoginRequest;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {

    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumSpotifyClient albumSpotifyClient;
    private final String clientId;
    private final String clientSecret;

    public AlbumController(
            AuthSpotifyClient authSpotifyClient,
            AlbumSpotifyClient albumSpotifyClient,
            @Value("${spotify.client-id}") String clientId,
            @Value("${spotify.client-secret}") String clientSecret
    ) {
        this.authSpotifyClient = authSpotifyClient;
        this.albumSpotifyClient = albumSpotifyClient;
        Assert.hasText(clientId, "spotify.client-id must be configured");
        Assert.hasText(clientSecret, "spotify.client-secret must be configured");
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @GetMapping("/albums")
    public ResponseEntity<Album> getAlbum(@RequestParam("id") String id) {

        var request = new LoginRequest(
                "client_credentials",
                clientId,
                clientSecret
        );
        var token = authSpotifyClient.login(request).getAccessToken();

        var response = albumSpotifyClient.getAlbum("Bearer " + token, id);

        return ResponseEntity.ok(response);
    }
}
