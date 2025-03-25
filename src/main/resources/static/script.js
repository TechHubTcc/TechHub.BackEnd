const container = document.querySelector(".usuarios");

const url = "localhost:8080/usuario/listar";

async function listarUsuarios() {
    const response = await fetch (url);
    const data = await response.json();

    const ul = document.createElement("ul");

    Object.entries(data).forEach(([c]))
}