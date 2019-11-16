package com.nriagudubem.search.config;

//import edu.uci.ics.crawler4j.crawler.CrawlController;
//import edu.uci.ics.crawler4j.fetcher.PageFetcher;
//import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
//import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Slf4j
public class CrawlConfig {

//    @Bean
//    @Primary
//    public CrawlController crawlController() {
//        edu.uci.ics.crawler4j.crawler.CrawlConfig config = new edu.uci.ics.crawler4j.crawler.CrawlConfig();
//        config.setCrawlStorageFolder("../../../crawler4j/");
//        config.setPolitenessDelay(500);
//        config.setMaxDepthOfCrawling(3);
//        config.setMaxPagesToFetch(1000);
//        config.setIncludeBinaryContentInCrawling(false);
//        config.setResumableCrawling(false);
//        PageFetcher pageFetcher = new PageFetcher(config);
//        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
//        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
//        CrawlController controller = null;
//        try {
//            controller = new CrawlController(config, pageFetcher, robotstxtServer);
//        } catch (Exception ex) {
//            log.error("There was an error instantiating crawlController " + ex.getMessage());
//        }
//        return controller;
//    }
}
