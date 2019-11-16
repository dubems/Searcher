package com.nriagudubem.search.services;

import com.nriagudubem.search.httpClient.email.dto.GetEmailResponseDto;
//import edu.uci.ics.crawler4j.crawler.CrawlController;
//import edu.uci.ics.crawler4j.crawler.Page;
//import edu.uci.ics.crawler4j.crawler.WebCrawler;
//import edu.uci.ics.crawler4j.url.WebURL;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class CrawlerService {

//    private static final Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$");
//
//    private final CrawlController controller;
//
//
//    @Override
//    public boolean shouldVisit(Page referringPage, WebURL url) {
//        String href = url.getURL().toLowerCase();
//        return !FILTERS.matcher(href).matches();
//    }
//
//    @Override
//    public void visit(Page page) {
//        log.info("crawled page={}", page.getWebURL().getURL());
//    }
//
//    public void crawl(GetEmailResponseDto getEmailResponseDto) {
//        //add seed urls
//        int numberOfCrawlers = 8;
////        AtomicInteger numSeenImages = new AtomicInteger();
//        CrawlController.WebCrawlerFactory<CrawlerService> factory = () -> new CrawlerService(controller);
//
//        // Start the crawl. This is a blocking operation, meaning that your code
//        // will reach the line after this only when crawling is finished.
//        controller.start(factory, numberOfCrawlers);
//    }
}
