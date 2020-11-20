package miook.zust.kbmsystem;

import miook.zust.kbmsystem.dao.DocDao;
import miook.zust.kbmsystem.dao.LikesDao;
import miook.zust.kbmsystem.dao.MyDocDao;
import miook.zust.kbmsystem.dao.UserDao;
import miook.zust.kbmsystem.entity.TDocument;
import miook.zust.kbmsystem.entity.TMyDoc;
import miook.zust.kbmsystem.entity.Tlikes;
import miook.zust.kbmsystem.service.DocServiceI;
import org.apache.tomcat.util.buf.UDecoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;
import java.util.List;

@SpringBootTest
class KbmsystemApplicationTests {
@Autowired
    DocServiceI docService;
@Autowired
    DocDao docDao;
@Autowired
    UserDao userDao;
@Autowired
    MyDocDao likesDao;
    @Test
    void contextLoads() {
        List<TMyDoc> tlikes = likesDao.findAllByUserId(2);
        for(TMyDoc tlike : tlikes) {
            System.out.println(tlike);
            int docId = tlike.getDocId();
            System.out.println(docDao.findById(docId));
        }
    }
    @Test
    void myDocSearchTest() {

    }
}
