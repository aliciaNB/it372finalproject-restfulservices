package com.herokuapp.it372finalproject.restfulservices.services.mailchimp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains the nested merge_fields for the MailChimp API restTemplate.
 * Merge fields are responsible for the dynamic markup for MailChimp email
 * templates. A Subscriber can have additional merge_fields.
 *
 * @author Add-a-div Team
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MergeFields {

    @JsonProperty("FNAME")
    private String fname;

    @JsonProperty("LNAME")
    private String lname;

    /**
     * This method gets the FNAME merge_field.
     *
     * @return FNAME merge_field
     */
    @JsonProperty("FNAME")
    public String getFname()
    {
        return fname;
    }

    /**
     * This method sets the FNAME merge_field.
     *
     * @param fname FNAME merge_field
     */
    @JsonProperty("FNAME")
    public void setFname(String fname)
    {
        this.fname = fname;
    }

    /**
     * This method gets the LNAME merge_field.
     *
     * @return LNAME merge_field
     */
    @JsonProperty("LNAME")
    public String getLname()
    {
        return lname;
    }

    /**
     * This method sets the LNAME merge_field.
     *
     * @param lname LNAME merge_field
     */
    @JsonProperty("LNAME")
    public void setLname(String lname)
    {
        this.lname = lname;
    }

    @Override
    public String toString()
    {
        return "MergeFields{" + "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
