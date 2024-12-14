package com.example.maji.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "shopping_history")
public class ShoppingHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shopping_history_seq")
    @SequenceGenerator(name = "shopping_history_seq", sequenceName = "shopping_history_seq", allocationSize = 1)
    private Long historyIdx;

    @Column(name = "history_date")
    private LocalDateTime historyDate; //업로드 날짜

    @Column(name = "user_idx")
    private Long userIdx;

    //-----------------------------

    @OneToMany(mappedBy = "shoppingHistoryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingHistoryListEntity> shoppingHistoryListEntities;

    //-----------------------------

    @ManyToOne
    @JoinColumn(name = "user_idx", insertable = false, updatable = false)
    private UserEntity userEntity;

}
