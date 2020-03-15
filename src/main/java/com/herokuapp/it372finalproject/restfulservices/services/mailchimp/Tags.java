package com.herokuapp.it372finalproject.restfulservices.services.mailchimp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class contains a List of Tag objects for consuming the MailChimp API
 * using restTemplate. Tags are used to segment a MailChimp Audience. A
 * Subscriber can have more than one tag.
 *
 * @author Add-a-div Team
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tags {

    @JsonProperty("tags")
    private List<Tag> tags;

    /**
     * This method gets the tags for a Subscriber. Tags utilizes
     * another class (Tag).
     *
     * @return List Tag an array of Subscriber tags
     */
    @JsonProperty("tags")
    public List<Tag> getTags()
    {
        return tags;
    }

    /**
     * This method sets the tags for a Subscriber. Tags utilizes
     * another class (Tag).
     *
     * @param tags List Tag array of Subscriber tags.
     */
    @JsonProperty("tags")
    public void setTags(List<Tag> tags)
    {
        this.tags = tags;
    }

    @Override
    public String toString()
    {
        return "Tags{" + "tags=" + tags +
                '}';
    }
}
