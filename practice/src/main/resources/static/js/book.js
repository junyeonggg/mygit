/* book Post요청*/
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
	postRequest("/books", body)
		.then(response => {
			console.log("URI 주소 : " + response.headers.get("Location"))
			return response.json();
		})
		.then(data => console.log(data))
		.catch(err => console.log("err : " + err));
})