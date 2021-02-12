package com.metro.card.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "TBL_METRO_CARD")
public class MetroCard {

    @Id
    @GeneratedValue
    private Long cardId;
    private BigDecimal cardValue;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getCardValue() {
        return cardValue;
    }

    public void setCardValue(BigDecimal cardValue) {
        this.cardValue = cardValue;
    }
}
