package app.learn.stackoverflow.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteDto {
    private String favicon_url;
    private String audience;
    private String site_url;
    private String name;
}
