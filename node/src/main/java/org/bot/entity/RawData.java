package org.bot.entity;

import lombok.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.persistence.*;

/**
 * @author Artur Tomeyan
 * @date 27/10/2022
 */
@Builder
@Entity
@Table(name = "raw_data")
public class RawData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Update event;

    public RawData() {
    }

    public RawData(Long id, Update event) {
        this.id = id;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Update getEvent() {
        return event;
    }

    public void setEvent(Update event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RawData rawData = (RawData) o;

        return new EqualsBuilder().append(id, rawData.id)
                .append(event, rawData.event)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(event)
                .toHashCode();
    }
}