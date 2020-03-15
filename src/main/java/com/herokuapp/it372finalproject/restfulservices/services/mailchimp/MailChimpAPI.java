package com.herokuapp.it372finalproject.restfulservices.services.mailchimp;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the MailChimp API service to manage newsletter subscriptions.
 *
 * @author Add-a-div Team
 * @version 1.0
 */
@Service
public class MailChimpAPI {

    private final RestTemplate restTemplate;
    private final String mailChimpRegionID = "us19";
    private	final String mailChimpAudienceID = "a1f3e579e4";

    /**
     * This constructor will ensure that HttpMessageConverters are applied to RestTemplate.
     * Sends the http header with Basic authorization to access the MailChimp API.
     *
     * @param restTemplateBuilder RestTemplateBuilder used to create RestTemplate instance.
     */
    public MailChimpAPI(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.basicAuthentication("anystring", "f41ab786d063f7676674fa4ee445d90d-us19").build();
    }

    /**
     * This method will GET a email subscriber from the MailChimp audience.
     * If subscribed already 200ok status. If not subscribed (ok to add)
     * 404 not found exception is expected and should be caught/handled.
     *
     * @param email email subscribed to GET from API
     * @return restTemplate API call to GET an audience email subscriber
     */
    public Subscriber checkStatus(String email)
    {
        String checkStatusURI = subscriberStatusURI(email);
        return this.restTemplate.getForObject(checkStatusURI, Subscriber.class);
    }

    /**
     * This method will POST a new subscriber to a MailChimp audience a
     * generic list of email subscribers .
     *
     * @param email email to add to the mailing list
     * @param fname first name merge_field
     * @param lname last name merge_field
     * @return restTemplate API call to post a new audience subscriber
     */
    public Subscriber subscribeToMailingList(String email, String fname, String lname)
    {
        String newSubURI = newSubscriberURI();
        Subscriber newSub = createSubscriber(email, fname, lname);
        return this.restTemplate.postForObject(newSubURI, newSub, Subscriber.class);
    }

    /**
     * This method will POST the "NewsletterSub" tag to a list of tags for a MailChimp
     * audience member that is already subscribed to the audience list.
     *
     * @param email email to add NewsletterSub tag
     * @return restTemplate API call to post "NewsletterSub" tag
     */
    public ResponseEntity<Tags> addNewsletterTag(String email)
    {
        String newTagsURI = newTagsURI(email);
        Tags newTags = createNewsletterTag();
        //return this.restTemplate.postForObject(newTagsURI, newTags, Tags.class); <- this version return should be void
        return this.restTemplate.postForEntity(newTagsURI, newTags, Tags.class);
    }

    //NOTE method to build custom uri to query a subscriber status
    private String subscriberStatusURI(String email)
    {
        //API endpoint https://us19.api.mailchimp.com/3.0/lists/{list_id}/members/{subscriber_hash}
        return "https://"
                + mailChimpRegionID
                + ".api.mailchimp.com/3.0/lists/"
                + mailChimpAudienceID
                + "/members/"
                + MD5.getMd5(email.toLowerCase());
    }

    //NOTE method to build custom uri to add a new subscriber
    private String newSubscriberURI()
    {
        //API endpoint https://us19.api.mailchimp.com/3.0/lists/{list_id}/members/
        return "https://"
                + mailChimpRegionID
                + ".api.mailchimp.com/3.0/lists/"
                + mailChimpAudienceID
                + "/members/";

    }

    //NOTE method to build custom uri to add Tags to a subscriber
    private String newTagsURI(String email)
    {
        //API endpoint https://us19.api.mailchimp.com/3.0/lists/{list_id}/members/{subscriber_hash}/tags
        return "https://"
                + mailChimpRegionID
                + ".api.mailchimp.com/3.0/lists/"
                + mailChimpAudienceID
                + "/members/" +  MD5.getMd5(email.toLowerCase()) + "/tags";
    }

    //NOTE builds JSON to pass a new audience subscriber to the API POST request
    private Subscriber createSubscriber(String email, String fname, String lname)
    {
        MergeFields newSubMF = new MergeFields();
        newSubMF.setFname(fname);
        newSubMF.setLname(lname);

        Subscriber newSub = new Subscriber();

        newSub.setEmailAddress(email);
        newSub.setStatus("subscribed");
        newSub.setMergeFields(newSubMF);
        return newSub;
    }

    //NOTE builds JSON object to pass to the API POST request
    private Tags createNewsletterTag()
    {
        Tag newSubTag = new Tag();
        newSubTag.setName("NewsletterSub");
        newSubTag.setStatus("active");

        List<Tag> tags = new ArrayList<>();
        tags.add(newSubTag);
        Tags tagList = new Tags();
        tagList.setTags(tags);

        return tagList;
    }
}