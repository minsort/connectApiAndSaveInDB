package app.learn.stackoverflow.service;

import app.learn.stackoverflow.model.SiteDto;
import app.learn.stackoverflow.model.SitesDto;
import app.learn.stackoverflow.model.StackoverflowWebsite;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class StackExchangeClient {

    RequestConfig requestConfig = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.STANDARD)
            .build();
    HttpClient httpClient = HttpClientBuilder.create()
            .setDefaultRequestConfig(requestConfig)
            .build();

    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
private RestTemplate restTemplate = new RestTemplate(requestFactory);


    public List<SiteDto> getSites() {
        String url = "https://api.stackexchange.com/2.3/sites?page=1&pagesize=2&filter=!)Qsyp5INb38jWvNt(CaBwjeI";

        try {
            SitesDto response = restTemplate.getForObject(new URI(url), SitesDto.class);
            return response.getItems();
        }catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
    }
}
