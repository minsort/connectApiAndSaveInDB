package app.learn.stackoverflow.saver;

import app.learn.stackoverflow.model.SiteDto;
import app.learn.stackoverflow.model.StackoverflowWebsite;
import app.learn.stackoverflow.saver.ModelSaveObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface RepositorySaveObject extends CrudRepository<ModelSaveObject, Long> {

}
