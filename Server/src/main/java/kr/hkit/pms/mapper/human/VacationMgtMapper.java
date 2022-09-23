package kr.hkit.pms.mapper.human;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.hkit.pms.domain.common.Criteria;
import kr.hkit.pms.domain.human.VacationMgtDto;

@Mapper
public interface VacationMgtMapper {
	// 페이징 적용
	public List<VacationMgtDto> readList(Criteria cri);
	public VacationMgtDto read();
	
	public void create(VacationMgtDto vacation); 
	
	public void update();
	
	public void delete();
}
