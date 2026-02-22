package com.beshuffle.beshuffle_api.repositories;

import com.beshuffle.beshuffle_api.domain.dayalbum.DayAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface DayAlbumRepository extends JpaRepository<DayAlbum, UUID> {

    Optional<DayAlbum> findByDisplayDate(LocalDate displayDate);

}
