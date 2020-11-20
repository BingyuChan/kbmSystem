package miook.zust.kbmsystem.controller;

import miook.zust.kbmsystem.entity.TDocument;
import miook.zust.kbmsystem.service.DocServiceI;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.model.FileListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Iterator;

//swagger用@RestController进行注解
@Controller
@RequestMapping("doc")
public class DocController {
    @Autowired
    DocServiceI docService;

    @GetMapping("/upload")
    public String toUploadPage(){
        return "upload";
    }
    @PostMapping("/upload")
    public ModelAndView uploadFile(@RequestParam MultipartFile file) throws IOException {
        ModelAndView mav = new ModelAndView();

//        String fileName = docService.uploadFile(file);


        FileListing files = docService.listFiles();
        mav.addObject("fmap",files.items);
        mav.setViewName("upload");
        return mav;
    }
//    @GetMapping("/list")
//    public ModelAndView toList() throws QiniuException {
//        ModelAndView mav = new ModelAndView();
//        FileListing files = docService.listFiles();
//        mav.addObject("fmap",files.items);
//        mav.setViewName("list");
//        return mav;
//    }
    @GetMapping("/delete")
    public String deleteFile(@RequestParam String key) throws QiniuException {
        docService.deleteFile(key);
        return "redirect:list";
    }

    @RequestMapping("likes")
    public ModelAndView getDocLikes(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "2") int pageSize) {
        ModelAndView mav = new ModelAndView("likes");
        System.out.println("============================");
        Page<TDocument> docs=docService.getDocLikes(pageNum, pageSize);
        System.out.println("总页数" + docs.getTotalPages());
        System.out.println("当前页是：" + pageNum+1);

        System.out.println("分页数据：");
        Iterator<TDocument> u = docs.iterator();
        while (u.hasNext()){
            System.out.println(u.next().toString());
        }
        mav.addObject("doclikes", docs);
        return mav;
    }

    @RequestMapping("list")
    public ModelAndView getDoclist(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
        ModelAndView mav = new ModelAndView("list");
        System.out.println("============================");
        Page<TDocument> docs=docService.getDoclist(pageNum, pageSize);
        System.out.println("总页数" + docs.getTotalPages());
        System.out.println("当前页是：" + pageNum+1);

        System.out.println("分页数据：");
        Iterator<TDocument> u = docs.iterator();
        while (u.hasNext()){
            System.out.println(u.next().toString());
        }
        mav.addObject("docs", docs);
        return mav;
    }
}
