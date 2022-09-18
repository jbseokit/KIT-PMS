package kr.hkit.pms.domain.human;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttendanceMgtDto {
	int idx;
	String atdNm;
	String atdSn;
	Date   atdGw;
	Date   ateLw;
	String atdBt;
	String atdBtDt;
	String atdBtCt;
	String atdDp;
	String atdDpDt;
	String spare1;
	String spare2;
	String spare3;
	String rgtrId;
	Date   rgtrDt;
	String mdfrId;
	Date   mdfrDt;
}
