package com.herokuapp.it372finalproject.restfulservices.services.mailchimp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains a Subscriber object for consuming the MailChimp API.
 * Utilizes the Tag and MergeFields classes.
 *
 * @author Add-a-div Team
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscriber {

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("status")
    private String status;

    @JsonProperty("merge_fields")
    private MergeFields mergeFields;

    /**
     * This method gets a email address for a Subscriber.
     *
     * @return String audience member email
     */
    @JsonProperty("email_address")
    public String getEmailAddress()
    {
        return emailAddress;
    }

    /**
     * This method sets an email address for a Subscriber.
     *
     * @param emailAddress Subscriber email address
     */
    @JsonProperty("email_address")
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    /**
     * This method gets an email address for a Subscriber.
     *
     * @return String audience member status
     */
    @JsonProperty("status")
    public String getStatus()
    {
        return status;
    }

    /**
     * This method sets an email address for a Subscriber.
     * A member can be "subscribed", "pending" confirmation email,
     * "unsubscribed", or "cleaned" to archive unused contacts.
     *
     * @param status Subscriber audience subscription status
     */
    @JsonProperty("status")
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * This method gets the merge_fields for a Subscriber.
     *
     * @return String Subscriber merge_fields
     */
    @JsonProperty("merge_fields")
    public MergeFields getMergeFields()
    {
        return mergeFields;
    }

    /**
     * This method sets the merge_fields for a Subscriber.
     * Merge fields utilizes another class (MergeFields).
     *
     * @param mergeFields Subscriber merge_fields
     */
    @JsonProperty("merge_fields")
    public void setMergeFields(MergeFields mergeFields)
    {
        this.mergeFields = mergeFields;
    }

    @Override
    public String toString()
    {
        return "Subscriber{" + "emailAddress='" + emailAddress + '\'' +
                ", status='" + status + '\'' +
                ", mergeFields=" + mergeFields +
                '}';
    }
}
