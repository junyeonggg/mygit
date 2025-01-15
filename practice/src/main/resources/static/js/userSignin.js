

// 로그인
document.getElementById("signinBtn").addEventListener("click", () => {
	const email = document.querySelector("#email").value;
	const password = document.querySelector("#password").value;

	const body = {
		email: email,
		password: password
	}
	postRequest("/auth/signin", body)
		.then(response => {
			if (!response.ok) {
				window.alert("사용자를 찾을 수 없습니다.")
				return response.json()
			} else {
				window.location.replace("/")
			}
		})
})