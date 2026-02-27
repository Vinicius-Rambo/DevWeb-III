
PDF da aula:
[[WebIII02.pdf]]

---

# Arquitetura da Web

## Modelo Cliente-Servidor

A Web funciona no modelo cliente-servidor.

Fluxo básico:

1. Cliente faz uma requisição.    
2. Servidor recebe e processa.
3. Servidor envia uma resposta.

Representação:

Cliente → Requisição HTTP → Servidor  
Servidor → Resposta HTTP → Cliente

O servidor não envia dados sem que o cliente solicite.

---
# Diferença entre Internet e Web

##### Internet:

- Infraestrutura física e lógica.
- Baseada em TCP/IP.
- Conecta redes no mundo todo.

##### Web:

- Sistema que roda sobre a internet.
- Usa HTTP, URLs e HTML.
- Proposta em 1990 por Tim Berners-Lee.
---
# Breve Histórico

1957 — Lançamento do Sputnik.  
1958 — Criação da DARPA.  
1969 — ARPANET entra em funcionamento.  
1973 — Desenvolvimento do TCP/IP.  
1983 — TCP/IP se torna padrão.  
1990 — Proposta da World Wide Web.

Definições criadas nesse período:

- HTTP
- URL
- HTML
---
# Modelo TCP/IP

A comunicação na internet ocorre em camadas:

1. Aplicação (HTTP, HTTPS, DNS)
2. Transporte (TCP, UDP)
3. Internet (IP, ICMP)
4. Rede/Física (Ethernet, Wi-Fi, Fibra)

---

# Como uma Requisição Funciona

##### Exemplo:
Usuário acessa:

`https://www.exemplo.com/gatinho.jpg`

Etapas:

1. DNS converte domínio em IP.
2. TCP estabelece conexão (handshake).
3. Navegador envia requisição HTTP.
4. Pacotes são roteados via IP.
5. Dados trafegam pelo meio físico.
6. Servidor responde.
7. Navegador monta e exibe o conteúdo.
---

# Handshake TCP

Processo de três etapas:

1. Cliente envia SYN.
2. Servidor responde SYN-ACK.
3. Cliente envia ACK.

Conexão estabelecida.

---

# Estrutura de uma Requisição HTTP

Modelo geral:
```
[MÉTODO] [URI] HTTP/[VERSÃO]  
[CABEÇALHOS]  
[CORPO]
```
Exemplo:
```
`GET / HTTP/1.1 
Host: example.com 
User-Agent: curl/7.81.0 
Accept: */*`
```

Elementos principais:

- Método (GET, POST, etc.)
- URL
- Versão do protocolo
- Headers
- Body (opcional)

---

# Estrutura da Resposta HTTP

Modelo:
```
HTTP/[VERSÃO] [STATUS CODE]  
[CABEÇALHOS] 
[CORPO]
```
Exemplo:
```
HTTP/1.1 200 OK 
Content-Type: text/html 
Content-Length: 1256
```

Componentes:

- Código de status
- Cabeçalhos
- Corpo da resposta (HTML, JSON, imagem, etc.)

---

# Métodos HTTP

Principais métodos:

* GET  
* POST  
* PUT  
* DELETE  
* PATCH  
* OPTIONS

### GET

- Busca recurso.
- Parâmetros na URL.

### POST

- Envia dados.
- Dados no corpo da requisição.

---

# Códigos de Status

200 — Sucesso  
301 — Redirecionamento  
404 — Não encontrado  
500 — Erro interno do servidor

Referência visual:  
[https://http.cat/](https://http.cat/)

---

# Testando HTTP com CURL

CURL é cliente HTTP de linha de comando.

Requisição simples:

`curl https://example.com`

Modo detalhado:
`curl -v https://example.com`

Requisição local:
`curl http://localhost:8080`

Enviando JSON:

`curl -d '{ "title": "test product", "price": 13.5 }' \ -H "Content-Type: application/json" \ https://fakestoreapi.com/products`

---

# Limitação do HTTP

O protocolo HTTP é baseado em requisição-resposta.
Servidor não envia dados espontaneamente.
Soluções modernas:

- AJAX polling
- Fetch API
- WebSockets
- Long polling
---

# Servidores Web

Servidor Web é responsável por responder requisições HTTP.

Exemplos:

- Apache
- Nginx

Funções comuns:

- Encaminhar requisições
- Balanceamento de carga
- Controle de conexões
- SSL/TLS (HTTPS)
- Cache
- Redirecionamento e URL amigável
- Firewall e restrição de IP
---