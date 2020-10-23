package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.bbs.mapper.BbsDao;
import com.biz.bbs.mapper.ImageDao;
import com.biz.bbs.model.BbsVO;
import com.biz.bbs.model.ImageVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("bbsServiceV1")
public class BbsServiceImplV1 implements BbsService{
	
	@Autowired
	protected  BbsDao bbsDao;
	
	@Autowired
	protected ImageDao imageDao;
	
	@Autowired
	@Qualifier("fileServiceV5")
	private FileService fileService;

	@Override
	public List<BbsVO> selectAll() {
		return bbsDao.selectAll();
	}

	@Override
	public void insert(BbsVO bbsVO, MultipartFile file) {
		String fileName = fileService.fileUp(file);
		bbsVO.setB_file(fileName);
		
		bbsDao.insert(bbsVO);
		
	}

	@Override
	public BbsVO findBySeq(long long_seq) {
		
		BbsVO bbsVO = bbsDao.findBySeq(long_seq);
		List<ImageVO> images = imageDao.findByBSeq(long_seq);
		
		bbsVO.setImages(images);
		
		return bbsVO;
	}

	@Override
	public int delete(long long_seq) {
		
		/*
		 * 첨부파일이 있는 게시판의 데이터를 삭제할 때는
		 * 1. seq에 해당하는 VO를 dao에서 findBySeq()하고
		 * 2. 파일이름을 fileDelete()에 보내서 파일을 먼저 삭제
		 * 3. 게시판 데이터를 삭제
		 */
		BbsVO bbsVO = bbsDao.findBySeq(long_seq);
		
		String b_file = bbsVO.getB_file();
		if(b_file != null) {
			fileService.fileDelete(b_file);
		}
		
		return bbsDao.delete(long_seq);
	}

	@Override
	public void insert(BbsVO bbsVO) {
		// 안써요호~
		
	}

	@Override
	public List<String> insert(BbsVO bbsVO, MultipartHttpServletRequest files) {
		
		/*
		 * 업로드된 멀티파일 정보에서 개별 파일들을 List에 추출
		 * file.getFiles(이름) : "이름"은 input태그의 name값
		 */
		List<MultipartFile> fileList = files.getFiles("files");
		
		for(MultipartFile f : fileList) {
			log.debug("업로드된 파일 {}", f.getOriginalFilename());
			
		}
		
		// 1. 파일업로드를 수행하고 파일이름 리스트를 확보했다.
		List<ImageVO> fileNames = fileService.filesUp(files);
		
		// 2. bbsVO를 insert 수행
		bbsDao.insert(bbsVO);
		long b_seq = bbsVO.getB_seq();
		log.debug("BBS SEQ {}", b_seq);
		
		for(ImageVO vo : fileNames) {
			imageDao.insert(vo, b_seq);
		}
		
		return null;
	}
}
