package com.lf.gmovies.model;

import java.io.Serializable;

public class Movie implements Serializable {

    public Long videoId;
    public Long service_id;
    public Long programId;
    public String thumb;
    public String programName;
    public String program_type;
    public String description;
    public String duration;
    public Integer favorites;
    public Boolean full_episode;
    public String kind;

    @Override
    public String toString() {
        return "Movie{" +
                "videoId=" + videoId +
                ", service_id=" + service_id +
                ", programId=" + programId +
                ", thumb='" + thumb + '\'' +
                ", programName='" + programName + '\'' +
                ", program_type='" + program_type + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", favorites=" + favorites +
                ", full_episode=" + full_episode +
                ", kind='" + kind + '\'' +
                '}';
    }
}
