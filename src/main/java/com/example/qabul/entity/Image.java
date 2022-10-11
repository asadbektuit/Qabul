package com.example.qabul.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("images"))
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String path;

    private String type;

    private Long size;

    private String URL;

    private String token;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
}
