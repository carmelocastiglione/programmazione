---
layout: page
title: Hello world
---
<div class="container">
  <h1 class="heading">{{ page.collection | upcase }}</h1>
  <h2 class="heading">{{ page.title }}</h2>
  <p>L'HTML consiste in una serie di elementi racchiusi spesso in tag di apertura e di chiusura, come in questo esempio:</p>
  {% highlight html %}
  <p class="text">Il mio gatto è molto scontroso</p>{% endhighlight %}
  <ul>
    <li><strong>Elemento</strong>: E' rappresentato da tutta la linea di codice sopra</li>
    <li><strong>Attributo</strong>: Sono delle informazioni aggiuntive associate all'elemento. In questo caso l'attributo è class. Possono esserci più attributi.</li>
    <li><strong>Tag apertura</strong>: La p iniziale, che rappresenta il paragrafo</li>
    <li><strong>Tag chiusura</strong>: La p finale</li>
    <li><strong>Contenuto</strong>: Tutto ciò che è contenuto tra i due tag</li>
  </ul>
  <p>E' possibile inserite tag HTML dentro altri tag:</p>
  {% highlight html %}
  <p>Il mio gatto è <strong>molto</strong> scontroso</p>{% endhighlight %}
  <p>I singoli elementi sono contenuti all'interno di una pagina HTML completa che può essere rappresentata con il codice sottostante:</p>
  {% highlight html %}
  <!DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
      </head>
    <body>
      Hello world!
    </body>
  </html>{% endhighlight %}
  <ul>
    <li><strong>doctype</strong>: indica il tipo di documento</li>
    <li><strong>html</strong>: è il tag "radice" dal quale si diramano tutti gli altri tag</li>
    <li><strong>head</strong>: tutto ciò che non rappresenta il contenuto della pagina (keyword, fogli di stile, etc)</li>
    <li><strong>meta</strong>: sono dei metadati. Il charset è il set di caratteri, il viewport è necessario per realizzare pagine web responsive</li>
    <li><strong>title</strong>: titolo della pagina. Viene visualizzato come titolo della scheda</li>
    <li><strong>body</strong>: qui va inserito il contenuto della pagina</li>
  </ul>
  <p>I commenti vanno scritti come nell'esempio:</p>
  {% highlight html %}
  <p>Il non sono un commento</p>
  <!-- <p>Io sono un commento</p> -->{% endhighlight %}
  <h2>Esercizi</h2>
  <ol>
    <li>Scrivere la frase "Sto imparando l'HTML" in corsivo tramite il tag <em>em</em></li>
    <li>Scrivere la frase "Questa è la mia prima pagina HTML" all'interno di una pagina HTML completa. Salvare la pagina come <em>index.html</em></li>
  </ol>
</div>