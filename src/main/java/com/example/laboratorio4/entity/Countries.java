package com.example.laboratorio4.entity;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {

    @Id
    @Column(name = "country_id")
    private String id;
    @Column(name = "country_name")
    private String countryname;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regions regionid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public Regions getRegionid() {
        return regionid;
    }

    public void setRegionid(Regions regionid) {
        this.regionid = regionid;
    }
}
