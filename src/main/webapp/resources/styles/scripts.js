// Este arquivo scripts.js pode conter código JavaScript para interação na interface,
// como validações de formulários ou chamadas AJAX. Aqui você pode adicionar suas implementações conforme necessário.
// Exemplo de validação básica de formulário:

document.getElementById('formProjeto').addEventListener('submit', function(event) {
    var titulo = document.getElementById('titulo').value.trim();
    var descricao = document.getElementById('descricao').value.trim();

    if (titulo === '' || descricao === '') {
        alert('Por favor, preencha todos os campos.');
        event.preventDefault(); // Impede o envio do formulário se os campos não estiverem preenchidos
    }
});
