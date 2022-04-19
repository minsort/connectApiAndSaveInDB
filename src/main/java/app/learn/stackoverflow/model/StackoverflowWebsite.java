package app.learn.stackoverflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class StackoverflowWebsite implements Serializable{

    private final String favicon_url;
    private final String audience;
    private final String site_url;
    private final String name;


}
