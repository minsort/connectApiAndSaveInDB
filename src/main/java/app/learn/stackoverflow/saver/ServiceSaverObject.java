package app.learn.stackoverflow.saver;

import app.learn.stackoverflow.model.SiteDto;
import app.learn.stackoverflow.service.StackExchangeClient;
import app.learn.stackoverflow.service.StackoverflowService;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Service
public class ServiceSaverObject {

    @Autowired
    private RepositorySaveObject repositorySaveObject;

    @Autowired
    private StackoverflowService stackoverflowService;

    @Autowired
    StackExchangeClient stackExchangeClient;

     public void listOfProviders() throws Exception {
         List<ModelSaveObject> finalSites = new ArrayList<>();

         List<ModelSaveObject> modelSaveObject = findAll();

         repositorySaveObject.saveAll(modelSaveObject);
     }


    public List<ModelSaveObject>findAll() throws URISyntaxException {
        return stackExchangeClient.getSites().stream()
                .map(this::saveModel)//преобразуем то что вернул stackExchangeClient
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));//возвращаем в виде списка
    }

    private ModelSaveObject saveModel (@NonNull SiteDto input){
        return new ModelSaveObject(
                input.getSite_url().substring("http://".length(), input.getSite_url().length() - ".com".length()),
                input.getFavicon_url(),
                input.getName(),
                input.getAudience());
    }



}