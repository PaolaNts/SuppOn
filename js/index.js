function loginHandler() {
    event.preventDefault(); // Impede o envio padrão do formulário

    // Obter elementos do formulário
    const emailElement = document.getElementById("email");
    const passwordElement = document.getElementById("password");

    // Obter valores dos elementos
    const emailValue = emailElement.value;
    const passwordValue = passwordElement.value;

    // Formatar dados em JSON
    const formData = {
        useremail: emailValue,
        password: passwordValue
    };

    // Enviar dados para o backend (você precisará implementar essa parte)
    // Exemplo de como você poderia usar fetch para enviar dados para o servidor:
    fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        // Lida com a resposta do backend
        console.log(data);
        // Adicione lógica adicional conforme necessário
    })
    .catch(error => {
        console.error("Erro durante a solicitação:", error);
    });
}

// Adicionar um ouvinte de evento ao formulário para chamar a função loginHandler no envio
const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", loginHandler);