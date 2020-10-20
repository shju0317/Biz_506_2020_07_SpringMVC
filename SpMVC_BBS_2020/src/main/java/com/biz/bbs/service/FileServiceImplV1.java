package com.biz.bbs.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService {
	
	/*
	 * BbsController의 write POST에서 파일을 수신한 후
	 * 이곳으로 전달하여 실제 서버로 파일을 복사하는 코드를 생성
	 */
	public String fileUp(MultipartFile file) {
		
		// 파일 이름 추출
		String fileName = file.getOriginalFilename();
		
		// tomcat서버의 홈 디렉토리
		String rootPath = System.getProperty("catalina.home");
		
		File dir = new File(rootPath, "tmpFolder");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		// 이미 있거나 생성된 tmpFolder와 업로드할 파일 이름을 연결하여
		// 파일 정보로 생성
		File serverSaveFile = new File(dir.getAbsolutePath(), fileName);
		
		FileOutputStream outFile;
		try {
			outFile = new FileOutputStream(serverSaveFile);
			BufferedOutputStream outStream = new BufferedOutputStream(outFile);
			
			//BIN파일을 OutputStream을 저장하기
			byte[] fileData = file.getBytes(); // 파일 크기 추출
			
			outStream.write(fileData);
			outStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
