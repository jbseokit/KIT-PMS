<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<style>
.main {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	border: 1px solid lightgrey;
	border-radius: 5px;
	position: absolute;
	height: 300px;
	width: 500px;
	margin: -150px 0px 0px -200px;
	top: 50%;
	left: 50%;
	padding: 5px;
}

.logo {
	margin-top: 0px;
	margin-bottom: 40px;
}

#id {
	width: 100%;
}

#password {
	width: 100%;
}

#login {
	width: 100%;
	background-color: skyblue;
	border-color: transparent;
	color: white;
}

.account {
	display: block;
	margin-bottom: 3px;
	padding: 3px;
	border: 1px solid lightgray;
	border-radius: 3px;
}

#alert {
	border-color: transparent;
}
</style>
<body>
	<div class="main" id="divPosition">
		<h1 class="logo">KIT-PMS 사업 관리 시스템</h1>
		<div class="container">
			<input type="text" placeholder="ID" id="id" class="account">
			<input type="password" placeholder="Password" id="password"
				class="account">
			<button id="login" class="account">login</button>
			<p id="alert" class="account"></p>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		const id = document.getElementById('id')
		const password = document.getElementById('password')
		const login = document.getElementById('login')
		let errStack = 0;
		
		
		
		login.addEventListener('click', () => {
			if (id.value == 'acid') {
				if (password.value == '0000') {
					errStack -= 5;
					alert('로그인 되었습니다!')
					location.href = "/human/hr-list" ; //jsp 호출
				}
				else {
					alert('아이디와 비밀번호를 다시 한 번 확인해주세요!')
					errStack++;
				}
			} else {
		        alert('아이디와 비밀번호를 다시 한 번 확인해주세요!')
		    }

			if (errStack >= 5) {
				alert('비밀번호를 5회 이상 틀리셨습니다. 비밀번호 찾기를 권장드립니다.')
			}
		});
	
	});
</script>