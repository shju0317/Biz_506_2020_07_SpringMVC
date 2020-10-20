package com.biz.bbs.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 파일을 upload 프로젝트에서 외부에 파일을 공개하기 위해 폴더를 개방해두면
 * 폴더를 외부에서 접근하여 해킹을 수행하는 경우들이 발생할 수 있다.
 * 
 * 특히 프로젝트 구조를 알게되는 경우 같은 이름의 파일을 엉뚱한 파일로
 * 업로드하여 원래 저장되어있던 파일을 변형하는 일들이 발생할 수 있다(image injection).
 * 
 * 파일을 업로드 할 때 원래 파일이름(originalName)을 감추고
 * 서버에서 별도의 파일이름을 생성하여 저장해주는 것이 좋다.
 */

@Slf4j
@RequiredArgsConstructor
@Service("fileServiceV4")
public class FileServiceImplV4 extends FileServiceImplV1 {

	/*
	 * servlet-context.xml에서 static으로 설정한 폴더에 접근하기 위한 보조도구
	 */
	private final ResourceLoader resourceLoader;
	
	@Override
	public String fileUp(MultipartFile file) {

		String rootFolder = "C:/bizwork/workspace/upload";
		File dir = new File(rootFolder);
		
		// file을 upload할 폴더를 검사하여 없으면 새로 생성해달라
		if(!dir.exists()) {
			// mkdir()은 제일 끝의 폴더 1개만 생성
			// mkdirs()는 모든 경로의 폴더를 한꺼번에 생성
			dir.mkdirs();
		}
		
		// 원본파일
		String originalFileName = file.getOriginalFilename();
		
		/*
		 * 원본파일이름을 임의 값을 부착한 변형된 파일 이름으로 바꾸기
		 * 1. UUID 값을 생성하고
		 * 2. 원본 파일이름에 UUID를 부착하기
		 * 3. UUID값이 부착된 파일이름은 서버에 업로드가 될것이고
		 *    만약 해커가 해당 파일이름을 알게되어 동일한 이름의 파일을 만들어
		 *    업로드하더라도 새로운 UUID가 부착되어 원래 저장도니 파일을 보호한다.
		 */
		
		String strUUID = UUID.randomUUID().toString();
		String saveFileName = strUUID + originalFileName;
		
		// 서버의 저장폴더 + 파일이름을 합성하여 파일 저장 준비
		File saveFile = new File(rootFolder, saveFileName);
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// UUID가 부착된 파일이름을 Controller로 return하여 DB에 저장하는
		// 용도로 사용한다.
		return saveFileName;
	}
	
}
