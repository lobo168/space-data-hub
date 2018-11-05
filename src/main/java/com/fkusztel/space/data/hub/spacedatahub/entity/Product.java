package com.fkusztel.space.data.hub.spacedatahub.entity;

import com.fkusztel.space.data.hub.spacedatahub.dto.FootprintDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Filip.Kusztelak
 */
@Entity
@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "acquisition_date")
    private LocalDate acquisitionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "name",
            referencedColumnName = "name"
    )
    private Mission mission;

    @Column(name = "footprint")
    private FootprintDto footprint;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_url")
    private String url;
}
