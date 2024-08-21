package com.factweavers.authenticationservice.domain.workspace;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "dpm_eval_sector_price_det_unit")
@Getter
@Setter
public class UnitSales implements Sales {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ENDDATE")
    private LocalDateTime soldDate;

    @Column(name = "SELL_PRICE_DETAIL")
    private String sellPrice;

    @Column(name="SOLDPERCENT_DETAIL")
    private String soldPercent;

    @Column(name="UNITID")
    private Long unitId;
}
