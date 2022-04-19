package app.learn.stackoverflow.saver;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name="models")
public class ModelSaveObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String favicon_url;
    private final String audience;
    private final String site_url;
    private final String name;
}
