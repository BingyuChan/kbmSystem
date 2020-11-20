package miook.zust.kbmsystem.dao;

import miook.zust.kbmsystem.entity.TDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocDao extends JpaRepository<TDocument,Integer> {
    TDocument findByName(String name);
    TDocument findById(int id);
}
