package kr.hkit.pms.service.human;

import java.util.List;

import kr.hkit.pms.domain.common.Criteria;
import kr.hkit.pms.domain.human.AttendMgtDto;
import kr.hkit.pms.domain.human.HumanInfoMgtDto;
import kr.hkit.pms.domain.human.VacationMgtDto;

public interface HumanResourcesService {
	// -----------------------------hr Service-----------------------------
	
	// R
	public List<HumanInfoMgtDto> selectHrList(Criteria cri);
	public HumanInfoMgtDto selectHr(String mbr_sn);
	
	// C
	public void registerHr(HumanInfoMgtDto human);
	
	// U
	public void modifyHr(HumanInfoMgtDto human);
	
	// D
	public String removeHr(String mbr_sn);
	
	// -----------------------------at service-----------------------------
	
	
	//public List<AttendMgtDto> getAttendList(); 
	
	
	
	public List<AttendMgtDto> selectAtList(Criteria cri);
	public void registerAt(AttendMgtDto attend);
	
	
	
	
	// -----------------------------va service-----------------------------
	
	
	//public List<VacationMgtDto> getVacationList();
	
	
	public List<VacationMgtDto> selectVaList(Criteria cri);
	public void registerVa(VacationMgtDto vacation);
	
	
	
	
}
