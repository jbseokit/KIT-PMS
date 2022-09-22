package kr.hkit.pms.service.human;

import java.util.List;

import kr.hkit.pms.domain.common.Criteria;
import kr.hkit.pms.domain.human.AttendMgtDto;
import kr.hkit.pms.domain.human.HumanInfoMgtDto;
import kr.hkit.pms.domain.human.VacationMgtDto;

public interface HumanResourcesService {
	// -----------------------------hr Service-----------------------------
	
	//public List<HumanInfoMgtDto> getInfoList();
	
	
	public List<HumanInfoMgtDto> selectHrList(Criteria cri);
	
	public void registerHr(HumanInfoMgtDto human);
	
	
	// -----------------------------at service-----------------------------
	
	
	//public List<AttendMgtDto> getAttendList(); 
	
	
	
	public List<AttendMgtDto> selectAtList(Criteria cri); 
	
	
	
	
	// -----------------------------va service-----------------------------
	
	
	//public List<VacationMgtDto> getVacationList();
	
	
	public List<VacationMgtDto> selectVaList(Criteria cri);
	
	
	
	
}
