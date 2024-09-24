package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api(tags="通用接口")
public class CommonController {
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传: {}", file);
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        String path = "/Users/shenzixuan/Documents/GitHub/SkyTakeout/images/" + fileName;
        try {
            file.transferTo(new File(path));
        }catch (Exception e){
            e.printStackTrace();
        }
        String fileUrl = "http://localhost/api/common/upload/" + fileName;
        return Result.success(fileUrl);
    }
}
