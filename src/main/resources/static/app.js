function cargarUsuarios(){
    const response = await fetch("http://localhost:8080/users") // GET 1s
    const usuarios = await response.json()
    usuarios.forEach(user => {
        
    })
}