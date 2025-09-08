# 💰 Testes Automatizados com Selenium - Sr Barriga Website

- Mini-projeto de automação de testes utilizando o Selenium para o site Sr Barriga.

---

## ⚙️ Tecnologias utilizadas

- **Selenium** na versão `3.4.0`
- **Firefox** na versão `54.0.1`
- **GeckoDriver** na versão `0.18.0`
- **Java** na versão `8`
- **JUnit** na versão `4.0`
- **Maven**

---

## 📚 Documentações

- [Documentação Selenium](https://www.selenium.dev/pt-br/documentation/)

---

## ⚙️ Como configurar o ambiente

Abra um terminal e siga os passos abaixo:

 1. Clonar o repositório e acessar a pasta:

```bash
git clone https://github.com/Railson95/qa-srbarriga-selenium.git

```

2. Baixar e instalar o Firefox (Windows):

```bash
https://ftp.mozilla.org/pub/firefox/releases/54.0.1/
```

3. Baixar e linkar o GeckoDriver na versão correta:

```bash
https://github.com/mozilla/geckodriver/releases/tag/v0.18.0
```

## 🎨 Design Patterns:
- **Page Object Model**
- **Fluent Page** 
- **PageFactory**
- **DriverFactory** 

## 🧪 Testes

- **S1: Login**
  - **T1:** Realizar login com sucesso

- **S2: Add Conta**
  - **T1:** Realizar cadastro de conta com sucesso
  - **T2:** Não deve permitir cadastro de conta já existente

- **S3: Listar Contas**
  - **T1:** Deve permitir edição de conta com sucesso
  - **T2:** Não deve permitir remover conta com movimentação

- **S4: Movimentação**
  - **T1:** Deve permitir inserir movimentação com sucesso
  - **T2:** Verificar campos obrigatórios da movimentação
  - **T3:** Validar data da movimentação deve ser menor ou igual à data de pagamento
  - **T4:** Deve remover movimentação com sucesso
 
✍️ Autor
Railson Martins da Mata
Este projeto tem fins educacionais e foi desenvolvido com foco em práticas de automação de testes com o framework Selenium
