---
layout: page
title: Metadata
---
<div class="container">
  <h1 class="heading">{{ page.collection | upcase }}</h1>
  <h2 class="heading">{{ page.title }}</h2>
  <p>I browser web utilizzano i metadata per renderizzare correttamente il contenuto di una pagina web. Come abbiamo visto precedentemente, una pagina web ha come struttura minima:</p>
  {% highlight html %}
  <!doctype html>
    <html lang="en-US">
        <head>
            <meta charset="utf-8" />
            <title>My test page</title>
        </head>
        <body>
            <p>This is my page</p>
        </body>
    </html>{% endhighlight %}
  <p>Tutto ciò che è compreso all'interno del tag head non è visualizzato come contenuto della pagina.</p>
  <h3>Aggiungere un titolo</h3>
  <p>Il titolo del documento HTML va inserito all'interno del tag title, nell'head. Non bisogna confondersi con il titolo della pagina (che può essere visualizzato all'utente). In quel caso, bisognerebbe inserirlo all'interno del tag h1, nel body</p>
  {% highlight html %}
  <title>My test page</title>{% endhighlight %}
  <h3>Specificare il set di caratteri</h3>
  {% highlight html %}
  <meta charset="utf-8" />{% endhighlight %}
  <h3>Aggiungere un autore e una descrizione</h3>
  {% highlight html %}
  <meta name="author" content="Carmelo Castiglione" />
  <meta name="description" content="Questo è un sito dove racconto quelle poche cose che so sull'informatica" />{% endhighlight %}
  <h3>Aggiungere un'icona nella scheda</h3>
  {% highlight html %}
  <link rel="icon" href="favicon.ico" type="image/x-icon" />{% endhighlight %}
  <h3>Aggiungere fogli di stile (CSS) e file JavaScript</h3>
  {% highlight html %}
  <link rel="stylesheet" href="stylesheet.css" />
  <script src="javascript.js" defer></script>{% endhighlight %}
  <h3>Cambiare la lingua del sito</h3>
  {% highlight html %}
  <html lang="it-IT">
  …
  </html>{% endhighlight %}

</div>