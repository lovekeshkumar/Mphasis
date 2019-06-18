var posts = [];

function getPosts() {
    fetch('http://jsonplaceholder.typicode.com/posts')
        .then((res) => res.json())
        .then((res) => {
            posts = res
            mapPosts();
        })
        .catch((error) => console.log(error))
}

function mapPosts() {
    var cardsRef = document.getElementById('cards');
    cardsRef.innerHTML = "";

    for (var i = 0; i < posts.length; i++) {
        cardsRef.innerHTML +=
            "<div class='card mb-2' >" +
            "<div class='card-body' >" +
            "<h5 class='card-title'>" + posts[i].title + "</h5><hr/>" +
            
            "<p class='card-text'>"
            + posts[i].body +
            "</p>" +
            "</div>" +
            "</div>";
    }

}