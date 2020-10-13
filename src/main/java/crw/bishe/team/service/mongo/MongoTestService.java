package crw.bishe.team.service.mongo;

import crw.bishe.team.entity.Demo;

import java.util.List;

public interface MongoTestService {

    void save(Demo demo);

    void update(Demo demo);

    List<Demo> findAll();

    void delete(String id);
}
