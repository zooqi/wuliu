var g_fDiv;
var l2r = 1;
function movePic(pic) {
	var xpos = parseInt(pic.style.left);
	var ypos = parseInt(pic.style.top);
	var picWidth = parseInt(pic.style.width); //浮动DIV大小  
	var picHeight = parseInt(pic.style.height);
	var bodyWidth = document.body.clientWidth; //主窗口大小，有没有更好的获取方式？  
	var bodyHeight = document.body.clientHeight;

	var step = 1;
	if (l2r == 1) { //当前是左->右  
		xpos += step;
		if (xpos + picWidth >= bodyWidth) {
			l2r = 0;
			xpos -= step;
		}
	} else {
		xpos -= step;
		if (xpos <= 0) {
			l2r = 1;
			xpos += step;
		}
	}
	pic.style.left = xpos + "px";
	pic.style.top = ypos + "px";
	setTimeout('movePic(g_fDiv)', 18); // 第一个参数为执行的语句，不是函数名  
}

function startFloat(picPath) {

	var fDiv = document.createElement("div");
	g_fDiv = fDiv;
	fDiv.innerHTML = '<img src="' + picPath + '" />';
	fDiv.style.display = "block";
	fDiv.style.position = "absolute";

	fDiv.style.left = 0;
	fDiv.style.top = 0;
	fDiv.style.width = "400px";
	fDiv.style.height = "300px";
	document.body.appendChild(fDiv);
	document.body.clientTop
	//开始浮动  
	movePic(fDiv);
}

function addLoadEvent(func) {
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function() {
			oldonload();
			func();
		}
	}
}

addLoadEvent(function() {
	startFloat('img/head.png');
});