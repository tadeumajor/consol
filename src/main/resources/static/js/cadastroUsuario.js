function postUsuario () {
    let cpf = document.getElementById('cpfCadastro').value;
    let fone = document.getElementById('foneCadastro').value;
    let nome = document.getElementById('nomeCadastro').value;
    let email = document.getElementById('emailCadastro').value;
    let senha = document.getElementById('senhaCadastro').value;
    let num_ap = document.getElementById('numApCadastro').value;

    let xhr = new XMLHttpRequest ();
    // xhr.onload = exibeMaisFilmes;
    xhr.open ('POST', 'http://localhost:8080/usuarios');
    xhr.setRequestHeader('Content-type', 'application/json');

    xhr.send (
`{
        "nomeMorador": "${nome}",
        "cpf": "${cpf}",
        "email": "${email}",
        "password": "${senha}",
        "telContato": "${fone}",
        "numAp": "${num_ap}"
        }`
    );
}

document.getElementById('btnCadastrarUsuario').addEventListener('click', postUsuario);