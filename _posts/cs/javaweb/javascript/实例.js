function byId(id){
    return typeof(id) === "string"?document.getElementById(id):id;
}

// 全局变量
var index = 0,
    timer = null,
    pics = byId("banner").getElementsByTagName("div"),
    dots = byId("dots").getElementsByTagName("span"),
    len = pics.length;


function slideimg(){
    var main = byId("main");
    main.onmouseover = function(){
        if(timer){clearInterval(timer)}
    }
    // 相当于：f1=》每执行一次index加一并console显示index
    
    main.onmouseout = function(){
        timer = setInterval(function(){
            index++;
            if (index >= len){
                index = 0;
            }
            changeImg();
        },2000);
    }
    main.onmouseout();

    for(var i=0; i<len; i++){
        dots[i].id = i;
        dots[i].onclick = function(){
           index = this.id;
           changeImg();
        }
    }



}
slideimg();


function changeImg(){
    console.log(index);
    for(var i=0; i<len; i++){
        pics[i].style.display = "none";
    }
    pics[index].style.display = "block";
}