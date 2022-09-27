<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    

<%@ include file="/WEB-INF/views/includes/header.jsp"%>


        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">소프트웨어 세부 정보</h3></div>
                                    <div class="card-body">
                                        
                                            
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="idx" value="${software.idx}" readonly="readonly" />
                                                        <label>번호</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_nm" value="${software.sw_nm}" readonly="readonly" />
                                                        <label>소프트웨어 이름</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_use_dep" value="${software.sw_use_dep}" readonly="readonly" />
                                                        <label>사용 부서</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_man_dep" value="${software.sw_man_dep}" readonly="readonly" />
                                                        <label>관리 부서</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_num" value="${software.sw_num}" readonly="readonly"/>
                                                        <label>소프트웨어 일련번호</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_com" value="${software.sw_com}" readonly="readonly"/>
                                                        <label>제조사</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_buy_date" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${software.sw_buy_date}" />' readonly="readonly"/>
                                                        <label>구매 일자</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_ins_date" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${software.sw_ins_date}" />' readonly="readonly"/>
                                                        <label>설치 일자</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_ins_date" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${software.sw_ins_date}" />' readonly="readonly"/>
                                                        <label>갱신 일자</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_tel" value="${software.sw_tel}" readonly="readonly"/>
                                                        <label>제조사 전화번호</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_amount" value="${software.sw_amount}" readonly="readonly"/>
                                                        <label>수량</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div>
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="sw_price" value="${software.sw_price}" readonly="readonly"/>
                                                        <label>가격</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid">
                                                	<div>
	                                                	<button data-oper = "modify" class="btn btn-primary" onclick = "location.href = '/material/sw/modify?idx=${software.idx}'">수정</button>
		            									<button data-oper = "remove" class="btn btn-danger" onclick = "location.href = '/material/sw/remove?idx=${software.idx}'">삭제</button>
	                                                	<button data-oper = "list" class="btn btn-primary" onclick = "location.href = '/material/sw/list'">목록</button>
                                                	</div>
                                            	</div>
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        
        <script type="text/javascript">
		$(document).ready(function (){
		var operForm = $("#operForm");
		
		$("button[data-oper='list']").on("click", function(e){
			e.preventDefault();
			operForm.find("#idx").remove();
			operForm.attr("action","/material/sw/list");
			operForm.submit();
		});
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action","/material/sw/modify");
			operForm.submit();
		});
		
		$("button[data-oper='remove']").on("click", function(e){
			e.preventDefault();
			operForm.attr("action","/material/sw/remove").submit();
		});
		
		});
		</script>


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>