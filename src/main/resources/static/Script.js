async function loadAlbum() {
    try {
        const response = await fetch('/api/albums/today');

        if (response.status === 204) {
            const randomResponse = await fetch('/api/albums/random', { method: 'POST' });
            const album = await randomResponse.json();
            displayAlbum(album);
            return;
        }

        if (!response.ok) {
            throw new Error('Erro ao carregar');
        }

        const album = await response.json();
        displayAlbum(album);

    } catch (error) {
        console.error('Erro:', error);
        document.getElementById('content').innerHTML = '<h2>Erro ao carregar álbum</h2>';
    }
}

function displayAlbum(album) {
    const spotifyUrl = `https://open.spotify.com/album/${album.albumUrl.split(':')[2]}`;
    const year = album.releaseDate.split('-')[0];

    document.getElementById('content').innerHTML = `
        <div class="album-section">
            <div class="album-image">
                <img src="${album.imageUrl}" alt="${album.albumName}">
            </div>
            <div class="album-info">
                <p class="album-artist">${album.artistName}</p>
                <h2 class="album-title">${album.albumName}</h2>
                <p class="album-date">Lançado em ${year}</p>
            </div>
        </div>
        <div class="button-group">
            <a href="${spotifyUrl}" target="_blank" class="btn btn-primary">
                Ouvir no Spotify
            </a>
        </div>
    `;
}

document.addEventListener('DOMContentLoaded', loadAlbum);

setInterval(loadAlbum, 3600000);