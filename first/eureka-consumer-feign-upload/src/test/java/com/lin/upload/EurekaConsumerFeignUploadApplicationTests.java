package com.lin.upload;

import com.lin.upload.service.UploadService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaConsumerFeignUploadApplicationTests {
    @Autowired
	private UploadService uploadService;

	@Test
	public void contextLoads() {
	}

    @Test
    public void testUpload() {
        String path = this.getClass().getClassLoader().getResource("upload.txt").getPath();
        File file = new File(path);
        DiskFileItem diskFileItem = (DiskFileItem) new DiskFileItemFactory().createItem(
                "file", MediaType.TEXT_PLAIN_VALUE, true, file.getName());
        try(FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = diskFileItem.getOutputStream()) {
            IOUtils.copy(fileInputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MultipartFile multipartFile = new CommonsMultipartFile(diskFileItem);
        System.err.println(uploadService.handleFileUpload(multipartFile));
    }
}
