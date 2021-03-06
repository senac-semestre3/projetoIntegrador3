## Projeto Integrador 3 - Sistema para Gestão de loja

### Empresa Rainha da Sucata


###### Estrutura de Pastas
```
rainhadasucata
|__src
|   |__main
|        |__java
|        |     |__br
|        |         |__onevision
|        |              |__rainhadasucata
|        |                           |__controller
|        |                           |__model
|        |__resources
|        |__webapp
|               |__META-INF
|               |__WEB-INF
|               |__dist
|               |    |__css
|               |    |__fonts
|               |    |__imagens
|               |    |__js
|               |__resources
|               |        |__javascript
|               |        |__sass
|               |            |__comum
|               |__index.jsp
|__bower.json
|__gulpfile.js
|__nb-configuration
|__package.json
|__pom.xml
```

### Included libraries
- jQuery 2.1.1
- MaterializeCSS framework
- font-awesome framework

### Como usar

#### Requisitos mínimos:

1. git (https://git-scm.com/)
2. Node Package Manager (http://nodejs.org/)
3. Bower (http://bower.io) `npm install -g bower`
4. Gulp CLI (http://gulpjs.com/)`npm install -g gulp-cli`

#### Seguir o passo-a-passo para configurar o git em sua máquina:

 1. Baixe o git (https://git-scm.com/) e instale
 2. configurar o nome ` git config --global user.name "Seu Nome" `
 3. configurar o e-mail `git config --global user.email "seu_email" `.
 
#### Seguir o passo-a-passo para configurar o projeto:
 
1. Clone esse repositório (`git clone https://github.com/senac-semestre3/projetoIntegrador3.git`)
2. acesse o projeto que clonou e entre na pasta rainhadasucata(onde contem os arquivos bower.json, gulpfile.js, etc...)
3. Digite `npm install` para instalar os pacotes "Node" exigidos pelo projeto
4. Digite `bower install` para instalar os pacotes "Bower" exigidos pelo projeto
5. Inicialize o gulp `gulp`.
6. O gulp compila o sass para o css.

### Importante:
- Os arquivos que serão programados em sass terão extensão .scss
- Os arquivos sass deverão ser programados apenas nas seguintes pastas
- - (rainhadasucata/src/main/webapp/resources/sass/components)
- - (rainhadasucata/src/main/webapp/resources/sass/components/comum)
- Os arquivos deverão começar com _(underline). ex: _topo.scss
