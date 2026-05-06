const board = document.getElementById('board');
const colorPicker = document.getElementById('color');
const API_URL = 'http://localhost:8080/api/v1/pixels';
const SIZE = 100;

function createBoard() {
    // Limpiamos el board por si acaso
    board.innerHTML = ''; 
    
    for (let y = 0; y < SIZE; y++) {
        for (let x = 0; x < SIZE; x++) {
            const pixel = document.createElement('div');
            pixel.classList.add('pixel');
            pixel.id = `p-${x}-${y}`;
            
            // Color inicial blanco para que sean visibles
            pixel.style.backgroundColor = '#ffffff'; 

            pixel.addEventListener('click', () => {
                const color = colorPicker.value;
                paintPixel(x, y, color, pixel);
            });

            board.appendChild(pixel);
        }
    }
}

async function paintPixel(x, y, color, element) {
    try {
        // Estructura PixelModel: x, y, color
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ x, y, color })
        });

        if (response.ok) {
            element.style.backgroundColor = color;
        }
    } catch (err) {
        console.error("Error al conectar con el backend:", err);
        // Pintamos de todas formas en el cliente para probar si no hay backend
        element.style.backgroundColor = color; 
    }
}

async function loadPixels() {
    try {
        const response = await fetch(API_URL);
        if (response.ok) {
            const pixels = await response.json();
            pixels.forEach(p => {
                const el = document.getElementById(`p-${p.x}-${p.y}`);
                if (el) el.style.backgroundColor = p.color;
            });
        }
    } catch (err) {
        console.warn("No se pudieron cargar píxeles previos.");
    }
}

// Iniciar cuando la ventana esté lista
window.onload = () => {
    createBoard();
    loadPixels();
};