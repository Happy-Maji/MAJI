package com.example.maji.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customizing_info")
public class CustomizingInfoEntity {

    @Id
    @Column(name = "customizing_info_idx")
    private Long customizingInfoIdx;

    @Column(name = "customizing_info_name")
    private String customizingInfoName;
}