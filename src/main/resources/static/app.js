async function cargarUsuarios(){
    // Javascript vanilla
    //console.log("Voy a cargar los usuarios...")
    // Obtener loos usuarios en forma json
    const response = await fetch("http://localhost:8080/users") // GET  1s
    const usuarios = await response.json()
    usuarios.forEach(user  => {
        // Creo un div nuevo
        const card = document.createElement("div");
        // Meto dentro del div con id = usuarios

    })

}