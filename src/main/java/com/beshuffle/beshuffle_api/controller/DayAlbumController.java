package com.beshuffle.beshuffle_api.controller;

import com.beshuffle.beshuffle_api.domain.dayalbum.DayAlbum;
import com.beshuffle.beshuffle_api.domain.dayalbum.DayAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/album")

public class DayAlbumController {

    @Autowired
    private DayAlbumService service;

    @GetMapping("/today")
    public ResponseEntity<DayAlbum> getTodayAlbum() {
        DayAlbum album = service.getTodayAlbum();
        return ResponseEntity.ok(album);
    }
}
