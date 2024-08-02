async function fetchContacts() {
    try {
        const response = await fetch('http://localhost:8080/contatos');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const contacts = await response.json();
        displayContacts(contacts);
    } catch (error) {
        console.error('Erro ao buscar contatos:', error);
    }
}

function displayContacts(contacts) {
    const contactList = document.getElementById('contact-list');
    contactList.innerHTML = '';

    contacts.forEach(contact => {
        const contactDiv = document.createElement('div');
        contactDiv.className = 'contact';
        contactDiv.innerHTML = `
            <p>ID: ${contact.id}</p>
            <p>Nome: ${contact.nomeContato}</p>
            <p>Apelido: ${contact.apelido}</p>
            <p>Telefone: ${contact.telefone}</p>
            <p>Email: ${contact.email}</p>
        `;
        contactList.appendChild(contactDiv);
    });
}
