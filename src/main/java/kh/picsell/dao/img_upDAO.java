package kh.picsell.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.picsell.dto.img_upDTO;

@Repository
public class img_upDAO {
	@Autowired
	private SqlSessionTemplate jdbc;
	public List<img_upDTO> getNoList() throws Exception{ //승인안된사진목록
		return jdbc.selectList("Img.getNoList");
	}
	public List<img_upDTO> getYesList() throws Exception{ //승인된사진목록
		return jdbc.selectList("Img.getYesList");
	}
	public int accept(int img_seq) throws Exception{ //승인하기
		return jdbc.update("Img.accept", img_seq);
	}
	public int delete(int img_seq) throws Exception{ //삭제하기
		return jdbc.delete("Img.delete", img_seq);
	}
}
