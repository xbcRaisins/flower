package com.xbc.flower.xbcflowerboot.spider;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：
 *
 * @author weizeng
 * @date 2019/4/30 13:36
 */
public class NewsCrawler extends BreadthCrawler {

    private static final Logger log = LoggerFactory.getLogger(NewsCrawler.class);

    public NewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*start page*/
        this.addSeed("http://news.163.com");
        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
        this.addRegex("http://news.163.com/*.*html");
        /*do not fetch jpg|png|gif*/
        this.addRegex("+.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
        this.addRegex("-.*#.*");
    }

    public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        if (page.matchUrl("http://news.163.com/*.*html")) {
            Document doc = page.doc();
            String title = page.select("div[id=epContentLeft] > h1").first().text();
            String content = page.select("div[id=endText]").first().text();

            log.info("URL:{}", url);
            log.info("title:{}", title);
            log.info("content:{}", content);
        }
    }

    public static void main(String[] args) throws Exception {
        NewsCrawler crawler = new NewsCrawler("crawl", true);
        crawler.setThreads(50);
        crawler.start(4);
    }

}
