package com.test.springbootproject01.Controller;
import com.test.springbootproject01.pojo.Result;
import com.test.springbootproject01.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@Slf4j
/*@RequestMapping("/emps")*/
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException{
        log.info("传输数据{}",image.getOriginalFilename());
        String url=aliOSSUtils.upload(image);
        System.out.println(url);
        log.info("文件的URL为{}",url);
        return Result.success(url);
    }
    @PutMapping("/upload")
    public Result upload2(MultipartFile image) throws IOException{
        log.info("传输数据{}",image.getOriginalFilename());
        String url=aliOSSUtils.upload(image);
        System.out.println(url);
        log.info("修改后的文件的URL为{}",url);
        return Result.success(url);
    }
}
