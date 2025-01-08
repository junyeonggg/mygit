function sendRequest(url, method, body = null) { //통합 한 이름을 sendRequest라 하겠다
	//headers 정의
	const headers = {
		"Content-Type": "application/json"
	}

	//method,header,body가 들어갈 opstions 정의
	const options = {
		method: method,
		headers: headers
	}
	// 만약 post,patch와 같이 body가 있으면 options에 추가
	if (body) {
		options.body = JSON.stringify(body);
	}
	return fetch(url, options)
}


// 래퍼 함수들 
function postRequest(url, body) {
	return sendRequest(url, "POST", body);
}
function getRequest(url) {
	return sendRequest(url, "GET");
}
function patchRequest(url, body) {
	return sendRequest(url, "PATCH", body);
}
function deleteRequest(url) {
	return sendRequest(url, "DELETE");
}


document.getElementById("postRequest").addEventListener("click", () => {
	const title = document.querySelector("#title").value
	const author = document.querySelector("#author").value
	const publishedDate = document.querySelector("#publishedDate").value
	const price = document.querySelector("#price").value

	const body = {
		title: title,
		author: author,
		publishedDate: publishedDate,
		price: price
	}
	postRequest("/books",body)
	.then(response => {
		console.log("URI 주소 : "+response.headers.get("Location"))
		return response.json();
	})
	.then(data => console.log(data))
	.catch(err => console.log("err : "+err));
		
		
})