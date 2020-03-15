package com.herokuapp.it372finalproject.restfulservices.services.mailchimp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains the nested Tag object for consuming the MailChimp API
 * using restTemplate. Tags are used to segment a MailChimp Audience. A
 * Subscriber can have more than one tag.
 *
 * @author Add-a-div Team
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    /**
     * This method gets the name of the Tag.
     *
     * @return name of the Tag
     */
    @JsonProperty("name")
    public String getName()
    {
        return name;
    }

    /**
     * This method sets the name of the Tag.
     *
     * @param name The name of the Tag
     */
    @JsonProperty("name")
    public void setName(String name)
    {
        this.name = name;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Tag{" + "name='" + name + '\'' +
                '}';
    }
}
