package com.lls.core.controller;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lls.core.util.DynamoDBUtil;

@RestController
@RequestMapping("/scraper")
public class ScraperController {

    // Get all users
    @GetMapping("/data")
    public void testScraper() {
        try {
            // Connect to the website and get the HTML document
            Document doc = Jsoup.connect("https://www.walmart.ca/en").get();

            // Select all <a> tags (links)
            Elements links = doc.select("li");

            // Print all links
            for (Element link : links) {
                System.out.println("Class: " + link.className());
                // System.out.println("URL: " + link.attr("href"));
            }

            DynamoDBUtil.writeToDynamoDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
