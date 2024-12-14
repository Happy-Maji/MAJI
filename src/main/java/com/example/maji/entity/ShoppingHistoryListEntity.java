package com.example.maji.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "shopping_history_list")
public class ShoppingHistoryListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shopping_history_list_seq")
    @SequenceGenerator(name = "shopping_history_list_seq", sequenceName = "shopping_history_list_seq", allocationSize = 1)
    private Long historyListIdx;

    @Column(name = "history_idx")
    private Long historyIdx;

    @Column(name = "customizing_idx")
    private Long customizingIdx;

    //-----------------------------

    @ManyToOne
    @JoinColumn(name = "history_Idx", insertable = false, updatable = false)
    private ShoppingHistoryEntity shoppingHistoryEntity;

    @ManyToOne
    @JoinColumn(name = "customizing_idx", insertable = false, updatable = false)
    private CustomizingEntity customizingEntity;

}
