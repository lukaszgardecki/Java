function showNewHeading() {
    let newHeading = document.getElementById("news");
    console.log(newHeading.innerHTML);
}
showNewHeading();


function showFirstNews() {
    let newsList = document.getElementById("news-list");
    console.log(newsList.getElementsByTagName("li")[0].innerHTML);
  
}
showFirstNews();

function showSportNews() {
    let sportNews = document.querySelectorAll("ul#sport-news > li");
    sportNews.forEach(el => console.log(el.innerHTML));
    // for (let i = 0; i < sportNews.length; i++) {
    //     const element = sportNews[i];
    //     console.log(element.innerHTML);
    // }
}

showSportNews();