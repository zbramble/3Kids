package com.lls.core.controller;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scraper")
public class ScraperController {

    // Get all users
    @GetMapping("/data")
    public void testScraper() {
        try {
            // Connect to the website and get the HTML document
            Document doc = Jsoup.connect("https://langleymusic.com").get();

            // Select all <a> tags (links)
            Elements links = doc.select("a");

            // Print all links
            for (Element link : links) {
                System.out.println("Text: " + link.text());
                System.out.println("URL: " + link.attr("href"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
