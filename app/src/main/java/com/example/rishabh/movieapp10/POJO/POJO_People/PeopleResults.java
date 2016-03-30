package com.example.rishabh.movieapp10.POJO.POJO_People;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PeopleResults {

    @SerializedName("profile_path")
    @Expose
    private String profilePath;
    @Expose
    private Boolean adult;
    @Expose
    private Integer id;
    @SerializedName("known_for")
    @Expose
    private List<PeopleKnownFor> knownForResults = new ArrayList<PeopleKnownFor>();
    @Expose
    private String name;
    @Expose
    private Float popularity;

    /**
     * @return The profilePath
     */
    public String getProfilePath() {
        return profilePath;
    }

    /**
     * @param profilePath The profile_path
     */
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    /**
     * @return The adult
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     * @param adult The adult
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The knownFor
     */


    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public List<PeopleKnownFor> getResults() {
        return knownForResults;
    }

    public void setResults(List<PeopleKnownFor> results) {
        knownForResults = results;
    }

    /**
     * @return The popularity
     */
    public Float getPopularity() {
        return popularity;
    }

    /**
     * @param popularity The popularity
     */
    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

}
