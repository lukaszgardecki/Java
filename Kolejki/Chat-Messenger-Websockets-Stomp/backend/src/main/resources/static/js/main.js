'use strict';

const disconnectButton = document.querySelector('#logout');
const usernamePage = document.querySelector('#username-page');
const chatPage = document.querySelector('#chat-page');
const usernameForm = document.querySelector('#usernameForm');
const messageForm = document.querySelector('#messageForm');
const messageInput = document.querySelector('#message');
const messageArea = document.querySelector('#messageArea');

let stompClient = null;
let username = null;

const toast = async(type, message, timer= 5000) => {
    await Swal.mixin({
        toast: true,
        position: 'top-end',
        timer: timer,
        showCloseButton: true,
        timerProgressBar: true,
        showConfirmButton: false,
        didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer)
            toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
    }).fire({
        timer: timer,
        icon: type,
        html: message,
    });
}

/**
 * Ta funkcja zwraca aktualny czas w formacie GG:MM.
 * Rozpoczyna od utworzenia nowego obiektu Date o nazwie today.
 * Następnie używa metod getHours() i getMinutes(), aby uzyskać odpowiednio aktualną godzinę i minuty.
 * Na koniec łączy te wartości w ciąg znaków i zwraca go.
 *
 * @returns {`${number}:${number}`}
 */
const getCurrentTime = () => {
    const today = new Date();
    return `${today.getHours()}:${today.getMinutes()}`;
}

/**
 * Ta funkcja przyjmuje nazwę użytkownika jako argument i zwraca kolor.
 * Funkcja rozpoczyna od obliczenia wartości skrótu (hash).
 * Wartość skrótu jest obliczana przez pomnożenie wartości ASCII każdego znaku nazwy użytkownika przez 31 oraz dodanie ich do siebie.

 * Po obliczeniu wartości skrótu,
 * funkcja oblicza indeks koloru do zwrócenia.
 * Indeks jest obliczany przez wzięcie wartości bezwzględnej wartości skrótu i podzielenie jej przez liczbę kolorów.

 * Na koniec funkcja zwraca kolor znajdujący się pod obliczonym indeksem.
 *
 * @param username
 * @returns {string}
 */

const getAvatarColor = username => {
    let hash = 0;
    const colors = [
        '#2196F3', '#32c787', '#00BCD4', '#ff5652',
        '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
    ];

    for (let i = 0; i < username.length; i++) {
        hash = 31 * hash + username.charCodeAt(i);
    }

    let index = Math.abs(hash % colors.length);
    return colors[index];
}

/**
 * Ta funkcja jest wywoływana po kliknięciu przez użytkownika przycisku "Połącz".
 * Najpierw funkcja pobiera nazwę użytkownika z danych wprowadzonych przez użytkownika.
 * Jeśli nazwa użytkownika nie jest pusta, funkcja ukrywa stronę z formularzem logowania i wyświetla stronę czatu.
 *
 * Następnie funkcja tworzy nowy obiekt SockJS oraz nowy obiekt Stomp.
 * Obiekt SockJS służy do nawiązania połączenia z serwerem WebSocket.
 * Obiekt Stomp służy do wysyłania i odbierania wiadomości z serwera WebSocket.
 *
 * Funkcja wywołuje następnie metodę connect() na obiekcie Stomp.
 * Metoda connect() przyjmuje jako argumenty dane do wysłania.
 * Dane te są obiektem zawierającym nazwę użytkownika i inne informacje.
 *
 * Metoda connect() również wywołuje dwie funkcje zwrotne: onConnected() i onError().
 * Funkcja onConnected() jest wywoływana po ustanowieniu połączenia.
 * Funkcja onError() jest wywoływana w przypadku niepowodzenia połączenia.
 *
 * @param e
 */
const connect = e => {
    username = document.querySelector('#name').value.trim();

    if(username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        const socket = new SockJS('/websocket');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    e.preventDefault();
}

const disconnect = e => {
    chatPage.classList.add('hidden');
    usernamePage.classList.remove('hidden');
    stompClient.connect({}, onDisconnected, onError)
}

/**
 * Funkcja onConnected() ukrywa wskaźnik ładowania i wyświetla wiadomości czatu.
 * @param options
 */
const onConnected = options => {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);
    stompClient.send("/app/chat.register", {}, JSON.stringify({sender: username, type: 'JOIN'}))
}

const onDisconnected = options => {
    stompClient.send("/app/chat.register", {}, JSON.stringify({sender: username, type: 'LEAVE'}))
}

/**
 * Funkcja onError() wyświetla komunikat błędu.
 *
 * @param e
 * @returns {Promise<void>}
 */
const onError = async e => {
    await toast('error', 'Nie można połączyć się z WebSocket! Odśwież stronę i spróbuj ponownie lub skontaktuj się z administratorem.');
}

/**
 * Ta funkcja jest wywoływana po kliknięciu przez użytkownika przycisku "Wyślij".
 * Najpierw funkcja pobiera treść wiadomości z pola tekstowego wprowadzoną przez użytkownika.
 * Jeśli treść wiadomości nie jest pusta, funkcja wysyła wiadomość do serwera WebSocket.
 *
 * Następnie funkcja czyści pole tekstowe wiadomości.
 *
 * @param event
 */

function send(event) {
    let content = messageInput.value.trim();

    if(content && null !== stompClient) {
        stompClient.send("/app/chat.send", {}, JSON.stringify({
            content,
            sender: username,
            type: 'CHAT',
            time: getCurrentTime()
        }));
        messageInput.value = '';
    }
    event.preventDefault();
}

async function onMessageReceived(payload) {
    const message = JSON.parse(payload.body);

    const chatEvent = async (event, type) => {
        await toast(type, event, 2000)
        return `
            <div class="chat-sap">
                <div class="chat-sap-meta"><span>${event}</span></div>
            </div>
        `
    }

    const chatMessage = (message) => `
        <div class="chat ${username === message.sender ? 'is-me' : 'is-you'}">
            <div class="chat-avatar">
                <div class="user-avatar fw-bold" style="background-color: ${getAvatarColor(message.sender)}">
                    <span>${message.sender.charAt(0).toUpperCase()}</span>
                </div>
            </div>
            <div class="chat-content">
                <div class="chat-bubbles">
                    <div class="chat-bubble">
                        <div class="chat-msg">${message.content}</div>
                    </div>
                </div>
                <ul class="chat-meta">
                    <li>${message.sender}</li>
                    <li><time>${message.time}</time></li>
                </ul>
            </div>
        </div>
    `

    switch (message.type) {
        case 'JOIN':
            messageArea.innerHTML += await chatEvent(`${message.sender} dołączył do czatu!`, 'success');
            break;
        case 'LEAVE':
            messageArea.innerHTML += await chatEvent(`${message.sender} opuścił czat!`, 'warning');
            break;
        default:
            messageArea.innerHTML += chatMessage(message)
            break;

    }

    messageArea.scrollTop = messageArea.scrollHeight;
}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', send, true)
disconnectButton.addEventListener('click', disconnect, true)