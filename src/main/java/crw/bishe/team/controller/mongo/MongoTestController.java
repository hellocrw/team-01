package crw.bishe.team.controller.mongo;

import crw.bishe.team.entity.Demo;
import crw.bishe.team.service.mongo.MongoTestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"mongodb测试类"})
@RestController
public class MongoTestController {

    @Autowired
    private MongoTestService mongoTestService;

    @GetMapping("/findAll")
    public List<Demo> findAll(){
        return mongoTestService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Demo demo){
        mongoTestService.save(demo);
    }

    @PutMapping("/update")
    public void update(@RequestBody Demo demo){
        mongoTestService.update(demo);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        System.out.println(id);
        mongoTestService.delete(id);
    }

}
