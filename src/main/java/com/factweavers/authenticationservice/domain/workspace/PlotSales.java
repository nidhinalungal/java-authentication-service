package com.factweavers.authenticationservice.domain.workspace;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dpm_eval_sector_price_detail")
@Getter
@Setter
public class PlotSales implements Sales {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ENDDATE")
    private LocalDateTime soldDate;

    @Column(name = "SELL_PRICE_DETAIL")
    private String sellPrice;

    @Column(name="SOLDPERCENT_DETAIL")
    private String soldPercent;

    @Column(name="PLOTID")
    private Long plotId;

    @Transient
    private String salesGap;

}
