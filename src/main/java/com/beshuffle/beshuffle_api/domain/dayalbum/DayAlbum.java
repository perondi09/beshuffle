package com.beshuffle.beshuffle_api.domain.dayalbum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "dayalbum")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DayAlbum {

    @Id
    @GeneratedValue
    private String id;

    private String title;

    private String artist;

    private String urlCover;

    private String resume;

    private LocalDate displayDate;
}
