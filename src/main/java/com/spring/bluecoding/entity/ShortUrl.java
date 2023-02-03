package com.spring.bluecoding.entity;

import javax.persistence.*;

@Entity
@Table(name = "short_url")
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,unique = true)
    private Long id;

    private String url;
    @Column(name = "short_url")
    private String shortUrl;
    private Integer clicks;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public ShortUrl() {
    }

    public ShortUrl(String url, String shortUrl, Integer clicks) {
        this.url = url;
        this.shortUrl = shortUrl;
        this.clicks = clicks;
    }
}
