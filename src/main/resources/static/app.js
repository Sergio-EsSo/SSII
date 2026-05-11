async function cargarUsuarios(){
    // Javascript vanilla
    //console.log("Voy a cargar los usuarios...")
    // Obtener loos usuarios en forma json
    const response = await fetch("http://localhost:8080/users") // GET  1s
    const usuarios = await response.json()
    const contenedor = document.getElementById("usuarios")
    contenedor.innerHTML=""
    usuarios.forEach(user  => {
        // Creo un div nuevo
        const card = document.createElement("div");
        card.className="usuario_card"
        // Meto dentro del div con id = usuarios
        contenedor.appendChild(card)
        card.innerHTML = `
            <div>${user.name}</div>
            <div>${user.email}</div>
        `
    })
}