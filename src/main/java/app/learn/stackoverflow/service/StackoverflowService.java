package app.learn.stackoverflow.service;

import app.learn.stackoverflow.model.SiteDto;
import app.learn.stackoverflow.model.StackoverflowWebsite;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class StackoverflowService {

    @Autowired
    StackExchangeClient stackExchangeClient;

    public List<StackoverflowWebsite>findAll() throws URISyntaxException {
        return stackExchangeClient.getSites().stream()
        .map(this::toStackoverflowWebsite)//преобразуем то что вернул stackExchangeClient
        .collect(collectingAndThen(toList(), ImmutableList::copyOf));//возвращаем в виде списка
    }

    private StackoverflowWebsite toStackoverflowWebsite(@NonNull SiteDto input){
return new StackoverflowWebsite(
        input.getSite_url().substring("http://".length(), input.getSite_url().length() - ".com".length()),
        input.getFavicon_url(),
        input.getName(),
        input.getAudience());
    }
}
