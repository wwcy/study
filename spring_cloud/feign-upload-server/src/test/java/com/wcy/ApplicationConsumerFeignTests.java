package com.wcy;

import com.wcy.controller.TestClient;
import com.wcy.controller.Testcontroller;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationConsumerFeignTests {

	@Autowired
	private TestClient testClient;

	@Test
	public void contextLoads() {
		File file = new File("D:\\upload.txt");
		DiskFileItem fileItem = (DiskFileItem)new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE,true,file.getName());

		try(InputStream inputStream = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()){
			IOUtils.copy(inputStream,os);
		}catch (Exception e){
			e.printStackTrace();
		}
		MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
		System.out.println(testClient.handleFileUpload(multipartFile));
	}

}
