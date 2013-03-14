document.onkeypress = rejeitaTecla;
document.onkeydown = rejeitaTecla;
document.oncontextmenu = alerta;
function alerta() {
	alert('Conte\u00fado do site bloqueado!');
	return false;
}

function rejeitaTecla(oEvent) {
	var oEvent = null;
	oEvent = oEvent ? oEvent : window.event;
	var tecla = (oEvent.keyCode) ? oEvent.keyCode : oEvent.which;
	if (tecla == 17) {
		alerta();
	}

}
function drop(ev) {
	ev.preventDefault();
	ev.dataTransfer.setData("Text", "");
}

function printsreen() {
	clipboardData.clearData();
	ev.dataTransfer.setData("Text", "");
}
setInterval("printsreen();", 1);