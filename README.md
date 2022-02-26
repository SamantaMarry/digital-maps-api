<h1 align="center">DigitalMaps - API :octocat: </h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0.0-green.svg?cacheSeconds=2592000" />
</p>

# Digital Maps

## Proposta do teste

Você deverá criar um serviço que permita a inserção de novas localizações de ponto
de interesse. Exemplo:
<br/>
Posto de combustível, restaurante, parque ecológico, praça etc.
<br/>
<br/>
O serviço deve além disso, permitir a inserção das coordenadas geográficas
referentes à este ponto de interesse (X e Y) e horário de funcionamento (abertura e
fechamento).

- Obs1: Coordenadas devem ser números inteiros positivos.
- Obs2: Estas informações devem ser armazenadas em uma base dados qualquer.
- Obs3: Para pontos como a praça, não deve haver horário de funcionamento.

O serviço deve permitir a listagem de todos os pontos de interesse cadastrados.
<br/>
<br/>
O serviço deve permitir a listagem de todos os pontos de interesse por proximidade, ou seja, fornecendo as coordenadas X e Y, a distância em metros e hora atual.
<br/>
<br/>
Exemplo:
<br/>
<br/>Dados:
Restaurante (x=27, y=12, opened=12:00, closed=18:00)
<br/>
Posto de combustível (x=31, y=18, opened=08:00, closed=18:00)
<br/>
Praça (x=15, y=12)
<br/>
<br/>
Entrada:
x=20, y=10, mts=10, hr=19:00
<br/>
<br/>Saída:
Restaurante, fechado
Praça, aberto

## Rodando o projeto


Para rodar o projeto, é necessário ter uma instância do mongodb na porta 27017

1. Clonar o repositório;
2. Abrir IDE na pasta do projeto e rodar;
3. Fazer requisição:


### Exemplo utilizando Postman

### Criando um ponto de interesse

```curl
curl --location --request POST 'http://localhost:8080/interest-point' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Farmácia",
    "latitude": 31,
    "longitude": 17,
    "opened": "12:00",
    "closed": "18:00"
}'
```

### Listando os pontos de interesse

```curl
curl --location --request GET 'http://localhost:8080/interest-point'
```

### Buscando pontos de interesse pela proximidade

```curl
curl --location --request GET 'http://localhost:8080/interest-point/nearest?latitude=31&longitude=16&distanceInMeters=200000&hours=13:00
```

## Author

:raising_hand_woman: **Samanta Marry**

* Github: [@samantamarry](https://github.com/samantamarry)
