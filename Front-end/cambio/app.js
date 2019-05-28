const $real = document.querySelector("#real");
const $dolar = document.querySelector("#dolar");
const $euro = document.querySelector("#euro");

let valor_dolar;
let valor_euro;

async function get() {
	
		let response = await fetch("data.json");
		let dados = await response.json();
		valor_dolar = dados["dolar"];
		valor_euro = dados["euro"];
}


function real() {
	$dolar.value = $real.value / valor_dolar;
	$euro.value = $real.value / valor_euro;
}

function dolar() {
	$real.value = valor_dolar * $dolar.value;
	$euro.value = $real.value / valor_euro;
}

function euro() {
	$real.value = $euro.value * valor_euro;
	$dolar.value = $real.value / valor_dolar;
}


$real.onkeyup = real;
$dolar.onkeyup = dolar;
$euro.onkeyup = euro

get();