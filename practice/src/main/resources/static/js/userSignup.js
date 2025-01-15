
/* User Post 요청*/
document.getElementById("postUser").addEventListener("click", () => {
	const email = document.querySelector("#email").value;
	const password = document.querySelector("#password").value;
	const nickname = document.querySelector("#nickname").value;

	const body = {
		email: email,
		password: password,
		nickname: nickname
	}
	postRequest("/auth/signup", body)
		.then(response => response.json())
		.then(data => console.log(data))
})

