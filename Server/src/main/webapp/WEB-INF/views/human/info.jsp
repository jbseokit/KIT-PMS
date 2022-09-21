<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">인적 정보 관리</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>

	<div class="panel-body">
		<table width="100%"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>사번</th>
					<th>이름</th>
					<th>영문이름</th>
					<th>생일</th>
					<th>전화번호</th>
					<th>휴대폰 번호</th>
					<th>이메일</th>
					<th>팩스번호</th>
					<th>주소</th>
					<th>상세주소</th>
					<th>우편번호</th>
					<th>부서코드</th>
					<th>입사일</th>
					<th>퇴사일</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>직급코드</th>
					<th>업무</th>
					<th>장애여부</th>
					<th>장애유형</th>
				</tr>
			</thead>
	
			<!-- DB정보 출력 -->
			<c:forEach items="${humanInfo}" var="info">
				<tr>
					<td><c:out value="${info.idx}" /></td>
					<td><c:out value="${info.mbr_sn}" /></td>
					<td><c:out value="${info.mbr_nm}" /></td>
					<td><c:out value="${info.mbr_enm}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${info.mbr_birth}" /></td>
					<td><c:out value="${info.mbr_tel}" /></td>
					<td><c:out value="${info.mbr_phone}" /></td>
					<td><c:out value="${info.mbr_em}" /></td>
					<td><c:out value="${info.mbr_fax}" /></td>
					<td><c:out value="${info.mbr_addr_bx}" /></td>
					<td><c:out value="${info.mbr_addr_dtl}" /></td>
					<td><c:out value="${info.mbr_addr_post}" /></td>
					<td><c:out value="${info.mbr_dep_cd}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${info.mbr_hired_d}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${info.mbr_fired_d}" /></td>
					<td><c:out value="${info.mbr_id}" /></td>
					<td><c:out value="${info.mbr_pw}" /></td>
					<td><c:out value="${info.mbr_cls_cd}" /></td>
					<td><c:out value="${info.mbr_main_task}" /></td>
					<td><c:out value="${info.mbr_dis}" /></td>
					<td><c:out value="${info.mbr_vtr}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>