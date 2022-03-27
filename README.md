<h1 align="center">Welcome to Logistic API  - log-api 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000" />
  <img src="https://img.shields.io/badge/react-16.8.x-blue.svg" />
  <a href="https://github.com/fncarneiro/log-api#readme" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="https://github.com/fncarneiro/log-api/graphs/commit-activity" target="_blank">
    <img alt="Maintenance" src="https://img.shields.io/badge/Maintained%3F-yes-green.svg" />
  </a>
  <a href="https://github.com/fncarneiro/log-api/blob/master/LICENSE" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/github/license/fncarneiro/log-api" />
  </a>
  <a href="https://twitter.com/o_fe" target="_blank">
    <img alt="Twitter: o_fe" src="https://img.shields.io/twitter/follow/o_fe.svg?style=social" />
  </a>
</p>
 
<p>
 <a href="https://www.alura.com.br/">
  <img src="https://d33wubrfki0l68.cloudfront.net/2359587f235e61ccc3f3f9a3d132b45b57d2ef31/4cb42/images/logo-algaworks-branca.ae0f45976bd5c78bfc021f52315f13f6bf4b7044956411f0f75fbf33fdb13038.png" class="page-image__logo__algaworks" alt="AlgaWorks Logo">    
  <br>
  Project to study Java Spring Rest API. Developed during the Java Spring Rest API course from AlgaWorks.
 </a>
</p> 

## Prerequisites

- Java: 11
- SpringBoot: ^2.6.2
- lombok: last version
- MySql: last version
- Flywaydb: last version
- ModelMapper: ^3.0.0

## Install

```sh
import maven project pom.xml
```

## Usage

```sh
run project and send http verbs using App like Postman (https://www.postman.com/).
```

### Endpoints

#### Clientes

Listar - get localhost:8080/clientes
Buscar por Id - get - localhost:8080/clientes/{Id}
Incluir - post - localhost:8080/clientes 
    body type json example - 
    {   
    "nome": "Name",
    "telefone": "84 98804-8311",
    "email": "fn2@gmail.com"
    }

Alterar - put - localhost:8080/clientes/{Id}
    body type json example - 
    {   
    "nome": "Jhon",
    "telefone": "84 98804-8311",
    "email": "fn2@gmail.com"
    }

Excluir - delete - localhost:8080/clientes/{Id}

#### Entregas

Listar - get - localhost:8080/entregas
Buscar por Id - get - localhost:8080/entregas/{Id}
Incluir - post - localhost:8080/entregas
    body type json example - 
    {   
    "cliente":{
        "id":2
    },
    "destinatario":{
        "nome": "Joaquim da Silva",
        "logradouro": "Rua des regulo tinoco",
        "numero": 1319,
        "complemento": "apto 801",
        "bairro": "Tirol"
    },
    "taxa": 100.50
}
Finalizar - put - localhost:8080/entregas/{Id}/finalizacao

#### Ocorrências

Listar - get - localhost:8080/entregas/{Id}/ocorrencias
Registrar - post - localhost:8080/entregas/{Id}/ocorrencias   
    body type json example - 
    {
    "descricao": "Tentativa sem sucesso (não estava em casa)"
    }

## Run tests

no tests yet

## Author

👤 **Fernando N Carneiro**

* Twitter: [@o\_fe](https://twitter.com/o\_fe)
* Github: [@fncarneiro](https://github.com/fncarneiro)
* LinkedIn: [@fncarneiro](https://linkedin.com/in/fncarneiro)

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page](https://github.com/fncarneiro/my-invest-server/issues). You can also take a look at the [contributing guide](https://github.com/fncarneiro/my-invest-server/blob/master/CONTRIBUTING.md).

## Show your support

Give a ⭐️ if this project helped you!

## 📝 License

Copyright © 2022 [Fernando N Carneiro](https://github.com/fncarneiro).<br />
This project is [MIT](https://github.com/fncarneiro/log-api/blob/master/LICENSE) licensed.
