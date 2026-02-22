package com.beshuffle.beshuffle_api.domain.dayalbum;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

public record DayAlbumRequestDTO(
        String title,
        String artist,
        String urlCover,
        String resume,
        LocalDate displayDate
) {
}
