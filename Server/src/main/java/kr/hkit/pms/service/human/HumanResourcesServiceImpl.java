package kr.hkit.pms.service.human;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hkit.pms.domain.common.Criteria;
import kr.hkit.pms.domain.human.AttendMgtDto;
import kr.hkit.pms.domain.human.HumanInfoMgtDto;
import kr.hkit.pms.domain.human.VacationMgtDto;
import kr.hkit.pms.mapper.human.AttendanceMgtMapper;
import kr.hkit.pms.mapper.human.HumanInfoMgtMapper;
import kr.hkit.pms.mapper.human.VacationMgtMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class HumanResourcesServiceImpl implements HumanResourcesService {
	
	@Autowired
	HumanInfoMgtMapper hmm; 
	
	@Autowired
	AttendanceMgtMapper admm; 
	
	@Autowired
	VacationMgtMapper vmm;
	
	// -----------------------------hr Service-----------------------------
	
	// 페이징 처리 List
	@Override
	public List<HumanInfoMgtDto> selectHrList(Criteria cri) {
		return hmm.readList(cri);
	}
	
	@Override
	public void registerHr(HumanInfoMgtDto human) {
		log.info("-----hr 등록 서비스");
		hmm.create(human);
		
	}
	
	// -----------------------------at service-----------------------------
	


	@Override
	public List<AttendMgtDto> selectAtList(Criteria cri) {
		return admm.getList();
	}
	
	// -----------------------------va service-----------------------------
	
	@Override
	public List<VacationMgtDto> selectVaList(Criteria cri) {
		return vmm.getList();
	}

	
}
