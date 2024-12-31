function sendForm(requestType) {
	const url = "/bookC/"
	const title = document.querySelector("#title").value
	const author = document.querySelector("#author").value
	const publishedDate = document.querySelector("#publishedDate").value
	const price = document.querySelector("#price").value
	console.log("requestType: ", requestType)
	const data = {
		title: title,
		author: author,
		publishedDate: publishedDate,
		price: price
	}
	console.log(data)
	if (requestType == "jquery") {
		$.ajax({
			url: url + requestType,
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),
			success: data => console.log("jquery요청 성공")
		})
	} else if (requestType == "fetch") {
		fetch(url + requestType, {
			method: "post",
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify(data)
		}

		)
			.then((data) => {
				console.log("fetch요청 성공");
			})

	} else if (requestType == "axios") {
		axios({
			url: url + requestType,
			method: "post",
			headers: {},
			data: data
		})
			.then(data => console.log("axios요청 성공"))
	}
}

/* JQuery 요청*/
/* Fetch 요청*/
/* Axios 요청*/
