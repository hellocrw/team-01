package crw.bishe.team.service.mongo;

import crw.bishe.team.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoTestServiceImpl implements MongoTestService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增信息
     * @param demo
     */
    @Override
    public void save(Demo demo) {
        mongoTemplate.save(demo);
    }

    /**
     * 消改信息
     * @param demo
     */
    @Override
    public void update(Demo demo) {
        // 修改的条件
        Query query = new Query(Criteria.where("id").is(demo.getId()));
        // 修改的内容
        Update update = new Update();
        update.set("name", demo.getName());

        mongoTemplate.updateFirst(query, update, Demo.class);
    }

    /**
     * 查询所有信息
     * @return
     */
    @Override
    public List<Demo> findAll() {
        return mongoTemplate.findAll(Demo.class);
    }

    /**
     * 删除信息
     * @param id
     */
    @Override
    public void delete(String id) {
        Demo demo = mongoTemplate.findById(id , Demo.class);
        mongoTemplate.remove(demo);
    }
}
