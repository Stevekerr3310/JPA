package com.demo.springdata.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.springdata.files.entity.Image;
import com.demo.springdata.files.repository.ImageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileDataApplicationTests {
	
	@Autowired
	private ImageRepository repository;

	@Test
	public void testImageSave() throws IOException {
		Image image = new Image();
		image.setId(1L);
		image.setName("MAVN.JPG");
		
		File file = new File("D:\\PROJECT\\EDU\\JPA\\FileData\\src\\MAVEN.jpg");
		byte[] fileContent = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(fileContent);
		
		image.setData(fileContent);
		
		repository.save(image);
		fis.close();
	}
	
	@Test
	public void testReadImage() {
		Image image = repository.findOne(1L);
		File file = new File("D:\\PROJECT\\EDU\\JPA\\FileData\\src\\download\\" + image.getName());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(image.getData());
			fos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

