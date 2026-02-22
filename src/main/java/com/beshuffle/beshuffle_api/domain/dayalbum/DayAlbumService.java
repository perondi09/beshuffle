package com.beshuffle.beshuffle_api.domain.dayalbum;

import com.beshuffle.beshuffle_api.repositories.DayAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service

public class DayAlbumService {

    @Autowired
    private DayAlbumRepository repository;

    public DayAlbum getTodayAlbum() {
        LocalDate today = LocalDate.now();

        return repository.findByDisplayDate(today)
                .orElseGet(() -> this.fetchAndSaveNewAlbum(today));
    }

    private DayAlbum fetchAndSaveNewAlbum(LocalDate date) {

        DayAlbum newAlbum = new DayAlbum();
        newAlbum.setTitle("Random Access Memories");
        newAlbum.setArtist("Daft Punk");
        newAlbum.setUrlCover("https://upload.wikimedia.org/wikipedia/en/a/a7/Random_Access_Memories.jpg");
        newAlbum.setResume("O quarto álbum de estúdio da dupla francesa Daft Punk, focado em influências do disco e funk.");
        newAlbum.setDisplayDate(date);

        return repository.save(newAlbum);
    }
}
